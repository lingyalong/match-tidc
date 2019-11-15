package com.tidc.usermanager.controller;

import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae RegisterController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@PostMapping("/teacher/register")
	public UserOV teacherRegister(Teacher teacher, String code){
		return registerService.teacherRegister(teacher,code);
	}
}
