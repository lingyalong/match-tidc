package com.tidc.exam.controller;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.service.DeleteService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae DeleteController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class DeleteController {
	@Autowired
	private DeleteService deleteService;

	/**
	 * 删除题目
	 * @param question
	 * @return
	 */
	@DeleteMapping("/question")
	public UserOV deleteQuestion(@RequestBody Question question){
		return deleteService.deleteQuestion(question);
	}

	/**
	 * 删除试卷
	 * @param examination
	 * @return
	 */
	@DeleteMapping("/examination")
	public UserOV deleteExamination(@RequestBody Examination examination){
		return deleteService.deleteExamination(examination);
	}

	/**
	 * 给一张试卷删除试题
	 * @param examinationQuestion
	 * @return
	 */
	@DeleteMapping("/examination/question")
	public UserOV examinationDeleteQuestion(@RequestBody ExaminationQuestion examinationQuestion){
		return deleteService.examinationDeleteQuestion(examinationQuestion);
	}
}
