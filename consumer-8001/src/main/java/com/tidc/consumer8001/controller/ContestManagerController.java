package com.tidc.consumer8001.controller;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae ContestController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class ContestManagerController {
	@Autowired
	private ContestManagerApi contestManagerApi;

	/**
	 * 创建一个比赛
	 * @param contest
	 * @param school_email
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email){
		return contestManagerApi.foundContest(contest, school_email);
	}

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @param email
	 * @return
	 */
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power, @RequestParam("email") String email){
		return contestManagerApi.addPower(power, email);
	}

}
