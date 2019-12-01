package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.AuthenticationApi;
import com.tidc.consumer8001.service.AuthenticationService;
import com.tidc.consumer8001.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * @ClassNmae AuthenticationServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private AuthenticationApi authenticationApi;
	@Autowired
	private UserInfo userInfo;
	@Override
	public Object login(String username, String password){
		LinkedHashMap login = (LinkedHashMap) authenticationApi.login(username, password, "TIDC", "computer", "password");
		return login;
	}

	@Override
	public Object getUserInfo(HttpServletRequest req) {
		String email = userInfo.getUserName(req);
		Object userInfo = authenticationApi.getUserInfo(email);
		return userInfo;
	}
}
