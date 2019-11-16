package com.tidc.messagemanager.service;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae ApprovalService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ApprovalService {
	UserOV readApply(Apply apply);
}
