package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.CheckService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae CheckController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class CheckController {
	@Autowired
	private CheckService checkService;

	/**
	 * 查看所有比赛的基本信息
	 * @return
	 */
	@GetMapping("/contest")
	public UserOV<List<Contest>> getContestAll(){
		return checkService.getContestAll();
	}

	/**
	 * 根据比赛类型获取该类型的比赛
	 * @param type
	 * @return
	 */
	@GetMapping("/type/contest")
	public UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type){
		return checkService.getTypeContest(type);
	}

	/**
	 * 根据比赛id获取比赛详细信息
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/details/{id}")
	public UserOV<Contest> getContestDetails(@PathVariable("id") int id){
		return checkService.getContestDetails(id);
	}

	/**
	 * 查询最新的指定条数的比赛
	 * @param number
	 * @return
	 */
	@GetMapping("/rank/contest/{number}")
	public UserOV<List<Contest>> listRankContest(@PathVariable("number") int number){
		return checkService.listRankContest(number);
	}

	/**
	 * 获取所有的类型标签
	 * @return
	 */
	@GetMapping("/type")
	public UserOV<List<String>> listType(){
		return checkService.listType();
	}
}
