package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.MessageManagerService;
import com.tidc.consumer8001.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae MessageManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class MessageManagerServiceImpl implements MessageManagerService {
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private MessageManagerApi messageManagerApi;
	@Override
	public UserOV<List<Message>> checkMessage(HttpServletRequest req) {
		String email = userInfo.getUserName(req);
		UserOV<List<Message>> userOV = messageManagerApi.checkMessage(email);
		return userOV;
	}

	@Override
	public UserOV readMessage(int id) {
		return messageManagerApi.readMessage(id);
	}

	@Override
	public UserOV readMessageAll(HttpServletRequest req) {
		String email = userInfo.getUserName(req);
		UserOV userOV = messageManagerApi.readMessageAll(email);
		return userOV;
	}

	@Override
	public UserOV<List<Apply>> checkApply(HttpServletRequest req) {
		String email = userInfo.getUserName(req);
		UserOV<List<Apply>> userOV = messageManagerApi.checkApply(email);
		return userOV;
	}

	@Override
	public UserOV approvalApply(Apply apply) {
		return messageManagerApi.approvalApply(apply);
	}
}
