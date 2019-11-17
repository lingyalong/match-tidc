package com.tidc.messagemanager.service;


import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SendService {
	UserOV teacherApproveMessage(String schoolEmail, String teacherEmail);
	UserOV sendMessage(@RequestBody Message message);
}
