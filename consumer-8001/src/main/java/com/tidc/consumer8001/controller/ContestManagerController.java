package com.tidc.consumer8001.controller;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.consumer8001.service.ContestManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae ContestController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class ContestManagerController {
	@Autowired
	private ContestManagerService contestManagerService;
	/**
	 * 创建一个比赛
	 * @param contest
	 * @param access_token
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV<Integer> foundContest(@RequestBody Contest contest,@RequestParam("access_token") String access_token){
		return contestManagerService.foundContest(contest,access_token);
	}

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @param access_token
	 * @return
	 */
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power, @RequestParam("access_token") String access_token){
		return contestManagerService.addPower(power,access_token);
	}

	/**
	 * 增加一个比赛类型
	 * @param name
	 * @return
	 */
	@PostMapping("/type" )
	public UserOV addType(@RequestParam("name") String name){
		return contestManagerService.addType(name);
	}

	/**
	 * 查看所有比赛的详细信息
	 * @return
	 */
	@GetMapping("/contest")
	public UserOV<List<Contest>> getContestAll() {
		return contestManagerService.getContestAll();
	}

	/**
	 * 学生报名比赛
	 * 需要字段
	 * name(比赛名字)
	 * logo(封面地址)
	 * url(文件地址)
	 * contest_id(比赛id)
	 * is_money(是否缴费)
	 * brief(简介最好是富文本)
	 * @param work
	 * @return
	 */
	@PostMapping("/apply")
	public UserOV apply(@RequestBody Work work,@RequestParam("access_token") String access_token){
		return contestManagerService.apply(work,access_token);
	}

}
