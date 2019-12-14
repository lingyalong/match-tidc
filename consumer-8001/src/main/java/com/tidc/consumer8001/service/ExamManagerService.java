package com.tidc.consumer8001.service;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.ExaminationQuestion;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae ExamManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ExamManagerService {
	/**
	 * 根据id查看学校的试卷集合
	 * @return
	 */
	UserOV<List<Examination>> listExamination(HttpServletRequest req);


	/**
	 * 查看当前登录的用户的题目集合
	 * @return
	 */
	UserOV<List<Question>> listQuestion(HttpServletRequest req);

	/**
	 * 根据试卷id查看试卷的详情包括题目集
	 * @param id
	 * @return
	 */
	UserOV<Examination> getExaminationInQuestion(int id);

	/**
	 * 创建一个题目
	 * @param question
	 * @param req
	 * @return
	 */
	UserOV foundQuestion(Question question, HttpServletRequest req);

	/**
	 * 创建一个比赛
	 * @param examination
	 * @return
	 */
	UserOV foundExamination(Examination examination,HttpServletRequest req);

	/**
	 * 给一张试卷增加试题
	 * @param examinationQuestion
	 * @return
	 */
	UserOV ExaminationAddQuestion(ExaminationQuestion examinationQuestion,HttpServletRequest req);

	/**
	 * 创建一个历史试卷 返回试卷id
	 * @param contestId
	 * @param examinationId
	 * @return
	 */
	UserOV<Integer> foundHistoryExamination(int contestId,int examinationId);

	/**
	 * 修改题目
	 * @param question
	 * @return
	 */
	UserOV alterQuestion(Question question,HttpServletRequest req);

	/**
	 * 修改试卷
	 * @param examination
	 * @return
	 */
	UserOV alterExamination(Examination examination,HttpServletRequest req);


	/**
	 * 删除题目
	 * @param question
	 * @return
	 */
	UserOV deleteQuestion(Question question,HttpServletRequest req);

	/**
	 * 删除试卷
	 * @param examination
	 * @return
	 */
	UserOV deleteExamination(Examination examination,HttpServletRequest req);

	/**
	 * 给一张试卷删除试题
	 * @param examinationQuestion
	 * @return
	 */
	UserOV examinationDeleteQuestion(ExaminationQuestion examinationQuestion,HttpServletRequest req);

}
