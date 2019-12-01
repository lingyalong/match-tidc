package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae MessageManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface MessageManagerService {
	/**
	 * 查看个人的消息列表
	 * @param req
	 * @return
	 */
	UserOV<List<Message>> checkMessage(HttpServletRequest req);
	/**
	 * 将某条消息设为已读
	 * @param id
	 * @return
	 */
	UserOV readMessage(int id);
	/**
	 * 将某个用户的所有消息设为已读
	 * @param req
	 * @return
	 */
	UserOV readMessageAll( HttpServletRequest req);
	/**
	 * 获取某个账号的请求列表
	 * @param req
	 * @return
	 */
	UserOV<List<Apply>> checkApply(HttpServletRequest req);
	/**
	 * 审批某个账号的某条记录
	 * @param apply Proposer_email id is_read
	 * @return
	 */
	UserOV approvalApply(Apply apply);
}
