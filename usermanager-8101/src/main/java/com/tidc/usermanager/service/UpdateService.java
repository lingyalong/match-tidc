package com.tidc.usermanager.service;

import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae UpdateService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UpdateService {
	/**
	 * 开启老师权限
	 * @param teacher
	 * @return
	 */
	UserOV openTeacher(Teacher teacher);

	/**
	 * 关闭老师权限
	 * @param teacher
	 * @return
	 */
	UserOV closeTeacher(Teacher teacher);

}
