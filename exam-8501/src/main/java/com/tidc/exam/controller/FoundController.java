package com.tidc.exam.controller;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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


}
