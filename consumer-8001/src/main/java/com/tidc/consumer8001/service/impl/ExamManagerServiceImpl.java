package com.tidc.consumer8001.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.ExamManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.ExaminationQuestion;
import com.tidc.api.pojo.exam.Question;
import com.tidc.consumer8001.service.ExamManagerService;
import com.tidc.consumer8001.utils.UserInfo;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae ExamManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class ExamManagerServiceImpl implements ExamManagerService {
	@Autowired
	private ExamManagerApi examManagerApi;
	@Autowired
	private UserInfo userInfo;

	@Override
	public UserOV<List<Examination>> listExamination(HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		return examManagerApi.listExamination(school.getId());
	}

	@Override
	public UserOV<List<Question>> listQuestion(HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		return examManagerApi.listQuestion(school.getId());
	}

	@Override
	public UserOV<Examination> getExaminationInQuestion(int id) {
		return examManagerApi.getExaminationInQuestion(id);
	}

	@Override
	public UserOV foundQuestion(Question question, HttpServletRequest req)throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		question.setSchool_id(school.getId());
		return examManagerApi.foundQuestion(question);
	}

	@Override
	public UserOV foundExamination(Examination examination,HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		examination.setSchool_id(school.getId());
		return examManagerApi.foundExamination(examination);
	}

	@Override
	public UserOV ExaminationAddQuestion(ExaminationQuestion examinationQuestion, HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		examinationQuestion.setSchool_id(school.getId());
		boolean b = CheckObjectIsNullUtils.contestObjCheckIsNull(examinationQuestion);
		UserOV userOV = new UserOV();
		if(b){
			userOV = examManagerApi.ExaminationAddQuestion(examinationQuestion);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("有字段未填写");
		}
		return userOV;
	}

	@Override
	public UserOV<Integer> foundHistoryExamination(int contestId, int examinationId) {
		return examManagerApi.foundHistoryExamination(contestId,examinationId);
	}

	@Override
	public UserOV alterQuestion(Question question,HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		question.setSchool_id(school.getId());
		return examManagerApi.alterQuestion(question);
	}

	@Override
	public UserOV alterExamination(Examination examination,HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		examination.setSchool_id(school.getId());
		return examManagerApi.alterExamination(examination);
	}

	@Override
	public UserOV deleteQuestion(Question question, HttpServletRequest req) throws InvalidTokenException{
		School school = (School) userInfo.userInfo(req,3);
		question.setSchool_id(school.getId());
		return examManagerApi.deleteQuestion(question);
	}

	@Override
	public UserOV deleteExamination(Examination examination, HttpServletRequest req) throws InvalidTokenException {
		School school = (School) userInfo.userInfo(req,3);
		examination.setSchool_id(school.getId());
		return examManagerApi.deleteExamination(examination);
	}

	@Override
	public UserOV examinationDeleteQuestion(ExaminationQuestion examinationQuestion, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		examinationQuestion.setSchool_id(school.getId());
		return examManagerApi.examinationDeleteQuestion(examinationQuestion);
	}


}
