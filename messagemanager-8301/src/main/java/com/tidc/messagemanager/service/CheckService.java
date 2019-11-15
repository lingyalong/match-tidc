package com.tidc.messagemanager.service;

import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;

import java.util.List;

/**
 * @ClassNmae CheckService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckService {
	public UserOV<List<Message>> checkMessage(String Receiver_email);
}
