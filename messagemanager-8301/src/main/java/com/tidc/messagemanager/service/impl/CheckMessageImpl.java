package com.tidc.messagemanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
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
	@Override
	public UserOV<List<Message>> checkMessage(String receiver_email) {
		UserOV<List<Message>> userOV = new UserOV<>();
		userOV.setData(messageMapper.listMessage(receiver_email)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}
}
