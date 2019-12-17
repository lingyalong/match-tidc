package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.ContestApply;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.HistoryExamination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

/**
 * @ClassNmae CheckService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckService {
	/**
	 * 获取所有比赛的基本信息
	 * @return
	 */
	UserOV<List<Contest>> getContestAll();

	/**
	 * 按照类型获取比赛的基本信息
	 * @param type
	 * @return
	 */
	UserOV<List<Contest>> getTypeContest(String type);

	/**
	 * 根据比赛id来获取比赛详细信息
	 * @param id
	 * @return
	 */
	UserOV<Contest> getContestDetails( int id);

	/**
	 * 获取最新的指定条数的比赛的基本信息
	 * @param number
	 * @return
	 */
	UserOV<List<Contest>> listRankContest(int number);

	/**
	 * 获取所有的比赛类型
	 * @return
	 */
	UserOV<List<String>> listType();

	/**
	 * 展示对外公开的比赛排行
	 * @return
	 */
	UserOV<List<Contest>> checkShowScoreContest();

	/**
	 * 根据id查看某个比赛的项目分数列表
	 * @param id
	 * @return
	 */
	UserOV<List<Work>> checkContestWorkScore(int id);

	/**
	 * 获取当前老师拥有权限的列表
	 * @param teacherId
	 * @return
	 */
	UserOV<List<Contest>> listTeacherContest(int teacherId);

	/**
	 * 获取根据id获取当前老师的比赛的项目列表
	 * @param id
	 * @return
	 */
	UserOV<List<Work>> listTeacherContestWork(int id,int teacherId);

	/**
	 * 根据比赛id查看该比赛的线上考试排行
	 * @param id
	 * @return
	 */
	UserOV<List<ContestApply>> listContestApply(int id);

	/**
	 * 获取某个比赛的试卷内容 ,只有开赛之后才能查看
	 * @param id
	 * @return
	 */
	UserOV<HistoryExamination> getContestExamination(int id) throws ParseException;
}

