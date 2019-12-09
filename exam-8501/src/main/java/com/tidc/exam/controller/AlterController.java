package com.tidc.exam.controller;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.mapper.QuestionMapper;
import com.tidc.exam.service.AlterService;
import com.tidc.exam.util.CheckPowerUtils;
import com.tidc.utils.AffectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae AlterController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class AlterController {
	@Autowired
	private AlterService alterService;
	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	@PutMapping("/question")
	public UserOV alterQuestion(@RequestBody Question question){
		return alterService.alterQuestion(question);
	}

	/**
	 * 修改试卷
	 * @param examination
	 * @return
	 */
	@PutMapping("examination")
	public UserOV alterExamination(@RequestBody Examination examination){
		return alterService.alterExamination(examination);
	}
}
