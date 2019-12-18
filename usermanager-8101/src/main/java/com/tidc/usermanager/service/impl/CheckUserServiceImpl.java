package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;
import com.tidc.usermanager.mapper.UserDetailMapper;
import com.tidc.usermanager.mapper.UserMapper;
import com.tidc.usermanager.service.CheckUserService;
import com.tidc.usermanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae CheckUserServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class CheckUserServiceImpl implements CheckUserService {
	@Autowired
	private UserDetailMapper userDetailMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ApplicationContextProvider ac;
	@Override
	public UserOV<User> userInfo(String email) {
		UserOV<User> userOV = new UserOV<>();
		User userInfo = userMapper.getUserInfo(email);
		userOV.setStatus(CodeConstant.SUCCESS).setData(userInfo);
		return userOV;
	}

	@Override
	public UserOV<List<User>> listSchoolStudent(int id) {
		UserOV<List<User>> userOV = new UserOV<>();
		List<User> students = userMapper.listSchoolStudent(id);
		userOV.setStatus(CodeConstant.SUCCESS).setData(students);
		return userOV;
	}

	@Override
	public UserOV<List<String>> listStudentEmail(List<Integer> list) {
		List<String> listEmail = studentMapper.listStudentEmail(list);
		UserOV<List<String>> userOV = new UserOV<>();
		userOV.setStatus(CodeConstant.SUCCESS).setData(listEmail);
		return userOV;
	}

	@Override
	public UserOV<Student> getStudent(String email) {
		UserOV<Student> userOV = new UserOV<>();
		Student student = studentMapper.getStudent(email);
		userOV.setStatus(CodeConstant.SUCCESS).setData(student);
		return userOV;
	}
}
