package com.tidc.contest8401.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.ExamManagerApi;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Record;
import com.tidc.contest8401.mapper.ContestApplyMapper;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.FoundService;
import com.tidc.contest8401.utils.CheckUtils;
import com.tidc.contest8401.utils.TimeUtil;
import com.tidc.utils.AffectUtils;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedHashMap;

/**
 * @ClassNmae foundServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FoundServiceImpl implements FoundService {
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private TeamMapper teamMapper;
	@Autowired
	private ContestApplyMapper contestApplyMapper;
	@Autowired
	private RabbitManagerApi rabbitManagerApi;
	@Autowired
	private CheckUtils checkUtils;
	@Autowired
	private ExamManagerApi examManagerApi;
	@Override
	public UserOV<Integer> foundService(Contest contest, String school_email) throws ParseException {
		UserOV userOV2 = userManagerApi.userInfo(school_email);
		LinkedHashMap data = (LinkedHashMap) userOV2.getData();
		//这里获取到创建学校的所有信息
		School school = objectMapper.convertValue(data, new TypeReference<School>(){});
		contest.setSchool_id(school.getId());
		contest.setNumber(0);
		contest.setIs_show(0);
		boolean open = TimeUtil.is_open(contest.getStart(),"yyyy-MM-dd");
		if(open){
			contest.setIs_open(1);
		}else{
			contest.setIs_open(0);
		}
		UserOV<Integer> userOV = new UserOV<>();
		if (!CheckObjectIsNullUtils.contestObjCheckIsNull(contest)) {
			userOV.setStatus(CodeConstant.FAIL).setMessage("有字段未填写");
		}else{
			int count = contestMapper.insetContest(contest);
			if (count == 1) {
				//生成历史试卷
				if(contest.getHistory_examination_id()!=null){
					//先生成历史试卷和绑定试题
					rabbitManagerApi.foundHistoryExamination(contest.getId(),contest.getHistory_examination_id());
				}
				userOV.setStatus(CodeConstant.SUCCESS).setData(contest.getId());
			} else {
				userOV.setStatus(CodeConstant.FAIL);
			}
		}
		return userOV;
	}

	/**
	 * 报名比赛
	 * @param work
	 * @param email
	 * @return
	 */
	@Override
	public UserOV work(Work work,String email) {
		UserOV userOV1 = userManagerApi.userInfo(email);
		Student student = objectMapper.convertValue(userOV1.getData(), new TypeReference<Student>() {});
		Team team = new Team();
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		//判断是否可以报名
		if (checkUtils.checkWorkApplyOpen(work.getContest_id())) {
			work.setStudent_id(student.getId());
			work.setScore(new BigDecimal("0.00"));
			workMapper.insetWork(work);
			//增加一个队长
			team.setStudent_id(student.getId());
			team.setWork_id(work.getId());
			int count = teamMapper.insertLeader(team);
			//增加比赛number
			int count2 = contestMapper.addNumber(work.getContest_id());
			if(count==1&&count2==1){
				userOV.setStatus(CodeConstant.SUCCESS);
			}
		}else{
			userOV.setMessage("该比赛没有开放报名");
		}
		return userOV;
	}

	@Override
	public UserOV apply(ContestApply contestApply) {
		UserOV userOV = new UserOV();
		if (checkUtils.checkWorkApplyOpen(contestApply.getContest_id())) {
			Contest contest = contestMapper.getContest(contestApply.getContest_id());
			contestApply.setHistory_examination_id(contest.getHistory_examination_id());
			int count = contestApplyMapper.apply(contestApply);
			AffectUtils.affectOne(count,userOV);
		}else{
			userOV.setMessage("该比赛没有开放报名");
		}
		return userOV;
	}

	@Override
	public UserOV record(Record record) throws ParseException {
		Contest contest = contestMapper.getContest(record.getContest_id());
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		record.setHistory_examination_id(contest.getHistory_examination_id());
		UserOV<HistoryExamination> historyExamination = examManagerApi.getHistoryExamination(record.getHistory_examination_id());
		//根据比赛id查看该学生是否有报名 以及 是否在交卷时间内
		if(checkUtils.checkApply(record)&&TimeUtil.calculatePaperTime(contest.getStart_time(),historyExamination.getData().getTime())) {
			//交卷
			UserOV<Record> recordUserOV = examManagerApi.record(record);
			//修改分数
			contestApplyMapper.updateRecordAndScore(recordUserOV.getData());
			userOV.setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setMessage("没报名或未到交卷时间无法交卷");
		}
		return userOV;
	}

}
