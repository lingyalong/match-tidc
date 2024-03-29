package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.ExamManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.contest8401.mapper.*;
import com.tidc.contest8401.service.CheckService;
import com.tidc.contest8401.utils.CheckUtils;
import com.tidc.contest8401.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private PowerMapeer powerMapeer;
	@Autowired
	private ExamManagerApi examManagerApi;
	@Autowired
	private ContestApplyMapper contestApplyMapper;
	@Autowired
	private CheckUtils checkUtils;
	Logger logger = LoggerFactory.getLogger(CheckServiceImpl.class);
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

	@Override
	public UserOV<List<Contest>> checkShowScoreContest() {
		UserOV<List<Contest>> userOV = new UserOV<>();
		List<Contest> list = contestMapper.checkShowScoreContest();
		userOV.setStatus(CodeConstant.SUCCESS).setData(list);
		return userOV;
	}

	@Override
	public UserOV<List<Work>> checkContestWorkScore(int id) {
		UserOV<List<Work>> userOV = new UserOV<>();
		//判断分数是否公开
		if (checkUtils.checkPublic(id)) {
			userOV.setStatus(CodeConstant.SUCCESS).setData(workMapper.checkScore(id));
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("比赛成绩尚未公开");
		}
		return userOV;
	}

	@Override
	public UserOV<List<Contest>> listTeacherContest(int teacherId) {
		UserOV<List<Contest>> userOV = new UserOV<>();
		userOV.setData(contestMapper.listTeacherContest(teacherId)).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<List<Work>> listTeacherContestWork(int id, int teacherId) {
		UserOV<List<Work>> userOV = new UserOV<>();
		userOV.setStatus(CodeConstant.FAIL);
		Power power = new Power();
		power.setTeacher_id(teacherId).setContest_id(id);
		Integer powerCount = powerMapeer.checkRepetition(power);
		int isAnonymous = contestMapper.checkAnonymous(id);
		List<Work> works = null;
		if(powerCount!=null){
			if(isAnonymous==1){
				//匿名
				works = workMapper.listWork(id);
				userOV.setData(works);
			}else{
				works = workMapper.checkScore(id);
				userOV.setData(works);
			}
		}else{
			userOV.setMessage("你没有这个比赛的权限");
			logger.info("teacher_id:"+"试图越权获取 contest_id:"+id+"的项目列表");
		}
		return userOV;
	}

	@Override
	public UserOV<List<ContestApply>> listContestApply(int id) {
		UserOV<List<ContestApply>> userOV = new UserOV<>();
		if (checkUtils.checkPublic(id)) {
			List<ContestApply> rank = contestApplyMapper.getRank(id);
			userOV.setData(rank);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("比赛成绩尚未公开");
		}

		return userOV;
	}

	@Override
	public UserOV<HistoryExamination> getContestExamination(int id) throws ParseException {
		UserOV<HistoryExamination> userOV = new UserOV<>();
		Contest contest = contestMapper.getContest(id);
		userOV.setStatus(CodeConstant.FAIL);
		//判断是否开考
		if(contest.getIs_exam().equals(1)&& TimeUtil.is_open(contest.getStart_time(),"yyyy-MM-dd HH:mm")){
			userOV = examManagerApi.getHistoryExamination(contest.getHistory_examination_id());
		}else{
			userOV.setMessage("该比赛没有试卷或尚未开始比赛");
		}
		return userOV;
	}


}
