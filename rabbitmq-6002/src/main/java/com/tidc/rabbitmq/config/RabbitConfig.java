package com.tidc.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * @ClassNmae RabbitConfig
 * @Description TODO
 * @Author 冯涛滔
 **/
@Configuration
public class RabbitConfig {
	//分配队列
	public static String SEND_MESSAGE_QUEUES = "sendMessage";
	public static String SEND_LIST_MESSAGE_QUEUES = "sendListMessage";
	public static String DELETE_FILE = "deleteFile";
	public static String DELETEWORKANDTEAM = "deleteWorkAndTeam";
	public static String FOUNDHISTORYEXAMINATION = "foundHistoryExamination";
	public static String HISTORYJOINQUESTION = "historyJoinQuestion";
	//配置
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	//队列声明
	@Bean("sendMessage")
	public Queue sendMessage(){
		return new Queue(SEND_MESSAGE_QUEUES);
	}
	@Bean("sendListMessage")
	public Queue sendListMessage(){
		return new Queue(SEND_LIST_MESSAGE_QUEUES);
	}
	@Bean("deleteFile")
	public Queue deleteFile(){return new Queue(DELETE_FILE);}
	@Bean("deleteWorkAndTeam")
	public Queue deleteContestWork(){
		return new Queue(DELETEWORKANDTEAM);
	}
	@Bean("foundHistoryExamination")
	public Queue foundHistoryExamination(){
		return new Queue(FOUNDHISTORYEXAMINATION);
	}
	@Bean("historyJoinQuestion")
	public Queue historyJoinQuestion(){
		return new Queue(HISTORYJOINQUESTION);
	}

}
