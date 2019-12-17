package com.tidc.authentication9001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae UserController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class UserController {


	/**
	 *
	 * @param email
	 * @return 返回用户除密码之外的信息
	 */
	@GetMapping("/user/info")
	public Object  user(String email) {

		return null;
	}
}
