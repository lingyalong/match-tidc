package com.tidc.contest8401.controller;

import com.tidc.api.pojo.*;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.service.DeleteService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae DeleteController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class DeleteController {
	@Autowired
	private DeleteService deleteService;
	@Autowired
	private TeamMapper teamMapper;
	/**
	 * 删除队员
	 * @param team
	 * @return
	 */
	@DeleteMapping("/member")
	public UserOV deleteMember(@RequestBody Team team){
		return deleteService.deleteMember(team);
	}

	/**
	 * 删除比赛
	 * @param contest
	 * @return
	 */
	@DeleteMapping("/contest")
	public UserOV deleteContest(@RequestBody Contest contest){
		return deleteService.deleteContest(contest);
	}

	/**
	 * 删除项目
	 * @param work
	 * @return
	 */
	@DeleteMapping("/work")
	public UserOV deleteWork(@RequestBody Work work){
		return deleteService.deleteWork(work);
	}

	/**
	 * 删除比赛之后删除队伍和项目
	 * @param contest_id
	 * @return
	 */
	@DeleteMapping("/contest/work/team")
	public UserOV deleteWorkAndTeam(@RequestParam("contest_id") int contest_id){
		return deleteService.deleteWorkAndTeam(contest_id);
	}

	/**
	 * 删除评委
	 * @param power id token
	 * @return
	 */
	@DeleteMapping("/power")
	public UserOV deletePower(@RequestBody Power power){
		return deleteService.deletePower(power);
	}
}
