package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.ContestApply;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.contest8401.service.CheckService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @ClassNmae CheckController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class CheckController {
	@Autowired
	private CheckService checkService;

	/**
	 * 查看所有比赛的基本信息
	 * @return
	 */
	@GetMapping("/contest")
	public UserOV<List<Contest>> getContestAll(){
		return checkService.getContestAll();
	}

	/**
	 * 根据比赛类型获取该类型的比赛
	 * @param type
	 * @return
	 */
	@GetMapping("/type/contest")
	public UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type){
		return checkService.getTypeContest(type);
	}

	/**
	 * 根据比赛id获取比赛详细信息
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/details/{id}")
	public UserOV<Contest> getContestDetails(@PathVariable("id") int id){
		return checkService.getContestDetails(id);
	}

	/**
	 * 查询最新的指定条数的比赛
	 * @param number
	 * @return
	 */
	@GetMapping("/rank/contest/{number}")
	public UserOV<List<Contest>> listRankContest(@PathVariable("number") int number){
		return checkService.listRankContest(number);
	}

	/**
	 * 获取所有的类型标签
	 * @return
	 */
	@GetMapping("/type")
	public UserOV<List<String>> listType(){
		return checkService.listType();
	}

	/**
	 * 展示所有对外公开的比赛排行
	 * @return
	 */
	@GetMapping("/contest/score")
	public UserOV<List<Contest>> checkShowScoreContest(){
		return checkService.checkShowScoreContest();
	}

	/**
	 * 根据id查看某个比赛的项目分数列表 供分数展览模块使用
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/score/{id}")
	public UserOV<List<Work>> checkContestWorkScore(@PathVariable("id")int id){
		return checkService.checkContestWorkScore(id);
	}

	/**
	 * 获取当前老师拥有权限的比赛列表
	 * @param teacherId
	 * @return
	 */
	@GetMapping("/teacher/contest")
	public UserOV<List<Contest>> listTeacherContest(@RequestParam("teacherId") int teacherId){
		return checkService.listTeacherContest(teacherId);
	}

	/**
	 * 获取根据id获取当前老师的比赛的项目列表
	 * @param id
	 * @return
	 */
	@GetMapping("/teacher/contest/work/{id}")
	public UserOV<List<Work>> listTeacherContestWork(@PathVariable("id") int id,@RequestParam("teacherId") int teacherId){
		return checkService.listTeacherContestWork(id,teacherId);
	}

	/**
	 * 根据比赛id查看该比赛的线上考试排行
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/apply/{id}")
	public UserOV<List<ContestApply>> listContestApply(@PathVariable("id") int id){
		return checkService.listContestApply(id);
	}

	/**
	 * 获取某个比赛的试卷内容 ,只有开赛之后才能查看   准备测试
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/history/{id}")
	public UserOV<HistoryExamination> getContestExamination(@PathVariable("id") int id) throws ParseException {
		return checkService.getContestExamination(id);
	}


}
