package com.tidc.messagemanager.service;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;

import java.util.List;

/**
 * @ClassNmae CheckService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckService {
	UserOV<List<Message>> checkMessage(String Receiver_email);
	UserOV readMessage(int id);
	UserOV readMessageAll(String receiver_email);
	UserOV<List<Apply>> checkApply(String acceptor_email);

}
