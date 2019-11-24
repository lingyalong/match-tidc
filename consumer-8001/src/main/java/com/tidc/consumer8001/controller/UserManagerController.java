package com.tidc.consumer8001.controller;

import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	/**
	 * 注册一个老师账号
	 * @param teacher
	 * @param code
	 * @return
	 */
	@PostMapping("/teacher/register")
	public UserOV teacherRegister(@RequestBody Teacher teacher,@RequestParam("code") String code){
		return userManagerService.teacherRegister(teacher, code);
	}
	@GetMapping("/school/student/{id}")
	public UserOV<List<Student>> listSchoolStudent(@PathVariable("id") int id){
		return userManagerService.listSchoolStudent(id);
	}
}
