package com.tidc.exam.service;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae AlterService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface AlterService {
	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	UserOV alterQuestion(Question question);

	/**
	 * 修改试卷
	 * @param examination
	 * @return
	 */
	UserOV alterExamination(Examination examination);
}
