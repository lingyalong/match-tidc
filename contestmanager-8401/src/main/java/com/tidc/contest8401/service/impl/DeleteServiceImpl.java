package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Team;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae DeleteServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class DeleteServiceImpl implements DeleteService{
	@Autowired
	private TeamMapper teamMapper;
	@Override
	public UserOV deleteMember(Team team) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.SUCCESS);
		int count = teamMapper.deleteMember(team);
		if(count==0){
			userOV.setStatus(CodeConstant.FAIL);
		}
		return userOV;
	}
}
