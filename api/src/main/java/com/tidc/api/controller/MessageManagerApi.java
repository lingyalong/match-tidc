package com.tidc.api.controller;

import com.tidc.api.fallback.MessageManagerFallbackFactory;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae SendManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "MESSAGEMANAGER",fallbackFactory = MessageManagerFallbackFactory.class)
public interface MessageManagerApi {
	@RequestMapping(value = "/teacher/approve",method = RequestMethod.GET)
	UserOV teacherApproveMessage(@RequestParam("schoolEmail") String schoolEmail, @RequestParam("teacherEmail") String teacherEmail);
}
