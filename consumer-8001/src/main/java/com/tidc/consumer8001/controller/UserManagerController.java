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
	 * @return
	 */
	@PostMapping("/teacher/register")
	public UserOV teacherRegister(@RequestBody Teacher teacher){
		return userManagerService.teacherRegister(teacher);
	}
	/**
	 * 根据学校id查询该学校的所有学生信息(通过token获取id)
	 * @param token
	 * @return
	 */
	@GetMapping("/school/student")
	public UserOV<List<Student>> listSchoolStudent(@RequestParam("token") String token){
		return userManagerService.listSchoolStudent(token);
	}

	/**
	 * 注册学生账号
	 * @param student
	 * @return
	 */
	@PostMapping("/student/register")
	public UserOV studentRegister(@RequestBody Student student){
		return userManagerService.studentRegister(student);
	}

	/**
	 * 使用email查看student信息
	 * @param email
	 * @return
	 */
	@GetMapping("/student")
	public UserOV<Student> getStudent(@RequestParam("email") String email){
		return userManagerService.getStudent(email);
	}

	/**
	 * 关闭老师的权限
	 * @param teacher email
	 * @return
	 */
	@PutMapping("/teacher/down")
	public UserOV closeTeacher(@RequestBody Teacher teacher){
		return userManagerService.closeTeacher(teacher);
	}
}
