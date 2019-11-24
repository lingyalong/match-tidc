package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	public UserOV teacherRegister(Teacher teacher,String code){
		return userManagerApi.teacherRegister(teacher, code);
	}
	public UserOV<List<Student>> listSchoolStudent( int id){
		return userManagerApi.listSchoolStudent(id);
	}
}
