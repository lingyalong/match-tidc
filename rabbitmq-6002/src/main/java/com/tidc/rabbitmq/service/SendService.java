package com.tidc.rabbitmq.service;

import com.tidc.api.pojo.Message;

import java.util.List;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface SendService {
	public void sendMessage(Message message);
	public void sendListMessage(List<Message> list);
}
