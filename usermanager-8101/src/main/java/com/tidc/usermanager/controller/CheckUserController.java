package com.tidc.usermanager.controller;

import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.service.CheckUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae UserController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class CheckUserController {
	@Autowired
	private CheckUserService checkUserService;
	@GetMapping("/user/info")
	public UserOV userInfo(String email){
		return checkUserService.userInfo(email);
	}
}
