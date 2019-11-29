package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.PowerMapeer;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.DeleteService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae DeleteServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class DeleteServiceImpl implements DeleteService{
	@Autowired
	private TeamMapper teamMapper;
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private RabbitManagerApi rabbitManagerApi;
	@Autowired
	private PowerMapeer powerMapeer;
	Logger logger = LoggerFactory.getLogger(DeleteServiceImpl.class);
	@Override
	public UserOV deleteMember(Team team) {
		UserOV userOV = new UserOV();
		//查询leader
		userOV.setStatus(CodeConstant.FAIL);
		Integer leader_id = teamMapper.checkLeader(team.getWork_id());
		if(team.getLeaderId().equals(leader_id)){
			int count = teamMapper.deleteMember(team);
			if(count==0){
				userOV.setMessage("删除失败");
				logger.info("删除队员失败"+team);
			}else{
				userOV.setStatus(CodeConstant.SUCCESS);
			}
		}else{
			userOV.setMessage("你无权删除这个别的队伍的队员");
			logger.info("有人试图越权删除别人的队员" + team);
		}

		return userOV;
	}

	@Override
	public UserOV deleteContest(Contest contest) {
		UserOV userOV  = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Integer leader = contestMapper.checkLeader(contest.getId());
		if(leader.equals(contest.getSchool_id())){
			int contestCount = contestMapper.deleteContest(contest.getId());
			if(contestCount==1){
				powerMapeer.deleteContestPower(contest.getId());
				rabbitManagerApi.deleteWorkANdTeam(contest.getId());
				userOV.setStatus(CodeConstant.SUCCESS);

			}
		}else{
			userOV.setMessage("你没有权限删除这个比赛");
			logger.info("schoolID: " + contest.getSchool_id() + "试图越权删除contestID: " + contest.getId());
		}

		return userOV;
	}

	@Override
	public UserOV deleteWork(Work work) {
		UserOV userOV  = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Integer leader_id = workMapper.checkLeader(work.getId());
		if(leader_id.equals(work.getStudent_id())){
			int count = workMapper.deleteWork(work.getId());
			int count2 = teamMapper.deleteWorkTeam(work.getId());
			if(count==1){
				if(count2==0){
					logger.info("删除项目成功了但是队员没有删除");
				}else{
					userOV.setStatus(CodeConstant.SUCCESS);
				}
			}else{
				userOV.setMessage("项目删除失败");
				logger.info("删除项目失败");
			}
		}


		return userOV;
	}

	@Override
	public UserOV deleteWorkAndTeam(int contest_id) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		List<Work> works = workMapper.listWork(contest_id);
		for (Work work : works) {
			int teamCount = teamMapper.deleteWorkTeam(work.getId());
			int workCount = workMapper.deleteWork(work.getId());
			if(teamCount==0){
				logger.info(work + "的队员删除未完成");
			}
			if(workCount==0){
				logger.info(work + "删除失败");
			}
		}
		return userOV;
	}

	@Override
	public UserOV deletePower(Power power) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Integer leader = contestMapper.checkLeader(power.getContest_id());
		if(leader.equals(power.getUserId())){
			int powerCount = powerMapeer.deletePower(power.getId());
			if(powerCount>0){
				userOV.setStatus(CodeConstant.SUCCESS);
			}
		}
		return userOV;
	}
}
