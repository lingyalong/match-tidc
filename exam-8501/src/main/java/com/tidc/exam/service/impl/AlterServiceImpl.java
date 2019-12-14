package com.tidc.exam.service.impl;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.QuestionMapper;
import com.tidc.exam.service.AlterService;
import com.tidc.exam.util.CheckPowerUtils;
import com.tidc.utils.AffectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae AlterServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class AlterServiceImpl implements AlterService {
	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private CheckPowerUtils checkPowerUtils;
	@Autowired
	private ExaminationMapper examinationMapper;
	@Override
	public UserOV alterQuestion(Question question) {
		UserOV userOV = new UserOV();
		if (checkPowerUtils.checkQuestionPower(question.getId(),question.getSchool_id())) {
			int count = questionMapper.updateQuestion(question);
			AffectUtils.affectOne(count,userOV);
		}
		return userOV;
	}

	@Override
	public UserOV alterExamination(Examination examination) {
		UserOV userOV = new UserOV();
		if(checkPowerUtils.checkExaminationPower(examination.getId(),examination.getSchool_id())){
			int count = examinationMapper.updateExamination(examination);
			AffectUtils.affectOne(count,userOV);
		}
		return userOV;
	}
}
