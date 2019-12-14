package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.UpdateService;
import com.tidc.contest8401.utils.CheckUtils;
import com.tidc.utils.AffectUtils;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassNmae UpdateSearviceImpl
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
	@Autowired
	private CheckUtils checkUtils;
	//没有权限校验
	@Override
	public UserOV<Contest> updateContest(Contest contest) {
		UserOV<Contest> userOV = new UserOV<>();
		userOV.setStatus(CodeConstant.FAIL);
		Contest contest2 = contestMapper.getContest(contest.getId());
		if(checkUtils.checkContest(contest)){
			int count = contestMapper.updateContest(contest);
			if(count==1){
				if(contest.getUrl()!=null){
					rabbitManagerApi.deleteFile(contest2.getUrl());
				}
				if(contest.getLogo()!=null){
					rabbitManagerApi.deleteFile(contest2.getLogo());
				}
				if(contest2.getNumber()>0){
					List<Integer> listStudentID = workMapper.listStudentID(contest.getId());
					UserOV<List<String>> userOV1 = userManagerApi.listStudentEmail(listStudentID);
					List<String> listEmail = userOV1.getData();
					Map map = new HashMap();
					map.put("list",listEmail);
					map.put("head","您参加的比赛发生了变化");
					map.put("message","您参加的"+contest2.getName()+"发生了改变请去查看一下");
					rabbitManagerApi.sendListMessage(map);
				}
				userOV.setStatus(CodeConstant.UPDATE);
			}
		}else{
			userOV.setMessage("你没有权限操作这个比赛");
		}
		return userOV;
	}

	@Override
	public UserOV updateContestIsShow(Contest contest) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		if(checkUtils.checkContest(contest)){
			if(contest.getIs_show()!=null){
				int count = contestMapper.updateIsShow(contest);
				if(count==1){
					userOV.setStatus(CodeConstant.SUCCESS);
				}
			}
		}else{
			userOV.setMessage("你没有权限操作这个比赛");
		}
		return userOV;
	}

	@Override
	public UserOV updateWork(Work work) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Integer workLeader = workMapper.checkLeader(work.getId());
		if(workLeader.equals(work.getStudent_id())){
			int workCount = workMapper.updateWork(work);
			if(workCount==1){
				userOV.setStatus(CodeConstant.SUCCESS);
			}
		}else{
			userOV.setMessage("你没有权限操作这个项目");
		}
		return userOV;
	}

	@Override
	public UserOV updateContestIsOpen(Contest contest) {
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		if(checkUtils.checkContest(contest)){
			contestMapper.updateIsOpen(contest);
			userOV.setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setMessage("你没有权限操作这个项目");
		}
		return userOV;
	}

	@Override
	public UserOV updateContestHistoryExamination(HistoryExamination historyExamination) {
		UserOV userOV = new UserOV();
		int count = contestMapper.updateHistoryExaminationId(historyExamination);
		AffectUtils.affectOne(count,userOV);
		return userOV;
	}
}
