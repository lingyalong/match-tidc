package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.AuthenticationApi;
import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.consumer8001.service.AuthenticationService;
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
	@Autowired
	private AuthenticationApi authenticationApi;
	@Override
	public UserOV<Integer> foundContest(Contest contest) {
		String school_email = userInfo.getUserName(contest.getToken());
		return contestManagerApi.foundContest(contest,school_email);
	}

	@Override
	public UserOV addPower(Power power) {
		String teacher_email = userInfo.getUserName(power.getToken());
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
	public UserOV apply(Work work) {
		String email = userInfo.getUserName(work.getToken());
		return contestManagerApi.apply(work,email);
	}

	@Override
	public UserOV<List<Contest>> getTypeContest(String type) {
		return contestManagerApi.getTypeContest(type);
	}

	@Override
	public UserOV<Contest> updateContest(Contest contest) {
		return contestManagerApi.updateContest(contest);
	}

	@Override
	public UserOV addMember(Team team) {
		return contestManagerApi.addMember(team);
	}

	@Override
	public UserOV deleteMember(Team team) {
		Student student = (Student) userInfo.userInfo(team.getToken());
		team.setLeaderId(student.getId());
		return contestManagerApi.deleteMember(team);
	}

	@Override
	public UserOV deleteContest(Contest contest) {
		School school = (School) userInfo.userInfo(contest.getToken());
		contest.setSchool_id(school.getId());
		return contestManagerApi.deleteContest(contest);
	}

	@Override
	public UserOV deleteWork(Work work) {
		Student student = (Student) userInfo.userInfo(work.getToken());
		work.setStudent_id(student.getId());
		return contestManagerApi.deleteWork(work);
	}

	@Override
	public UserOV deletePower(Power power) {
		School school = (School) userInfo.userInfo(power.getToken());
		power.setUserId(school.getId());
		return contestManagerApi.deletePower(power);
	}


}
