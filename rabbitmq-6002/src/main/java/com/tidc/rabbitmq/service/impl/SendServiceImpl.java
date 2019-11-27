package com.tidc.rabbitmq.service.impl;

import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.Message;
import com.tidc.rabbitmq.config.RabbitConfig;
import com.tidc.rabbitmq.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae SendServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class SendServiceImpl implements SendService {
	@Autowired
	private MessageManagerApi messageManagerApi;
	@Autowired
	AmqpTemplate amqpTemplate;
	/**
	 * @Description: 发送消息
	 * 1.交换机
	 * 2.key
	 * 3.消息
	 * 4.消息ID
	 * rabbitTemplate.send(message);   发消息;参数对象为org.springframework.amqp.core.Message
	 * rabbitTemplate.convertAndSend(message); 转换并发送消息;将参数对象转换为org.springframework.amqp.core.Message后发送,消费者不能有返回值
	 * rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息.消费者可以有返回值
	 * @method: handleMessage
	 * @Param: message
	 * @return: void
	 * @auther: LHL
	 * @Date: 2018/11/18 21:40
	 */
	@Override
	public void sendMessage(Message message) {
		amqpTemplate.convertAndSend(RabbitConfig.SEND_MESSAGE_QUEUES,message);
	}

	@Override
	public void sendListMessage(Map map) {
		amqpTemplate.convertAndSend(RabbitConfig.SEND_LIST_MESSAGE_QUEUES,map);
	}

	@Override
	public void deleteFile(String path) {
		amqpTemplate.convertAndSend(RabbitConfig.DELETE_FILE,path);
	}

}
