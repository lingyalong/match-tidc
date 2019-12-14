package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.contest8401.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNmae UpdateController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class UpdateController {
	@Autowired
	private UpdateService updateService;

	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest")
	public UserOV<Contest> updateContest(@RequestBody Contest contest){
		return updateService.updateContest(contest);
	}


	/**
	 * 修改比赛排行榜是否公开
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest/show")
	public UserOV updateContestIsShow(@RequestBody Contest contest){
		return updateService.updateContestIsShow(contest);
	}

	/**
	 * 修改项目
	 * @param work
	 * @return
	 */
	@PutMapping("/work")
	public UserOV updateWork(@RequestBody Work work){
		return updateService.updateWork(work);
	}

	/**
	 * 比赛修改是否开放报名
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest/open")
	public UserOV updateContestIsOpen(@RequestBody Contest contest){
		return  updateService.updateContestIsOpen(contest);
	}

	/**
	 * 修改某个比赛的历史试卷id
	 * @param historyExamination
	 * @return
	 */
	@PutMapping("/contest/history/examination")
	public UserOV updateContestHistoryExamination(@RequestBody HistoryExamination historyExamination){
		return updateService.updateContestHistoryExamination(historyExamination);
	}
}
