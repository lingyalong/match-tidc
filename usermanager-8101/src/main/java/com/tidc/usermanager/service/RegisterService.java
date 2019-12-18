package com.tidc.usermanager.service;

import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;

/**
 * @ClassNmae RegisterService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface RegisterService {
	/**
	 * 注册老师账号
	 * @param user
	 * @return Data.email
	 */
	UserOV teacherRegister(User user);

	/**
	 * 注册学生账号
	 * @param student
	 * @return
	 */
	UserOV studentRegister( Student student);
}
