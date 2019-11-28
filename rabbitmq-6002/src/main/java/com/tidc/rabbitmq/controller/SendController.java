package com.tidc.rabbitmq.controller;

import com.tidc.api.pojo.Message;
import com.tidc.rabbitmq.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
	public void sendListMessage(@RequestBody Map map){
		sendService.sendListMessage(map);
	}

	@PostMapping("/delete/file")
	public void deleteFile(@RequestParam("path") String path){
		sendService.deleteFile(path);
	}

	@PostMapping("/delete/contest/work/team")
	public void deleteWorkANdTeam(@RequestParam("contestId") int contestId){
		sendService.deleteWorkANdTeam(contestId);
	}

}
