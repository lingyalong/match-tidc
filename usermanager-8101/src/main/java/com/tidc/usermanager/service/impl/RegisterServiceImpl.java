package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.Status;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.mapper.SchoolMapper;
import com.tidc.usermanager.mapper.StatusMapper;
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
	public UserOV teacherRegister(Teacher teacher, String code) {
		School school = schoolMapper.getSchoolCode(code);
		UserOV userOV = new UserOV();
		if(school==null){
			//邀请码错误
			return userOV.setMessage("邀请码错误").setStatus(CodeConstant.FAIL);
		}
		//查重
		Integer flag = statusMapper.getStatus(teacher.getEmail());
		if(flag!=null){
			//重复了
			return userOV.setStatus(CodeConstant.FAIL).setMessage("email重复");
		}
		teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
		teacher.setTeacher_school_id(school.getId());
		teacher.setSchoolName(school.getName());
		teacher.setIs_open(0);
		teacherMapper.teacherRegister(teacher);
		//这里应该有一个权限添加的语句?还没有
		Status status = ac.getBean(Status.class);
		status.setEmail(teacher.getEmail()).setIs_status(2);
		//插入身份信息
		statusMapper.insertStatus(status);
		//发送信息 和 申请
		messageManagerApi.teacherApproveMessage(school.getEmail(),teacher.getEmail());
		return userOV.setStatus(CodeConstant.SUCCESS).setData(teacher.getEmail());
	}
}
