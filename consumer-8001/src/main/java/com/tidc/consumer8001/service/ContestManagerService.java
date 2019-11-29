package com.tidc.consumer8001.service;

import com.tidc.api.pojo.*;
import org.springframework.web.bind.annotation.*;

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
	UserOV<Integer> foundContest(Contest contest);

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @return
	 */
	UserOV addPower(Power power);

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
	 * 学生报名比赛
	 * @param work
	 * @return
	 */
	 UserOV apply( Work work);

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
	UserOV<Contest> updateContest( Contest contest);

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
	UserOV deleteMember(Team team);

	/**
	 * 删除比赛
	 * @param contest
	 * @return
	 */
	UserOV deleteContest(Contest contest);

	/**
	 * 删除项目
	 * @param work
	 * @return
	 */
	UserOV deleteWork(Work work);

	/**
	 * 删除评委
	 * @param power token
	 * @return
	 */
	UserOV deletePower(Power power);

	/**
	 * 评分
	 * @param grade
	 * @return
	 */
	UserOV addScore(Grade grade);

	/**
	 * 修改评分
	 * @param grade
	 * @return
	 */
	UserOV updateScore(Grade grade);



}
