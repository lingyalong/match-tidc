package com.tidc.consumer8001.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.controller.AuthenticationApi;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

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
	public String getUserName(String token){
		OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
		return (String) oAuth2Authentication.getUserAuthentication().getPrincipal();
	}
	public Object userInfo(String token,int i){
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
}
