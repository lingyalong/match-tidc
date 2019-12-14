package com.tidc.exam.util;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.ExaminationQuestion;
import com.tidc.api.pojo.exam.Question;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae CheckPowerUtils
 * @Description TODO 检查权限的工具类
 * @Author 冯涛滔
 **/

@Component
public class CheckPowerUtils{
	@Autowired
	public QuestionMapper questionMapper;
	@Autowired
	public ExaminationMapper examinationMapper;
	public boolean checkQuestionPower(int id, int schoolId){
		Question question = questionMapper.getQuestion(id);
		return question.getSchool_id().equals(schoolId);
	}
	public boolean checkExaminationPower(int id, int schoolId){
		Examination examination1 = examinationMapper.getExamination(id);
		return examination1.getSchool_id().equals(schoolId);
	}
	public boolean CheckExAndQue(ExaminationQuestion examinationQuestion){
		boolean a = checkQuestionPower(examinationQuestion.getQuestion_id(), examinationQuestion.getSchool_id());
		boolean b = checkExaminationPower(examinationQuestion.getExamination_id(), examinationQuestion.getSchool_id());
		return a&&b;
	}
}
