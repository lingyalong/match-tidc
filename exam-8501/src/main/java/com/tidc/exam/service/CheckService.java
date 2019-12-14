package com.tidc.exam.service;

import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Question;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassNmae CheckService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckService {
	/**
	 * 根据id查看学校的试卷集合
	 * @param schoolId
	 * @return
	 */
	UserOV<List<Examination>> listExamination(int schoolId);

	/**
	 * 根据学校id查看学校的题目集合
	 * @param schoolId
	 * @return
	 */
	UserOV<List<Question>> listQuestion(int schoolId);

	/**
	 * 根据试卷id查看试卷的详情包括题目集
	 * @param id
	 * @return
	 */
	UserOV<Examination> getExaminationInQuestion(int id);

	/**
	 * 根据id获取历史试卷
	 * @param id
	 * @return
	 */
	UserOV<HistoryExamination> getHistoryExamination(int id);
}
