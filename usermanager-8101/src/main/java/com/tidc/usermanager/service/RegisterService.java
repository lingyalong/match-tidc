package com.tidc.usermanager.service;

import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;

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
