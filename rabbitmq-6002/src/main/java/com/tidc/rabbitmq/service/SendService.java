package com.tidc.rabbitmq.service;

import com.tidc.api.pojo.Message;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface SendService {
	void sendMessage(Message message);
	void sendListMessage(Map map);
	void deleteFile(String path);
}
