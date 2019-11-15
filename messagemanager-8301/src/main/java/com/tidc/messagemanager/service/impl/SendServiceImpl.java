package com.tidc.messagemanager.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
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
		return userOV.setStatus(CodeConstant.SUCCESS);
	}
}
