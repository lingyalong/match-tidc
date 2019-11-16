package com.tidc.messagemanager.controller;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	/**
	 * 查看个人的消息列表
	 * @param receiver_email
	 * @return
	 */
	@GetMapping("/message/all")
	public UserOV<List<Message>> checkMessage(String receiver_email){
		return checkService.checkMessage(receiver_email);
	}

	/**
	 * 将某条信息设为已读
	 * @param id
	 */
	@PutMapping("/message/read")
	public UserOV readMessage(@RequestParam("id") int id){
		return checkService.readMessage(id);
	}

	/**
	 * 将某个用户的所有信息设为已读
	 * @param receiver_email
	 */
	@PutMapping("/message/read/all")
	public UserOV readMessageAll(String receiver_email){
		return checkService.readMessageAll(receiver_email);
	}

	/**
	 * 查看账号所接收到的申请
	 * @param acceptor_email
	 * @return
	 */
	@GetMapping("/apply/all")
	public UserOV<List<Apply>> checkApply(String acceptor_email){
		return checkService.checkApply(acceptor_email);
	}

}
