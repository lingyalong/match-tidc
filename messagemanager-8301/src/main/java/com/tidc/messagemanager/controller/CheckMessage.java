package com.tidc.messagemanager.controller;

import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNmae CheckMessage
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class CheckMessage {
	@Autowired
	private CheckService checkService;
	@GetMapping("/message/list")
	public UserOV<List<Message>> checkMessage(String receiver_Messag){
		return checkService.checkMessage(receiver_Messag);
	}

}
