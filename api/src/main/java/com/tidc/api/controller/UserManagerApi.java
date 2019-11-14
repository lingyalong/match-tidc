package com.tidc.api.controller;

import com.tidc.api.fallback.AuthenticationFallbackFactory;
import com.tidc.api.fallback.UserManagerFallbackFactory;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae UserManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "USERMANAGER",fallbackFactory = UserManagerFallbackFactory.class)
public interface UserManagerApi {
	@RequestMapping(value = "/teacher/register",method = RequestMethod.POST)
	UserOV teacherRegister(@RequestBody Teacher teacher, @RequestParam("code") String code);
	@RequestMapping(value = "/user/info",method = RequestMethod.GET)
	UserOV userInfo(String email);
}
