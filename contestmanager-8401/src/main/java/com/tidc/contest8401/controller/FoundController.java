package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae foundController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class FoundController {
	@Autowired
	private FoundService foundService;

	/**
	 *
	 * @param contest 比赛名字 类型 各种功能 简介 开始/结束时间 试卷id 文件/图片地址 收多少钱
	 * @param school_email 发起学校email
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email){
		return foundService.foundService(contest, school_email);
	}
}
