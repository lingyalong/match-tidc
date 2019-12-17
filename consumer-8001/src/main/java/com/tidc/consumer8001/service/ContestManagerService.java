package com.tidc.consumer8001.service;

import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Record;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae ContestManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ContestManagerService {
	/**
	 *创建一个比赛
	 * @param contest
	 * @return
	 */
	UserOV<Integer> foundContest(Contest contest, HttpServletRequest req);

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @return
	 */
	UserOV addPower(Power power, HttpServletRequest req);

	/**
	 * 增加一个比赛类型
	 * @param name
	 * @return
	 */
	UserOV addType( String name);

	/**
	 * 获取所有比赛的展示信息
	 * @return
	 */
	 UserOV<List<Contest>> getContestAll();

	/**
	 * 使用比赛id查看比赛的详细信息
	 * @param id
	 * @return
	 */
	UserOV<Contest> getContestDetails( int id);

	/**
	 * 获取某个比赛的试卷内容 ,只有开赛之后才能查看   准备测试
	 * @param id
	 * @return
	 */
	UserOV<HistoryExamination> getContestExamination(int id);

	/**
	 * 学生报名比赛
	 * @param work
	 * @return
	 */
	 UserOV work( Work work, HttpServletRequest req);

	/**
	 * 报名线上比赛
	 * @param contestApply
	 * @return
	 */
	UserOV apply(ContestApply contestApply,HttpServletRequest req);


	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	UserOV record(Record record,HttpServletRequest req);
	/**
	 * 根据类型查看比赛列表
	 * @param type
	 * @return
	 */
	UserOV<List<Contest>> getTypeContest(String type);

	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	UserOV<Contest> updateContest(Contest contest, HttpServletRequest req);

	/**
	 * 添加队员
	 * @param team
	 * @return
	 */
	UserOV addMember(Team team);

	/**
	 * 删除队员
	 * @param team
	 * @return
	 */
	UserOV deleteMember(Team team, HttpServletRequest req);

	/**
	 * 删除比赛
	 * @param contest
	 * @return
	 */
	UserOV deleteContest(Contest contest, HttpServletRequest req);

	/**
	 * 删除项目
	 * @param work
	 * @return
	 */
	UserOV deleteWork(Work work, HttpServletRequest req);

	/**
	 * 删除评委
	 * @param power token
	 * @return
	 */
	UserOV deletePower(Power power, HttpServletRequest req);

	/**
	 * 评分
	 * @param grade
	 * @return
	 */
	UserOV addScore(Grade grade, HttpServletRequest req);

	/**
	 * 修改评分
	 * @param grade
	 * @return
	 */
	UserOV updateScore(Grade grade, HttpServletRequest req);

	/**
	 * 查看公开了排行榜的比赛列表
	 * @return
	 */
	UserOV<List<Contest>> checkShowScoreContest();

	/**
	 * 根据id查看某个比赛的项目分数列表
	 * @param id
	 * @return
	 */
	UserOV<Work> checkWorkScore(int id);

	/**
	 * 修改比赛排行榜是否公开
	 * @param contest
	 * @return
	 */
	UserOV updateContestIsShow(Contest contest, HttpServletRequest req);

	/**
	 * 修改项目
	 * @param work
	 * @return
	 */
	UserOV updateWork(Work work, HttpServletRequest req);

	/**
	 * 比赛修改是否开放报名
	 * @param contest
	 * @return
	 */
	UserOV updateContestIsOpen(Contest contest,HttpServletRequest req);

	/**
	 * 获取当前老师拥有权限的比赛列表
	 * @param req
	 * @return
	 */
	UserOV<List<Contest>> listTeacherContest(HttpServletRequest req);


	/**
	 * 获取根据id获取当前老师的比赛的项目列表
	 * @param id
	 * @return
	 */
	 UserOV<List<Work>> listTeacherContestWork(int id,HttpServletRequest req);

	/**
	 * 根据比赛id查看该比赛的线上考试排行
	 * @param id
	 * @return
	 */
	UserOV<List<ContestApply>> listContestApply(int id);
}
