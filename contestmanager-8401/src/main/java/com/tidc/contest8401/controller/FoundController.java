package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.ContestApply;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.Record;
import com.tidc.contest8401.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
	 *创建比赛
	 * @param contest 比赛名字 类型 各种功能 简介 开始/结束时间 试卷id 文件/图片地址 收多少钱 这里的历史试卷id传他选择的id然后再进行修改
	 * @param school_email 发起学校email
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV<Integer> foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email) throws ParseException {
		return foundService.foundService(contest, school_email);
	}

	/**
	 * 报名比赛
	 * @param work
	 * @param email
	 * @return
	 */
	@PostMapping("/work")
	public UserOV work(@RequestBody Work work,@RequestParam("email") String email){
		return foundService.work(work,email);
	}

	/**
	 * 报名线上比赛
	 * @param contestApply contest_id
	 * @return
	 */
	@PostMapping("/apply")
	public UserOV apply(@RequestBody ContestApply contestApply){
		return foundService.apply(contestApply);
	}


	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	@PostMapping("/record")
	public UserOV record(@RequestBody Record record) throws ParseException {
		return foundService.record(record);
	}
}
