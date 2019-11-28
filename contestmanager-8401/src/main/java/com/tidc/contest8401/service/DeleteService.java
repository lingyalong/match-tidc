package com.tidc.contest8401.service;

import com.tidc.api.pojo.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae DeleteService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface DeleteService {
	/**
	 * 删除队员
	 * @param team
	 * @return
	 */
	UserOV deleteMember(Team team);

	/**
	 * 删除比赛
	 * @param contest
	 * @return
	 */
	UserOV deleteContest(Contest contest);

	/**
	 * 删除项目
	 * @param work
	 * @return
	 */
	UserOV deleteWork(Work work);

	/**
	 * 删除比赛之后删除队伍和项目
	 * @param contest_id
	 * @return
	 */
	UserOV deleteWorkAndTeam(int contest_id);

	/**
	 * 删除评委
	 * @param power
	 * @return
	 */
	UserOV deletePower(Power power);

}
