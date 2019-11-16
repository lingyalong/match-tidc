package com.tidc.consumer8001.controller;

import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae UserManagerController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class UserManagerController {
	@Autowired
	private UserManagerService userManagerService;
	@PostMapping("/teacher/register")
	public UserOV teacherRegister(Teacher teacher,String code){
		return userManagerService.teacherRegister(teacher, code);
	}
}
