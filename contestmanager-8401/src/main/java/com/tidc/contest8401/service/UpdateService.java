package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae UpdateService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UpdateService {
	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	UserOV<Contest> updateContest(Contest contest);
}