package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.UserManagerService;
import com.tidc.consumer8001.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassNmae UserManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class UserManagerServiceImpl implements UserManagerService {
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private UserInfo userInfo;
	public UserOV teacherRegister(Teacher teacher){
		return userManagerApi.teacherRegister(teacher);
	}

	public UserOV<List<Student>> listSchoolStudent(HttpServletRequest req){
		String email = userInfo.getUserName(req);
		UserOV userOV = userManagerApi.userInfo(email);
		LinkedHashMap map = (LinkedHashMap) userOV.getData();
		return userManagerApi.listSchoolStudent((Integer) map.get("id"));
	}

	@Override
	public UserOV studentRegister(Student student) {
		return userManagerApi.studentRegister(student);
	}

	@Override
	public UserOV<Student> getStudent(String email) {
		return userManagerApi.getStudent(email);
	}

	@Override
	public UserOV closeTeacher(Teacher teacher,HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req, 3);
		teacher.setTeacher_school_id(school.getId());
		return userManagerApi.closeTeacher(teacher);
	}
}
