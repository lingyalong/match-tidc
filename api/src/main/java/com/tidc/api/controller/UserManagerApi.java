package com.tidc.api.controller;

import com.tidc.api.fallback.UserManagerFallbackFactory;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
	UserOV userInfo(@RequestParam("email") String email);
	@RequestMapping(value = "/teacher/open",method = RequestMethod.PUT)
	UserOV teacherOpen(@RequestBody  Teacher teacher);
}
