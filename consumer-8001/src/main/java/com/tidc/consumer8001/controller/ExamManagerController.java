package com.tidc.consumer8001.controller;

import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.ExamManagerService;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassNmae ExamManagerController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class ExamManagerController {
	@Autowired
	private ExamManagerService examManagerService;
	/**
	 * 查看当前登录的用户的试卷集合 测试完成
	 * @return
	 */
	@GetMapping("/school/examination")
	public UserOV<List<Examination>> listExamination(HttpServletRequest req){
		return examManagerService.listExamination(req);
	}

	/**
	 * 查看当前登录的用户的题目集合 测试完成
	 * @return
	 */
	@GetMapping("/school/question")
	public UserOV<List<Question>> listQuestion(HttpServletRequest req) {
		return examManagerService.listQuestion(req);
	}

	/**
	 * 根据试卷id查看试卷的详情包括题目集
	 * @param id
	 * @return
	 */
	@GetMapping("/examination/{id}")
	public UserOV<Examination> getExaminationInQuestion(@PathVariable("id") int id){
		return examManagerService.getExaminationInQuestion(id);
	}

	/**
	 * 创建一个题目 测试完成
	 * @param question
	 * @return
	 */
	@PostMapping("/question")
	public UserOV foundQuestion(@RequestBody Question question, HttpServletRequest req){
		return examManagerService.foundQuestion(question,req);
	}

	/**
	 * 创建一个试卷 测试完成
	 * @param examination
	 * @return
	 */
	@PostMapping("/examination")
	public UserOV foundExamination(@RequestBody Examination examination,HttpServletRequest req){
		return examManagerService.foundExamination(examination,req);
	}

	/**
	 * 给一张试卷增加试题 测试完成
	 * @param examinationQuestion
	 * @return
	 */
	@PostMapping("/examination/question")
	public UserOV ExaminationAddQuestion(@RequestBody ExaminationQuestion examinationQuestion,HttpServletRequest req){
		return examManagerService.ExaminationAddQuestion(examinationQuestion,req);
	}
	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	@PutMapping("/question")
	public UserOV alterQuestion(@RequestBody Question question,HttpServletRequest req){
		return examManagerService.alterQuestion(question,req);

	}


}
