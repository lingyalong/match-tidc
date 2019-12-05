package com.tidc.exam.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.ExaminationQuestionMapper;
import com.tidc.exam.mapper.QuestionMapper;
import com.tidc.exam.service.FoundService;
import com.tidc.utils.AffectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
