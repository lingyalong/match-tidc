package com.tidc.consumer8001.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNmae AuthenticationService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface AuthenticationService {
	/**
	 *
	 * @param username 邮箱
	 * @param password 密码
	 * @return 返回标准的token没有身份标识,需要添加一个身份标识
	 */
	public Object login(String username,String password);

	/**
	 *
	 * @param req
	 * @return 返回用户详细信息
	 */
	public Object getUserInfo(HttpServletRequest req);
}
