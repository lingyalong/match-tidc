package com.tidc.usermanager.service;

import com.tidc.usermanager.pojo.Teacher;
import com.tidc.usermanager.pojo.UserOV;

/**
 * @ClassNmae RegisterService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface RegisterService {
	/**
	 * 注册老师账号
	 * @param teacher
	 * @return
	 */
	public UserOV teacherRegister(Teacher teacher,String code);
}
