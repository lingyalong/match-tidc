package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.mapper.TeacherMapper;
import com.tidc.usermanager.service.UpdateService;
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

	/**
	 * 解封老师账号
	 * @param teacher
	 * @return
	 */
	@Override
	public UserOV openTeacher(Teacher teacher) {
		UserOV userOV = new UserOV();
		int count = teacherMapper.updateTeacherOpen(teacher);
		if(count==1){
			userOV.setStatus(CodeConstant.UPDATE);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("解封失败");
		}
		return userOV;
	}

}
