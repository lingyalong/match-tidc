package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.usermanager.mapper.SchoolMapper;
import com.tidc.usermanager.mapper.StatusMapper;
import com.tidc.usermanager.mapper.StudentMapper;
import com.tidc.usermanager.mapper.TeacherMapper;
import com.tidc.usermanager.service.RegisterService;
import com.tidc.usermanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae RegisterServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private StatusMapper statusMapper;
	@Autowired
	private MessageManagerApi messageManagerApi;
	@Autowired
	private ApplicationContextProvider ac;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserOV teacherRegister(Teacher teacher) {
		School school = check(teacher.getEmail(),teacher.getCode());
		UserOV userOV = new UserOV();
		if(school==null){
			//邀请码错误
			return userOV.setMessage("邮箱或邀请码错误").setStatus(CodeConstant.FAIL);
		}
		teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
		teacher.setTeacher_school_id(school.getId());
		teacher.setSchoolName(school.getName());
		teacher.setIs_open(0);
		int count = teacherMapper.teacherRegister(teacher);
		if(count==1){
			//这里应该有一个权限添加的语句?还没有
			Status status = ac.getBean(Status.class);
			status.setEmail(teacher.getEmail()).setIs_status(2);
			//插入身份信息
			int count2 = statusMapper.insertStatus(status);
			//发送信息 和 申请
			messageManagerApi.teacherApproveMessage(school.getEmail(),teacher.getEmail());
			if(count2==1){
				userOV.setStatus(CodeConstant.SUCCESS).setData(teacher.getEmail());
			}else{
				userOV.setStatus(CodeConstant.FAIL).setMessage("身份插入失败");
			}
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("注册失败");
		}
		return userOV;
	}

	@Override
	public UserOV studentRegister(Student student) {
		School school = check(student.getEmail(),student.getCode());
		UserOV userOV = new UserOV();
		if(school==null){
			//邀请码错误
			return userOV.setMessage("邮箱或邀请码错误").setStatus(CodeConstant.FAIL);
		}
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		student.setStudent_school_id(school.getId());
		student.setSchool(school.getName());
		int count = studentMapper.insertStudent(student);
		if(count==1){
			//这里应该有一个权限添加的语句?还没有
			Status status = ac.getBean(Status.class);
			status.setEmail(student.getEmail()).setIs_status(1);
			//插入身份信息
			int count2 = statusMapper.insertStatus(status);
			if(count2==1){
				userOV.setStatus(CodeConstant.SUCCESS);
			}else{
				userOV.setStatus(CodeConstant.FAIL).setMessage("身份插入失败");
			}
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("注册失败");
		}

		return userOV;
	}
	public School check(String email,String code){
		School school = schoolMapper.getSchoolCode(code);
		if(school==null){
			//邀请码错误
			return null;
		}
		//查重
		Integer flag = statusMapper.getStatus(email);
		if(flag!=null){
			//重复了
			return null;
		}
		return school;
	}

}
