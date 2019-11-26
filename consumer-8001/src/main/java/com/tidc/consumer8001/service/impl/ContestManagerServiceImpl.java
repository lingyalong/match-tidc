package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.consumer8001.service.ContestManagerService;
import com.tidc.consumer8001.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae ContestManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class ContestManagerServiceImpl implements ContestManagerService {
	@Autowired
	private ContestManagerApi contestManagerApi;
	@Autowired
	private UserInfo userInfo;
	@Override
	public UserOV<Integer> foundContest(Contest contest, String access_token) {
		String school_email = userInfo.getUserName(access_token);
		return contestManagerApi.foundContest(contest,school_email);
	}

	@Override
	public UserOV addPower(Power power, String access_token) {
		String teacher_email = userInfo.getUserName(access_token);
		return contestManagerApi.addPower(power,teacher_email);
	}

	@Override
	public UserOV addType(String name) {
		return contestManagerApi.addType(name);
	}

	@Override
	public UserOV<List<Contest>> getContestAll() {
		return contestManagerApi.getContestAll();
	}

	@Override
	public UserOV apply(Work work,String access_token) {
		String email = userInfo.getUserName(access_token);
		return contestManagerApi.apply(work,email);
	}
}