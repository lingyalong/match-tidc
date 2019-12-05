package com.tidc.exam.service;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae FoundService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FoundService {
	/**
	 * 创建一个试题
	 * @param question
	 * @return
	 */
	UserOV foundQuestion(Question question);

	/**
	 * 创建一个试卷
	 * @param examination
	 * @return
	 */
	UserOV foundExamination(Examination examination);

	/**
	 * 给一张试卷增加试题
	 * @param examinationQuestion
	 * @return
	 */
	UserOV ExaminationAddQuestion(ExaminationQuestion examinationQuestion);
}
