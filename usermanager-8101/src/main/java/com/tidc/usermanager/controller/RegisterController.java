package com.tidc.usermanager.controller;

import com.tidc.api.exception.RegisterException;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;
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

	/**
	 * 注册老师账号 需要status 1/2/3
	 * @param user
	 * @return
	 */
	@PostMapping("/teacher/register")
	public UserOV teacherRegister(@RequestBody User user) throws RegisterException {
		return registerService.register(user);
	}

}
