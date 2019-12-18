package com.tidc.consumer8001.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.controller.AuthenticationApi;
import com.tidc.api.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;

/**
 * @ClassNmae UserInfo
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class UserInfo {
	@Autowired
	private ResourceServerTokenServices tokenServices;
	@Autowired
	private AuthenticationApi authenticationApi;
	@Autowired
	private ObjectMapper objectMapper;
	public String getUserName(HttpServletRequest req){
//		String token =getToken(req);
		String token = req.getHeader("tidc");
		OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
		return (String) oAuth2Authentication.getUserAuthentication().getPrincipal();
	}
	public Object userInfo(HttpServletRequest req, int i) throws InvalidTokenException {
		String token = req.getHeader("tidc");
		OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
		String email = (String) oAuth2Authentication.getUserAuthentication().getPrincipal();
		LinkedHashMap userInfo = (LinkedHashMap) authenticationApi.getUserInfo(email);
		Object object = objectMapper.convertValue(userInfo, new TypeReference<User>(){});
		return object;
	}

}
