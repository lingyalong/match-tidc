package com.tidc.messagemanager.service.impl;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.enummanager.HttpEnum;
import com.tidc.messagemanager.mapper.MessageMapper;
import com.tidc.messagemanager.pojo.Message;
import com.tidc.messagemanager.service.SendService;
import com.tidc.messagemanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private ApplicationContextProvider ac;
	@Override
	public UserOV teacherApproveMessage(String schoolEmail, String teacherEmail) {
		UserOV userOV = new UserOV();
		Message message = ac.getBean(Message.class);
		UserOV userOV2 = userManagerApi.userInfo(teacherEmail);
		Teacher teacher = (Teacher) userOV2.getData();
		message.setHead(teacher.getName()+"申请学校认证");
		message.setIs_read(0);
		message.setMessage("姓名:"+teacher.getName()+"身份证号:"+teacher.getIdEntity());
		message.setReceiver_email(schoolEmail);
		messageMapper.insertMessage(message);
		return userOV.setStatus(HttpEnum.SUCCEED);
	}
}
