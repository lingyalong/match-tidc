package com.tidc.messagemanager.service;

import com.tidc.messagemanager.pojo.UserOV;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SendService {
	UserOV teacherApprove(String schoolEmail,String teacherEmail);
}
