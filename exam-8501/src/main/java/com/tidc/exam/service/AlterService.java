package com.tidc.exam.service;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.stereotype.Repository;

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
