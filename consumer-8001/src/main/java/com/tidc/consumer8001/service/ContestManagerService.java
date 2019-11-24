package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassNmae ContestManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ContestManagerService {
	/**
	 *创建一个比赛
	 * @param contest
	 * @param access_token
	 * @return
	 */
	UserOV<Integer> foundContest(Contest contest,String access_token);

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @param access_token
	 * @return
	 */
	UserOV addPower(Power power, String access_token);

	/**
	 * 增加一个比赛类型
	 * @param name
	 * @return
	 */
	UserOV addType(@RequestParam("name") String name);

	/**
	 * 获取所有比赛的展示信息
	 * @return
	 */
	 UserOV<List<Contest>> getContestAll();
}
