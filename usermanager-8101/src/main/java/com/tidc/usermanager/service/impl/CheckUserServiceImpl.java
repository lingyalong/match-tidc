package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.mapper.SchoolMapper;
import com.tidc.usermanager.mapper.StatusMapper;
import com.tidc.usermanager.mapper.StudentMapper;
import com.tidc.usermanager.mapper.TeacherMapper;
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
				Student student = studentMapper.getStudent(email);
				return userOV.setStatus(CodeConstant.SUCCESS).setData(student);
			case 2:
				Teacher teacher = teacherMapper.getTeacher(email);
				return userOV.setStatus(CodeConstant.SUCCESS).setData(teacher);
			case 3:
				School school = schoolMapper.getSchool(email);
				return userOV.setStatus(CodeConstant.SUCCESS).setData(school);
		}
		return userOV.setStatus(CodeConstant.FAIL).setMessage("这个用户不存在");
	}
}
