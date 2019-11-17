package com.tidc.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.tidc.api.controller.MessageManagerApi;
import com.tidc.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @ClassNmae MessageConsumer
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class MessageConsumer {
	@Autowired
	private MessageManagerApi messageManagerApi;
	public static String SEND_MESSAGE_QUEUES = "sendMessage";
	public static String SEND_LIST_MESSAGE_QUEUES = "sendListMessage";

	@RabbitListener(queues = "sendMessage")
	@RabbitHandler //标识接收到消息之后处理方法
	public void sendMessage(com.tidc.api.pojo.Message msg,Channel channel, Message message) throws IOException {
		try {
			channel.basicQos(1);
			messageManagerApi.sendMessage(msg);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
		}

	}

	@RabbitListener(queues = "sendMessage")
	@RabbitHandler
	public void sendListMessage(List<com.tidc.api.pojo.Message> list, Channel channel, Message message) throws IOException {
		try {
			channel.basicQos(1);
			for (com.tidc.api.pojo.Message msg : list) {
				messageManagerApi.sendMessage(msg);
			}
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch (IOException e) {
			// 拒绝当前消息，并把消息返回原队列
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
		}

	}
}
