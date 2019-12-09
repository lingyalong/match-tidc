package com.tidc.exam.service;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae DeleteService
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface DeleteService {
	/**
	 * 删除题目
	 * @param question
	 * @return
	 */
	UserOV deleteQuestion(Question question);

	/**
	 * 删除试卷
	 * @param examination
	 * @return
	 */
	UserOV deleteExamination(Examination examination);

	/**
	 * 给一张试卷删除试题
	 * @param examinationQuestion
	 * @return
	 */
	UserOV examinationDeleteQuestion(ExaminationQuestion examinationQuestion);
}
