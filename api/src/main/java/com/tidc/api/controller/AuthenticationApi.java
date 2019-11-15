package com.tidc.api.controller;

import com.tidc.api.fallback.AuthenticationFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae Authentication
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(name = "AUTHENTICATION",fallbackFactory = AuthenticationFallbackFactory.class)
public interface AuthenticationApi {
	@RequestMapping(value = "/oauth/token",method = RequestMethod.POST)
	Object login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("client_id") String client_id, @RequestParam("client_secret") String client_secret, @RequestParam("grant_type") String grant_type);
	@RequestMapping(value = "/user/info",method = RequestMethod.GET)
	Object getUserInfo(@RequestParam("email") String email);

}
