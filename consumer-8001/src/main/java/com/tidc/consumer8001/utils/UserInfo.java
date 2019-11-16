package com.tidc.consumer8001.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae UserInfo
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class UserInfo {
	@Autowired
	ResourceServerTokenServices tokenServices;
	public  String getUserName(String token){
		OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(token);
		return (String) oAuth2Authentication.getUserAuthentication().getPrincipal();
	}
}
