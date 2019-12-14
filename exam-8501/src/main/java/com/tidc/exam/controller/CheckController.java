package com.tidc.exam.controller;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import com.tidc.exam.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae CheckController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class CheckController{
	@Autowired
	private CheckService checkService;
	/**
	 * 根据id查看学校的试卷集合
	 * @param schoolId
	 * @return
	 */
	@GetMapping("/school/examination")
	public UserOV<List<Examination>> listExamination(@RequestParam("schoolId") int schoolId){
		return checkService.listExamination(schoolId);
	}

	/**
	 * 根据学校id查看学校的题目集合
	 * @param schoolId
	 * @return
	 */
	@GetMapping("/school/question")
	public UserOV<List<Question>> listQuestion(@RequestParam("schoolId") int schoolId){
		return checkService.listQuestion(schoolId);
	}

	/**
	 * 根据试卷id查看试卷的详情包括题目集
	 * @param id
	 * @return
	 */
	@GetMapping("/examination/{id}")
	public UserOV<Examination> getExaminationInQuestion(@PathVariable("id") int id){
		return checkService.getExaminationInQuestion(id);
	}

	/**
	 * 根据id获取历史试卷
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/history/exam/{id}")
	public UserOV<HistoryExamination> getHistoryExamination(@PathVariable("id") int id){
		return checkService.getHistoryExamination(id);
	}
}
