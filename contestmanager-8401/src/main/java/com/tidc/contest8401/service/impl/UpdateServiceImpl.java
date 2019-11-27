package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNmae UpdateServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class UpdateServiceImpl implements UpdateService {
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private RabbitManagerApi rabbitManagerApi;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private UserManagerApi userManagerApi;
	@Override
	public UserOV<Contest> updateContest(Contest contest) {
		UserOV<Contest> userOV = new UserOV<>();
		Contest contest2 = contestMapper.getContest(contest.getId());
		int count = contestMapper.updateContest(contest);
		if(count==1){
			if(contest.getUrl()!=null){
				rabbitManagerApi.deleteFile(contest2.getUrl());
			}
			if(contest.getLogo()!=null){
				rabbitManagerApi.deleteFile(contest2.getLogo());
			}
			//通知已经报名的同学
			if(contest2.getNumber()>0){
				List<Integer> listStudentID = workMapper.listStudentID(contest.getId());
				UserOV<List<String>> userOV1 = userManagerApi.listStudentEmail(listStudentID);
				//邮箱集合
				List<String> listEmail = userOV1.getData();
				Map map = new HashMap();

				map.put("list",listEmail);
				map.put("head","您参加的比赛发生了变化");
				map.put("message","您参加的"+contest2.getName()+"发生了改变请去查看一下");
				rabbitManagerApi.sendListMessage(map);
			}
			userOV.setStatus(CodeConstant.UPDATE);
		}else{
			userOV.setStatus(CodeConstant.FAIL);
		}

		return userOV;
	}
}
