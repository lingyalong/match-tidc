package com.tidc.usermanager.controller;

import com.tidc.usermanager.pojo.Teacher;
import com.tidc.usermanager.pojo.UserOV;
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
	public UserOV teacherRegister(@RequestBody Teacher teacher, @RequestParam("code") String code){
		return registerService.teacherRegister(teacher,code);
	}
}
