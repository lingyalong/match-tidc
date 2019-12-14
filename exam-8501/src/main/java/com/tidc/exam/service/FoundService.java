package com.tidc.exam.service;

import com.tidc.api.pojo.exam.*;
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


	/**
	 * 创建一个历史试卷 返回试卷id
	 * @param contestId
	 * @param examinationId
	 * @return
	 */
	UserOV<Integer> foundHistoryExamination(int contestId,int examinationId);


	/**
	 * 给历史试卷连接题目
	 * @param historyExamination
	 * @return
	 */
	UserOV historyJoinQuestion(HistoryExamination historyExamination);

	/**
	 * 交卷
	 * @param record
	 * @return
	 */
	UserOV<Record> record(Record record);
}
