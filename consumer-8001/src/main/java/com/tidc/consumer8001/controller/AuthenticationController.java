package com.tidc.consumer8001.controller;

import com.tidc.api.controller.AuthenticationApi;
import com.tidc.consumer8001.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae AuthenticationController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
@RequestMapping
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	@PostMapping("/login")
	public Object login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("stet");
		return authenticationService.login(username,password);
	}
	@GetMapping("/user/info")
	public Object getUserInfo(String access_token){
		return authenticationService.getUserInfo(access_token);
	}
}
