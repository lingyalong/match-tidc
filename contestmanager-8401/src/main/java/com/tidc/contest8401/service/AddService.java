package com.tidc.contest8401.service;

import com.tidc.api.exception.RepetitionException;
import com.tidc.api.pojo.ContestType;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.Team;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.exception.RepetitionException;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae AddService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface AddService {
	/**
	 * 增加评分权限
	 * @param power
	 * @param email
	 * @return
	 */
	UserOV addPower(Power power,String email);

	/**
	 * 增加比赛类型
	 * @param name
	 * @return
	 */
	UserOV addType(String name);

	/**
	 * 增加队员
	 * @param team
	 * @return
	 */
	UserOV addMember(Team team) throws RepetitionException, RepetitionException;
}
