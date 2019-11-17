package com.tidc.rabbitmq.controller;

import com.tidc.api.pojo.Message;
import com.tidc.rabbitmq.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNmae SendController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class SendController {
	@Autowired
	private SendService sendService;
	@PostMapping("/send/message")
	public void sendMessage(@RequestBody  Message message){
		sendService.sendMessage(message);
	}
	@PostMapping("/send/list/message")
	public void sendListMessage(List<Message> list){
		sendService.sendListMessage(list);
	}

}
