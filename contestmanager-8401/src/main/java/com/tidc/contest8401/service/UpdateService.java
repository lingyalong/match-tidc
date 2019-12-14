package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.HistoryExamination;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNmae UpdateService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UpdateService {
	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	UserOV<Contest> updateContest(Contest contest);

	/**
	 * 是否发布比赛排行榜
	 * @param contest
	 * @return
	 */
	UserOV updateContestIsShow(Contest contest);

	/**
	 * 修改项目
	 * @param work
	 * @return
	 */
	UserOV updateWork(Work work);

	/**
	 * 比赛修改是否开放报名
	 * @param contest
	 * @return
	 */
	UserOV updateContestIsOpen(Contest contest);


	/**
	 * 修改某个比赛的历史试卷id
	 * @param historyExamination
	 * @return
	 */
	UserOV updateContestHistoryExamination(HistoryExamination historyExamination);

}