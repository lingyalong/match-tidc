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
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public Object login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("stet");
		return authenticationService.login(username,password);
	}

	/**
	 * 使用token查看个人信息
	 * @param token
	 * @return
	 */
	@GetMapping("/user/info")
	public Object getUserInfo(@RequestParam("token") String token){
		return authenticationService.getUserInfo(token);
	}
}
