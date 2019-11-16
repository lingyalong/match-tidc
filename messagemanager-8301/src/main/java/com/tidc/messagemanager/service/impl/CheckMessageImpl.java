package com.tidc.messagemanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.mapper.ApplyMapper;
import com.tidc.messagemanager.mapper.MessageMapper;
import com.tidc.messagemanager.service.CheckService;
import com.tidc.messagemanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae CheckMessageImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class CheckMessageImpl implements CheckService {
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private ApplicationContextProvider ac;
	@Autowired
	private ApplyMapper applyMapper;
	@Autowired
	private UserManagerApi userManagerApi;
	@Override
	public UserOV<List<Message>> checkMessage(String receiver_email) {
		UserOV<List<Message>> userOV = new UserOV<>();
		userOV.setData(messageMapper.listMessage(receiver_email)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV readMessage(int id) {
		messageMapper.updateMessageRead(id);
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}

	@Override
	public UserOV readMessageAll(String receiver_email) {
		messageMapper.updateMessageReadAll(receiver_email);
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}

	@Override
	public UserOV<List<Apply>> checkApply(String acceptor_email) {
		List<Apply> applies = applyMapper.listApply(acceptor_email);
		UserOV<List<Apply>> userOV = new UserOV<>();
		userOV.setStatus(CodeConstant.SUCCESS).setData(applies);
		return userOV;
	}


}
