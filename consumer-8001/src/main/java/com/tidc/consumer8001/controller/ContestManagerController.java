package com.tidc.consumer8001.controller;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.*;
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
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV<Integer> foundContest(@RequestBody Contest contest){
		return contestManagerService.foundContest(contest);
	}

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @return
	 */
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power){
		return contestManagerService.addPower(power);
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
	 * name(项目名字)
	 * logo(封面地址)
	 * url(文件地址)
	 * contest_id(比赛id)
	 * is_money(是否缴费)
	 * brief(简介最好是富文本)
	 * @param work
	 * @return
	 */
	@PostMapping("/apply")
	public UserOV apply(@RequestBody Work work){
		return contestManagerService.apply(work);
	}
	/**
	 * 根据类型查看比赛列表
	 * @param type
	 * @return
	 */
	@GetMapping("/type/contest")
	public UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type){
		return contestManagerService.getTypeContest(type);
	}

	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest")
	public UserOV<Contest> updateContest(@RequestBody Contest contest){
		return contestManagerService.updateContest(contest);
	}

	/**
	 * 增加队员
	 * @param team
	 * @return
	 */
	@PostMapping("/member")
	public UserOV addMember(@RequestBody Team team){
		return contestManagerService.addMember(team);
	}

	/**
	 * 删除队员
	 * @param team
	 * @return
	 */
	@DeleteMapping("/member")
	public UserOV deleteMember(@RequestBody Team team){
		return  contestManagerService.deleteMember(team);
	}

	/**
	 * 删除比赛
	 * @param contest id token
	 * @return
	 */
	@DeleteMapping("/contest")
	public UserOV deleteContest(@RequestBody Contest contest){
		return contestManagerService.deleteContest(contest);
	}

	/**
	 * 删除项目
	 * @param work id token
	 * @return
	 */
	@DeleteMapping("/work")
	public UserOV deleteWork(@RequestBody Work work){
		return contestManagerService.deleteWork(work);
	}

	/**
	 * 删除评委
	 * @param power id token
	 * @return
	 */
	@DeleteMapping("/power")
	public UserOV deletePower(@RequestBody Power power){
		return contestManagerService.deletePower(power);
	}
}
