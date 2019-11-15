package com.tidc.messagemanager.service;


import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SendService {
	UserOV teacherApproveMessage(String schoolEmail, String teacherEmail);
}
