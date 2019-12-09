package com.tidc.api.controller;

import com.tidc.api.fallback.FileManagerFallbackFactory;
import com.tidc.api.pojo.Examination;
import com.tidc.api.pojo.ExaminationQuestion;
import com.tidc.api.pojo.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae ExamManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "EXAMMANAGER",fallbackFactory = FileManagerFallbackFactory.class)
public interface ExamManagerApi {
	/**
	 * 根据id查看学校的试卷集合
	 * @param schoolId
	 * @return
	 */
	@RequestMapping(value = "/school/examination",method = RequestMethod.GET)
	UserOV<List<Examination>> listExamination(@RequestParam("schoolId") int schoolId);

	/**
	 * 根据学校id查看学校的题目集合
	 * @param schoolId
	 * @return
	 */
	@RequestMapping(value = "/school/question",method = RequestMethod.GET)
	UserOV<List<Question>> listQuestion(@RequestParam("schoolId") int schoolId);


	/**
	 * 根据试卷id查看试卷的详情包括题目集
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/examination/{id}",method = RequestMethod.GET)
	UserOV<Examination> getExaminationInQuestion(@PathVariable("id") int id);

	/**
	 * 创建一个题目
	 * @param question
	 * @return
	 */
	@RequestMapping(value = "/question",method = RequestMethod.POST)
	UserOV foundQuestion(@RequestBody Question question);

	/**
	 * 创建一个比赛
	 * @param examination
	 * @return
	 */
	@RequestMapping(value = "/examination",method = RequestMethod.POST)
	UserOV foundExamination(@RequestBody Examination examination);

	/**
	 * 给一张试卷增加试题
	 * @param examinationQuestion
	 * @return
	 */
	@RequestMapping(value = "/examination/question",method = RequestMethod.POST)
	UserOV ExaminationAddQuestion(@RequestBody ExaminationQuestion examinationQuestion);

	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	@RequestMapping(value = "/question",method = RequestMethod.PUT)
	UserOV alterQuestion(@RequestBody Question question);

	/**
	 * 修改试卷
	 * @param examination
	 * @return
	 */
	@RequestMapping(value = "examination",method = RequestMethod.PUT)
	UserOV alterExamination(@RequestBody Examination examination);

	/**
	 * 删除题目
	 * @param question
	 * @return
	 */
	@RequestMapping(value = "/question",method = RequestMethod.DELETE)
	UserOV deleteQuestion(@RequestBody Question question);

	/**
	 * 删除试卷
	 * @param examination
	 * @return
	 */
	@RequestMapping(value = "/examination",method = RequestMethod.DELETE)
	UserOV deleteExamination(@RequestBody Examination examination);

	/**
	 * 给一张试卷删除试题
	 * @param examinationQuestion
	 * @return
	 */
	@RequestMapping(value = "/examination/question",method = RequestMethod.DELETE)
	UserOV examinationDeleteQuestion(@RequestBody ExaminationQuestion examinationQuestion);

}
