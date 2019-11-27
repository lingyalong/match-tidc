package com.tidc.authentication9001.controller;

import com.tidc.api.pojo.*;
import com.tidc.api.pojo.Teacher;
import com.tidc.authentication9001.mapper.SchoolMapper;
import com.tidc.authentication9001.mapper.StatusMapper;
import com.tidc.authentication9001.mapper.StudentMapper;
import com.tidc.authentication9001.mapper.TeacherMapper;
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
	@Autowired
	SchoolMapper schoolMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	StatusMapper statusMapper;

	/**
	 *
	 * @param email
	 * @return 返回用户除密码之外的信息
	 */
	@GetMapping("/user/info")
	public Object  user(String email) {
		//先看这个账号是什么角色

		Integer status = statusMapper.getStatus(email);
		switch (status){
			case 1:
				Student student = studentMapper.getStudent(email);
				return student;
			case 2:
				Teacher teacher = teacherMapper.getTeacher(email);
				return teacher;
			case 3:
				School school = schoolMapper.getSchool(email);
				return school;
		}
		return null;
	}
}
