package com.tidc.usermanager.controller;

import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.service.CheckUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
	/**
	 * @param email
	 * @return 根据邮箱号返回用户详细信息
	 */
	@GetMapping("/user/info")
	public UserOV userInfo(String email){
		return checkUserService.userInfo(email);
	}

	/**
	 * 根据学校id查询该学校的所有学生信息
	 * @param id
	 * @return
	 */
	@GetMapping("/school/student/{id}")
	public UserOV<List<Student>> listSchoolStudent(@PathVariable("id") int id){
		return checkUserService.listSchoolStudent(id);
	}
}
