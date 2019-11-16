package com.tidc.consumer8001.controller;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.MessageManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae MessageManager
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class MessageManagerController {
	@Autowired
	private MessageManagerService messageManagerService;
	/**
	 * 查看个人的消息列表
	 * @param access_token
	 * @return
	 */
	@RequestMapping(value = "/message/all",method = RequestMethod.GET)
	UserOV<List<Message>> checkMessage( String access_token){
		return messageManagerService.checkMessage(access_token);
	}

	/**
	 * 将某条消息设为已读
 	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/message/read",method = RequestMethod.PUT)
	UserOV readMessage(@RequestParam("id") int id){
		return messageManagerService.readMessage(id);
	}

	/**
	 * 将某个用户的所有消息设为已读
	 * @param access_token
	 * @return
	 */
	@RequestMapping(value = "/message/read/all",method = RequestMethod.PUT)
	UserOV readMessageAll( String access_token){
		return messageManagerService.readMessageAll(access_token);
	}

	/**
	 * 获取某个账号的请求列表
	 * @param access_token
	 * @return
	 */
	@RequestMapping(value = "/apply/all",method = RequestMethod.GET)
	UserOV<List<Apply>> checkApply( String access_token){
		return messageManagerService.checkApply(access_token);
	}

	/**
	 * 审批某个账号的某条记录
	 * @param apply Proposer_email id is_read
	 * @return
	 */
	@RequestMapping(value = "/apply/read",method = RequestMethod.PUT)
	public UserOV approvalApply(Apply apply){
		return messageManagerService.approvalApply(apply);
	}
}
