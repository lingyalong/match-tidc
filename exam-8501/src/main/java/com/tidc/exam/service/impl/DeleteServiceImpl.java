package com.tidc.exam.service.impl;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.ExaminationQuestionMapper;
import com.tidc.exam.mapper.QuestionMapper;
import com.tidc.exam.service.DeleteService;
import com.tidc.exam.util.CheckPowerUtils;
import com.tidc.utils.AffectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae DeleteServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class DeleteServiceImpl implements DeleteService {
	@Autowired
	private CheckPowerUtils checkPowerUtils;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private ExaminationMapper examinationMapper;
	@Autowired
	private ExaminationQuestionMapper examinationQuestionMapper;
	@Override
	public UserOV deleteQuestion(Question question) {
		UserOV userOV = new UserOV();
		if(checkPowerUtils.checkQuestionPower(question.getId(),question.getSchool_id())){
			examinationQuestionMapper.deleteQuestion(question.getId());
			int count = questionMapper.deleteQuestion(question.getId());
			AffectUtils.affectOne(count,userOV);
		}
		return userOV;
	}

	@Override
	public UserOV deleteExamination(Examination examination) {
		UserOV userOV = new UserOV();
		if(checkPowerUtils.checkExaminationPower(examination.getId(),examination.getSchool_id())){
			examinationQuestionMapper.deleteExamination(examination.getId());
			int count = examinationMapper.deleteExamination(examination.getId());
			AffectUtils.affectOne(count,userOV);
		}
		return userOV;
	}

	@Override
	public UserOV examinationDeleteQuestion(ExaminationQuestion examinationQuestion) {
		UserOV userOV = new UserOV();
		if(checkPowerUtils.CheckExAndQue(examinationQuestion)){
			int count = examinationQuestionMapper.examinationDeleteQuestion(examinationQuestion);
			AffectUtils.affectOne(count,userOV);
		}
		return userOV;
	}
}
