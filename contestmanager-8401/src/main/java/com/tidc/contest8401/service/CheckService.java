package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.PathVariable;

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
}

