package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae ContestManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ContestManagerService {
	/**
	 *创建一个比赛
	 * @param contest
	 * @param school_email
	 * @return
	 */
	UserOV foundContest(Contest contest,String school_email);

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @param email
	 * @return
	 */
	UserOV addPower(Power power, String email);
}
