package com.tidc.usermanager.controller;

import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
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
	@PutMapping("/teacher/open")
	public UserOV openTeacher(@RequestBody  Teacher teacher){
		return updateService.openTeacher(teacher);
	}
}
