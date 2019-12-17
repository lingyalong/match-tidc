package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.fallback.MessageManagerFallbackFactory;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Record;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @ClassNmae ContestManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "CONTESTMANAGER",fallbackFactory = ContestManagerFallbackFactory.class)
public interface ContestManagerApi {

	@RequestMapping(value = "/contest",method = RequestMethod.POST)
	UserOV<Integer> foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email);

	@RequestMapping(value = "/power",method = RequestMethod.POST)
	UserOV addPower(@RequestBody Power power,@RequestParam("email") String email);

	@RequestMapping(value = "/type",method = RequestMethod.POST)
	UserOV addType(@RequestParam("name") String name);

	@RequestMapping(value = "/contest",method = RequestMethod.GET)
	UserOV<List<Contest>> getContestAll();

	@RequestMapping(value = "/contest/details/{id}",method = RequestMethod.GET)
	UserOV<Contest> getContestDetails(@PathVariable("id") int id);

	/**
	 * 获取某个比赛的试卷内容 ,只有开赛之后才能查看   准备测试
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/contest/history/{id}",method = RequestMethod.GET )
	UserOV<HistoryExamination> getContestExamination(@PathVariable("id") int id);

	/**
	 * 根据比赛id查看该比赛的线上考试排行
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/contest/apply/{id}",method = RequestMethod.GET)
	UserOV<List<ContestApply>> listContestApply(@PathVariable("id") int id);

	@RequestMapping(value = "/work",method = RequestMethod.POST)
	UserOV work(@RequestBody Work work,@RequestParam("email") String email);

	/**
	 * 报名线上比赛
	 * @param contestApply
	 * @return
	 */
	@RequestMapping(value = "/apply",method = RequestMethod.POST)
	UserOV apply(@RequestBody ContestApply contestApply);

	@RequestMapping(value = "/type/contest",method = RequestMethod.GET)
	UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type);

	@RequestMapping(value = "/contest",method = RequestMethod.PUT)
	UserOV<Contest> updateContest(@RequestBody Contest contest);

	@RequestMapping(value = "/member",method = RequestMethod.POST)
	UserOV addMember(@RequestBody Team team);

	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/record",method = RequestMethod.POST)
	UserOV record(Record record);

	@RequestMapping(value = "/member",method = RequestMethod.DELETE)
	UserOV deleteMember(@RequestBody Team team);

	@RequestMapping(value = "/contest",method = RequestMethod.DELETE)
	UserOV deleteContest(@RequestBody Contest contest);

	@RequestMapping(value = "/work",method = RequestMethod.DELETE)
	UserOV deleteWork(@RequestBody Work work);

	@RequestMapping(value = "/contest/work/team",method = RequestMethod.DELETE)
	UserOV deleteWorkAndTeam(@RequestParam("contest_id") int contest_id);

	@RequestMapping(value = "/power",method = RequestMethod.DELETE)
	UserOV deletePower(@RequestBody Power power);

	@RequestMapping(value = "/score",method = RequestMethod.POST)
	UserOV addScore(@RequestBody Grade grade);

	@RequestMapping(value = "/score",method = RequestMethod.PUT)
	UserOV updateScore(@RequestBody Grade grade);

	@RequestMapping(value = "/contest/score",method = RequestMethod.GET)
	UserOV<List<Contest>> checkShowScoreContest();

	@RequestMapping(value = "/contest/score/{id}",method = RequestMethod.GET)
	UserOV<Work> checkContestWorkScore(@PathVariable("id")int id);

	/**
	 * 修改比赛排行榜是否公开
	 * @param contest
	 * @return
	 */
	@RequestMapping(value = "/contest/show",method = RequestMethod.PUT)
	UserOV updateContestIsShow(@RequestBody Contest contest);

	/**
	 * 修改项目
	 * @param work
	 * @return
	 */
	@RequestMapping(value = "/work",method = RequestMethod.PUT)
	UserOV updateWork(@RequestBody Work work);

	/**
	 * 比赛修改是否开放报名
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest/open")
	UserOV updateContestIsOpen(@RequestBody Contest contest);

	/**
	 * 获取当前老师拥有权限的比赛列表
	 * @param teacherId
	 * @return
	 */
	@GetMapping("/teacher/contest")
	UserOV<List<Contest>> listTeacherContest(@RequestParam("teacherId") int teacherId);


	/**
	 * 获取根据id获取当前老师的比赛的项目列表
	 * @param id
	 * @return
	 */
	@GetMapping("/teacher/contest/work/{id}")
	UserOV<List<Work>> listTeacherContestWork(@PathVariable("id") int id,@RequestParam("teacherId") int teacherId);

	/**
	 * 修改某个比赛的历史试卷id
	 * @param historyExamination
	 * @return
	 */
	@RequestMapping(value = "/contest/history/examination",method = RequestMethod.PUT)
	UserOV updateContestHistoryExamination(@RequestBody HistoryExamination historyExamination);

}
