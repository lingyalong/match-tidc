package com.tidc.usermanager.service;

import com.tidc.api.pojo.UserOV;
import com.tidc.usermanager.pojo.Teacher;

/**
 * @ClassNmae RegisterService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface RegisterService {
	/**
	 * 注册老师账号
	 * @param teacher
	 * @return Data.email
	 */
	UserOV teacherRegister(Teacher teacher, String code);
}
