package com.tidc.api.controller;

import com.tidc.api.fallback.MessageManagerFallbackFactory;
import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae SendManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "MESSAGEMANAGER",fallbackFactory = MessageManagerFallbackFactory.class)
public interface MessageManagerApi {
	@RequestMapping(value = "/teacher/approve",method = RequestMethod.POST)
	UserOV teacherApproveMessage(@RequestParam("schoolEmail") String schoolEmail, @RequestParam("teacherEmail") String teacherEmail);

	/**
	 * 查看个人消息
	 * @param receiver_email
	 * @return
	 */
	@RequestMapping(value = "/message/all",method = RequestMethod.GET)
	UserOV<List<Message>> checkMessage(@RequestParam("receiver_email") String receiver_email);

	/**
	 * 将某条信息设为已读
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/message/read",method = RequestMethod.PUT)
	UserOV readMessage(@RequestParam("id") int id);

	/**
	 * 将某个用户的所有信息设未已读
	 * @param receiver_email
	 * @return
	 */
	@RequestMapping(value = "/message/read/all",method = RequestMethod.PUT)
	UserOV readMessageAll(@RequestParam("receiver") String receiver_email);

	/**
	 * 查看某个账号的请求列表
	 * @param acceptor_email
	 * @return
	 */
	@RequestMapping(value = "/apply/all",method = RequestMethod.GET)
	UserOV<List<Apply>> checkApply(@RequestParam("acceptor_email") String acceptor_email);

	/**
	 * 审批某个账号的某条记录
	 * @param apply
	 * @return
	 */
	@RequestMapping(value = "/apply/read",method = RequestMethod.PUT)
	UserOV approvalApply(@RequestBody Apply apply);

	/**
	 * 任意发送一条信息
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/message",method =RequestMethod.POST)
	UserOV sendMessage(@RequestBody Message message);
}
