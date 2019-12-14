package com.tidc.exam.controller;

import com.tidc.api.pojo.exam.*;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae FoundController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class FoundController{
	@Autowired
	private FoundService foundService;

	/**
	 * 创建一个题目
	 * @param question
	 * @return
	 */
	@PostMapping("/question")
	public UserOV foundQuestion(@RequestBody Question question){
		return foundService.foundQuestion(question);
	}

	/**
	 * 创建一个试卷
	 * @param examination
	 * @return
	 */
	@PostMapping("/examination")
	public UserOV foundExamination(@RequestBody Examination examination){
		return foundService.foundExamination(examination);
	}

	/**
	 * 给一张试卷增加试题
	 * @param examinationQuestion
	 * @return
	 */
	@PostMapping("/examination/question")
	public UserOV ExaminationAddQuestion(@RequestBody ExaminationQuestion examinationQuestion){
		return foundService.ExaminationAddQuestion(examinationQuestion);
	}

	/**
	 * 创建一个历史试卷 返回试卷id
	 * @param contestId
	 * @param examinationId
	 * @return
	 */
	@PostMapping("/history/examination")
	public UserOV<Integer> foundHistoryExamination(@RequestParam("contestId") int contestId,
												   @RequestParam("examinationId") int examinationId){
		return foundService.foundHistoryExamination(contestId,examinationId);
	}

	/**
	 * 给历史试卷连接题目 需要原试卷id和历史试卷id
	 * @param historyExamination
	 * @return
	 */
	@PostMapping("/history/examination/question")
	public UserOV historyJoinQuestion(@RequestBody HistoryExamination historyExamination){
		return foundService.historyJoinQuestion(historyExamination);
	}

	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	@PostMapping("/record")
	public UserOV<Record> record(@RequestBody Record record){
		return foundService.record(record);
	}

}
