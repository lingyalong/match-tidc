package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.mapper.TeacherMapper;
import com.tidc.usermanager.service.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae UpdateServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class UpdateServiceImpl implements UpdateService {
	@Autowired
	TeacherMapper teacherMapper;
	private Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);
	/**
	 * 解封老师账号
	 * @param teacher
	 * @return
	 */
	@Override
	public UserOV openTeacher(Teacher teacher) {
		UserOV userOV = new UserOV();
		int count = teacherMapper.updateTeacherOpen(teacher.getEmail());
		if(count==1){
			userOV.setStatus(CodeConstant.UPDATE);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("解封失败");
		}
		return userOV;
	}

	/**
	 * 关闭老师权限
	 * @param teacher
	 * @return
	 */
	@Override
	public UserOV closeTeacher(Teacher teacher) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Teacher teacher1 = teacherMapper.getTeacher(teacher.getEmail());
		if(teacher1.getTeacher_school_id().equals(teacher.getTeacher_school_id())){
			teacherMapper.updateTeacherClose(teacher.getEmail());
			userOV.setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setMessage("你没有权限管理外校老师");
			logger.info("schoolId: "+teacher.getTeacher_school_id() + "试图越权");
		}
		return userOV;
	}

}
