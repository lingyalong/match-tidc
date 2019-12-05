package com.tidc.exam.util;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.Question;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae CheckPowerUtils
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class CheckPowerUtils{
	@Autowired
	public QuestionMapper questionMapper;
	@Autowired
	public ExaminationMapper examinationMapper;
	public boolean CheckQuestionPower(int id,int schoolId){
		Question question = questionMapper.getQuestion(id);
		return question.getSchool_id().equals(schoolId);
	}
	public boolean CheckExaminationPower(int id,int schoolId){
		Examination examination1 = examinationMapper.getExamination(id);
		return examination1.getSchool_id().equals(schoolId);
	}
}
