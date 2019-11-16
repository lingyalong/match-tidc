package com.tidc.messagemanager.controller;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae ApprovalController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class ApprovalController {
	@Autowired
	private ApprovalService approvalService;

	/**
	 * 审批某个账号的某条申请
	 * @param apply
	 * @return
	 */
	@PutMapping("/apply/read")
	public UserOV approvalApply(@RequestBody  Apply apply){
		return approvalService.readApply(apply);
	}
}
