package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.ContestTypeMapper;
import com.tidc.contest8401.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae CheckServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class CheckServiceImpl implements CheckService {
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private ContestTypeMapper contestTypeMapper;
	@Override
	public UserOV<List<Contest>> getContestAll() {
		UserOV<List<Contest>> userOV = new UserOV<>();
		userOV.setData(contestMapper.listContestAll()).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<List<Contest>> getTypeContest(String type) {
		UserOV<List<Contest>> userOV = new UserOV<>();
		userOV.setData(contestMapper.listTypeContest(type)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<Contest> getContestDetails(int id) {
		UserOV<Contest> userOV = new UserOV<>();
		userOV.setData(contestMapper.getContestDetails(id)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<List<Contest>> listRankContest(int number) {
		UserOV<List<Contest>> userOV = new UserOV<>();
		userOV.setData(contestMapper.listRankContest(number)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<List<String>> listType() {
		UserOV<List<String>> userOV = new UserOV<>();
		userOV.setData(contestTypeMapper.listType()).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}
}
