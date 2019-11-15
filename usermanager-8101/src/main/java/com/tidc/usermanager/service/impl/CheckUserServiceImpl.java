package com.tidc.usermanager.service.impl;

import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.enummanager.HttpEnum;
import com.tidc.usermanager.mapper.SchoolMapper;
import com.tidc.usermanager.mapper.StatusMapper;
import com.tidc.usermanager.mapper.StudentMapper;
import com.tidc.usermanager.mapper.TeacherMapper;
import com.tidc.usermanager.pojo.School;
import com.tidc.usermanager.pojo.Student;
import com.tidc.usermanager.pojo.Teacher;
import com.tidc.usermanager.service.CheckUserService;
import com.tidc.usermanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae CheckUserServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class CheckUserServiceImpl implements CheckUserService {
	@Autowired
	private StatusMapper statusMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ApplicationContextProvider ac;
	@Override
	public UserOV userInfo(String email) {
		Integer status = statusMapper.getStatus(email);
		UserOV userOV = new UserOV();
		switch (status){
			case 1:
				Student student = studentMapper.chickEmail(email);
				return userOV.setStatus(HttpEnum.SUCCEED).setData(student);
			case 2:
				Teacher teacher = teacherMapper.chickEmail(email);
				return userOV.setStatus(HttpEnum.SUCCEED).setData(teacher);
			case 3:
				School school = schoolMapper.chickEmail(email);
				return userOV.setStatus(HttpEnum.SUCCEED).setData(school);
		}
		return userOV.setStatus(HttpEnum.FAIL).setMessage("这个用户不存在");
	}
}
