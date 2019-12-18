package com.tidc.usermanager.service;

import com.tidc.api.exception.RegisterException;
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
	UserOV register(User user)throws RegisterException;


}
