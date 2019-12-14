package com.tidc.exam.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.pojo.exam.*;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.*;
import com.tidc.exam.service.FoundService;
import com.tidc.utils.AffectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNmae FoundServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FoundServiceImpl implements FoundService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private ExaminationMapper examinationMapper;
	@Autowired
	private ExaminationQuestionMapper examinationQuestionMapper;
	@Autowired
	private HistoryExaminationMapper historyExaminationMapper;
	@Autowired
	private HistoryQuestionMapper historyQuestionMapper;
	@Autowired
	private HistoryExaminationQuestionMapper historyExaminationQuestionMapper;
	@Autowired
	private RabbitManagerApi rabbitManagerApi;
	@Autowired
	private ContestManagerApi contestManagerApi;
	@Autowired
	private RecordMapper recordMapper;
	@Override
	public UserOV foundQuestion(Question question) {
		UserOV userOV = new UserOV();
		int questionCount = questionMapper.foundQuestion(question);
		AffectUtils.affectOne(questionCount,userOV);
		return userOV;
	}

	@Override
	public UserOV foundExamination(Examination examination) {
		UserOV userOV = new UserOV();
		int examinationCount = examinationMapper.foundExamination(examination);
		AffectUtils.affectOne(examinationCount,userOV);
		return userOV;
	}

	@Override
	public UserOV ExaminationAddQuestion(ExaminationQuestion examinationQuestion) {
		UserOV userOV = new UserOV();
		int count = examinationQuestionMapper.foundRelevance(examinationQuestion);
		AffectUtils.affectOne(count,userOV);
		return userOV;
	}

	@Override
	public UserOV<Integer> foundHistoryExamination(int contestId, int examinationId) {
		UserOV<Integer> userOV = new UserOV<>();
		Examination examination = examinationMapper.getExamination(examinationId);
		HistoryExamination historyExamination = new HistoryExamination(examination);
		historyExamination.setContest_id(contestId);
		//创建
		int count = historyExaminationMapper.insertHistoryExamination(historyExamination);
		//讲历史试卷id绑定到比赛上
		contestManagerApi.updateContestHistoryExamination(historyExamination);
		rabbitManagerApi.historyJoinQuestion(historyExamination);
		AffectUtils.affectOne(count,userOV);
		userOV.setData(historyExamination.getId());
		return userOV;
	}


	@Override
	public UserOV historyJoinQuestion(HistoryExamination historyExamination) {
		UserOV userOV = new UserOV();
		//查出当前试卷的连接的题目 然后 复制 然后建立历史连接
		List<ExaminationQuestion> list = examinationQuestionMapper.listExaminationQuestion(historyExamination.getExaminationId());
		List<Question> questions = questionMapper.listQuestion(list);
		//
		List<Integer> historyQuestionIds = new ArrayList<>();
		//复制
		//这里返回id 不能数组接受 只能返回到list 对象里 sql可能户
		historyQuestionMapper.copyQuestion(questions);
		for (Question question : questions) {
			historyQuestionIds.add(question.getId());
		}
		historyExamination.setHistoryQuestionIds(historyQuestionIds);
		//建立连接
		historyExaminationQuestionMapper.join(historyExamination);
		userOV.setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<Record> record(Record record) {
		UserOV<Record> userOV = new UserOV<>();
		//改卷
		//分割答案
		String[] answer = record.getAnswer().split(",");
//		获取某个历史卷的答案
		List<HistoryQuestion> answerAndScore = historyQuestionMapper.getAnswerAndScore(record.getHistory_examination_id());
		//对照并加分
		int i = 0;
		int count = 0;
		BigDecimal score = new BigDecimal("0.00");
		for (HistoryQuestion historyQuestion : answerAndScore) {
			if (historyQuestion.getAnswer().equals(answer[i])) {
				count++;
				score = score.add(historyQuestion.getScore());
			}
			i++;
		}
		record.setScore(score).setCorrect(count);
		int flag = recordMapper.insertRecord(record);
		AffectUtils.affectOne(flag,userOV);
		userOV.setData(record);
		return userOV;
	}

}
