package com.tidc.consumer8001.controller;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.ExaminationQuestion;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.consumer8001.service.ExamManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
	public UserOV<List<Examination>> listExamination(HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.listExamination(req);
	}

	/**
	 * 查看当前登录的用户的题目集合 测试完成
	 * @return
	 */
	@GetMapping("/school/question")
	public UserOV<List<Question>> listQuestion(HttpServletRequest req)throws InvalidTokenException {
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
	public UserOV foundQuestion(@RequestBody Question question, HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.foundQuestion(question,req);
	}

	/**
	 * 创建一个试卷 测试完成
	 * @param examination
	 * @return
	 */
	@PostMapping("/examination")
	public UserOV foundExamination(@RequestBody Examination examination,HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.foundExamination(examination,req);
	}

	/**
	 * 给一张试卷增加试题 测试完成
	 * @param examinationQuestion
	 * @return
	 */
	@PostMapping("/examination/question")
	public UserOV ExaminationAddQuestion(@RequestBody ExaminationQuestion examinationQuestion,HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.ExaminationAddQuestion(examinationQuestion,req);
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
		return examManagerService.foundHistoryExamination(contestId,examinationId);
	}
	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	@PutMapping("/question")
	public UserOV alterQuestion(@RequestBody Question question,HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.alterQuestion(question,req);

	}

	/**
	 * 修改试卷
	 * @param examination
	 * @return
	 */
	@PutMapping("examination")
	public UserOV alterExamination(@RequestBody Examination examination,HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.alterExamination(examination,req);
	}

	/**
	 * 删除题目
	 * @param question
	 * @return
	 */
	@DeleteMapping("/question")
	public UserOV deleteQuestion(@RequestBody Question question,HttpServletRequest req)throws InvalidTokenException{
		return examManagerService.deleteQuestion(question,req);
	}

	/**
	 * 删除试卷
	 * @param examination
	 * @return
	 */
	@DeleteMapping("/examination")
	public UserOV deleteExamination(@RequestBody Examination examination,HttpServletRequest req)throws InvalidTokenException {
		return examManagerService.deleteExamination(examination,req);
	}

	/**
	 * 给一张试卷删除试题
	 * @param examinationQuestion
	 * @return
	 */
	@DeleteMapping("/examination/question")
	public UserOV examinationDeleteQuestion(@RequestBody ExaminationQuestion examinationQuestion,HttpServletRequest req){
		return examManagerService.examinationDeleteQuestion(examinationQuestion,req);
	}



}
