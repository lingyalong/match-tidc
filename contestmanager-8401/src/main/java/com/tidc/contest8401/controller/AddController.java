package com.tidc.contest8401.controller;

import com.tidc.api.exception.RepetitionException;
import com.tidc.api.pojo.ContestType;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.Team;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae AddController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class AddController {
	@Autowired
	private AddService addService;

	/**
	 * 增加评分权限
	 * @param power
	 * @param email
	 * @return
	 */
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power,@RequestParam("email") String email){
		return addService.addPower(power,email);
	}

	/**
	 * 增加比赛类型
	 * @param name
	 * @return
	 */
	@PostMapping("/type")
	public UserOV addType(@RequestParam("name") String name){
		return addService.addType(name);
	}
	@PostMapping("/member")
	public UserOV addMember(@RequestBody Team team) throws RepetitionException {
		return addService.addMember(team);
	}

}
