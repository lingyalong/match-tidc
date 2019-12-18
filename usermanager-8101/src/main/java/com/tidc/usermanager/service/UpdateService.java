package com.tidc.usermanager.service;

import com.tidc.api.exception.UltraViresException;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;

/**
 * @ClassNmae UpdateService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UpdateService {
	/**
	 * 开启或者关闭老师权限
	 * @param teacher
	 * @return
	 */
	UserOV switchTeacher(User teacher) throws UltraViresException;
}
