package com.tidc.consumer8001.utils;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.controller.AuthenticationApi;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Object userInfo(HttpServletRequest req, int i){
//		String token =getToken(req);
		String token = req.getHeader("tidc");
		OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
		String email = (String) oAuth2Authentication.getUserAuthentication().getPrincipal();
		LinkedHashMap userInfo = (LinkedHashMap) authenticationApi.getUserInfo(email);
		Object object = null;
		switch (i){
			case 1:
				object = objectMapper.convertValue(userInfo, new TypeReference<Student>(){});
				break;
			case 2:
				object = objectMapper.convertValue(userInfo, new TypeReference<Teacher>(){});
				break;
			case 3:
				object = objectMapper.convertValue(userInfo, new TypeReference<School>(){});
				break;
		}
		return object;
	}
	String getToken(HttpServletRequest req){
		Enumeration headers = req.getHeaders("Authorization");
		Enumeration<String> headerNames = req.getHeaderNames();

		String value;
		do {
			if (!headers.hasMoreElements()) {
				return null;
			}

			value = (String)headers.nextElement();
		} while(!value.toLowerCase().startsWith("Bearer".toLowerCase()));

		String authHeaderValue = value.substring("Bearer".length()).trim();
		req.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, value.substring(0, "Bearer".length()).trim());
		int commaIndex = authHeaderValue.indexOf(44);
		if (commaIndex > 0) {
			authHeaderValue = authHeaderValue.substring(0, commaIndex);
		}
		return authHeaderValue;
	}
}
