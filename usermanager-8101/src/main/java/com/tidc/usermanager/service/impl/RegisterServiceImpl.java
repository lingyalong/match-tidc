package com.tidc.usermanager.service.impl;

import com.tidc.api.controller.MessageManagerApi;
import com.tidc.usermanager.enummanager.HttpEnum;
import com.tidc.usermanager.mapper.SchoolMapper;
import com.tidc.usermanager.mapper.StatusMapper;
import com.tidc.usermanager.mapper.TeacherMapper;
import com.tidc.usermanager.pojo.School;
import com.tidc.usermanager.pojo.Teacher;
import com.tidc.usermanager.pojo.UserOV;
import com.tidc.usermanager.service.RegisterService;
import com.tidc.usermanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Override
	public UserOV teacherRegister(Teacher teacher,String code) {
		School school = schoolMapper.getSchoolCode(code);
		UserOV userOV = ac.getBean(UserOV.class);
		if(school==null){
			//邀请码错误
			return userOV.setMessage("邀请码错误").setStatus(HttpEnum.FAIL);
		}
		//查重
		Integer flag = statusMapper.getStatus(teacher.getEmail());
		if(flag!=null){
			//重复了
			return userOV.setStatus(HttpEnum.FAIL).setMessage("email重复");
		}
		teacher.setTeacher_school_id(school.getId());
		teacher.setSchoolName(school.getName());
		teacher.setIs_open(0);
		teacherMapper.teacherRegister(teacher);
		//给校方发一条通知
		messageManagerApi.teacherApprove(school.getEmail(),teacher.getEmail());
		return null;
	}
}
