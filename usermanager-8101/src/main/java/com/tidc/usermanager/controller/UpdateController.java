package com.tidc.usermanager.controller;

import com.tidc.api.exception.UltraViresException;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;
import com.tidc.usermanager.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae UptateController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class UpdateController {
	@Autowired
	private UpdateService updateService;
	/**
	 * 开启或者关闭老师的权限
	 * @param teacher email
	 * @return
	 */
	@PutMapping("/teacher/open")
	public UserOV switchTeacher(@RequestBody User teacher) throws UltraViresException {
		return updateService.switchTeacher(teacher);
	}

}
