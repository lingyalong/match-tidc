package com.tidc.usermanager.service;


import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae CheckUserService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckUserService {
	/**
	 *
	 * @param email
	 * @return 根据邮箱号返回用户详细信息
	 */
	UserOV userInfo(String email);
}
