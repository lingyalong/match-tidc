package com.tidc.exam.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.ExaminationMapper;
import com.tidc.exam.mapper.HistoryExaminationMapper;
import com.tidc.exam.mapper.QuestionMapper;
import com.tidc.exam.service.CheckService;
import com.tidc.exam.util.CheckPowerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae CheckServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class CheckServiceImpl implements CheckService {
	@Autowired
	private ExaminationMapper examinationMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private CheckPowerUtils checkPowerUtils;
	@Autowired
	private HistoryExaminationMapper historyExaminationMapper;;

	@Override
	public UserOV<List<Examination>> listExamination(int schoolId) {
		UserOV<List<Examination>> userOV = new UserOV<>();
		List<Examination> examinations = examinationMapper.listSchoolExamination(schoolId);
		userOV.setStatus(CodeConstant.SUCCESS).setData(examinations);
		return userOV;
	}

	@Override
	public UserOV<List<Question>> listQuestion(int schoolId) {
		UserOV<List<Question>> userOV = new UserOV<>();
		List<Question> questions = questionMapper.listSchoolQuestion(schoolId);
		userOV.setStatus(CodeConstant.SUCCESS).setData(questions);
		return userOV;
	}

	@Override
	public UserOV<Examination> getExaminationInQuestion(int id) {
		UserOV<Examination> userOV = new UserOV<>();
		Examination examination = examinationMapper.getExaminationInQuestion(id);
		userOV.setData(examination).setStatus(CodeConstant.SUCCESS);
		return userOV;
	}

	@Override
	public UserOV<HistoryExamination> getHistoryExamination(int id) {
		UserOV<HistoryExamination> userOV = new UserOV<>();
		HistoryExamination historyExaminationAndQuestion = historyExaminationMapper.getHistoryExaminationAndQuestion(id);
		if(historyExaminationAndQuestion!=null){
			userOV.setData(historyExaminationAndQuestion).setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("这个试卷不存在");
		}
		return userOV;
	}
}
