package com.tidc.messagemanager.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.messagemanager.mapper.ApplyMapper;
import com.tidc.messagemanager.mapper.MessageMapper;
import com.tidc.messagemanager.service.SendService;
import com.tidc.messagemanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassNmae SendServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class SendServiceImpl implements SendService {
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ApplicationContextProvider ac;
	@Autowired
	private ApplyMapper applyMapper;
	@Override
	public UserOV teacherApproveMessage(String schoolEmail, String teacherEmail) {
		UserOV userOV = new UserOV();
		Message message = ac.getBean(Message.class);
		UserOV userOV2 = userManagerApi.userInfo(teacherEmail);
		LinkedHashMap data = (LinkedHashMap) userOV2.getData();
		Teacher teacher = objectMapper.convertValue(data, new TypeReference<Teacher>() {});
		message.setHead(teacher.getName()+"申请学校认证");
		message.setIs_read(0);
		message.setMessage("姓名:"+teacher.getName()+"身份证号:"+teacher.getIdEntity());
		message.setReceiver_email(schoolEmail);
		messageMapper.insertMessage(message);
		//插入一条申请
		Apply apply = ac.getBean(Apply.class);
		//老师请求学校认证
		apply.setApplication_type(1);
		//受理学校
		apply.setAcceptor_email(schoolEmail);
		//申请人
		apply.setProposer_email(teacherEmail);
		apply.setIs_read(-1);
		//插入一条请求
		applyMapper.insertApply(apply);
		return userOV.setStatus(CodeConstant.SUCCESS);
	}

	@Override
	public UserOV sendMessage(Message message) {
		messageMapper.insertMessage(message);
		return null;
	}

	@Override
	public UserOV sendSchoolMessage(int id, String message) {
		//获取所有的该学校学生
		UserOV<List<Student>> userOV = userManagerApi.listSchoolStudent(id);
		Message msg = ac.getBean(Message.class);
		msg.setHead("你的学校发布了一个比赛");
		msg.setMessage(message);
		msg.setIs_read(0);
		for (Student student : userOV.getData()) {
			msg.setReceiver_email(student.getEmail());
			messageMapper.insertMessage(msg);
		}
		userOV.setStatus(CodeConstant.SUCCESS);
		return userOV;
	}
}
