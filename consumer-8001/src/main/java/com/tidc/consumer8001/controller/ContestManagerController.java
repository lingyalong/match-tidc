package com.tidc.consumer8001.controller;

import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Record;
import com.tidc.consumer8001.service.ContestManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;
import java.text.ParseException;
import java.util.List;

/**
 * @ClassNmae ContestController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class ContestManagerController {
	@Autowired
	private ContestManagerService contestManagerService;
	/**
	 * 创建一个比赛
	 * @param contest
	 * @return
	 */
	@PostMapping("/contest")
	public UserOV<Integer> foundContest(@RequestBody Contest contest, HttpServletRequest req){
		return contestManagerService.foundContest(contest,req);
	}

	/**
	 * 为一个比赛增加评委
	 * @param power
	 * @return
	 */
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power, HttpServletRequest req){
		return contestManagerService.addPower(power,req);
	}

	/**
	 * 增加一个比赛类型
	 * @param name
	 * @return
	 */
	@PostMapping("/type" )
	public UserOV addType(@RequestParam("name") String name){
		return contestManagerService.addType(name);
	}

	/**
	 * 使用id查看比赛的详细信息
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/details/{id}")
	public UserOV<Contest> getContestDetails(@PathVariable("id") int id){
		return contestManagerService.getContestDetails(id);
	}

	/**
	 * 获取某个比赛的试卷内容 ,只有开赛之后才能查看   准备测试
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/history/{id}")
	public UserOV<HistoryExamination> getContestExamination(@PathVariable("id") int id){
		return contestManagerService.getContestExamination(id);
	}

	/**
	 * 查看所有比赛的详细信息
	 * @return
	 */
	@GetMapping("/contest")
	public UserOV<List<Contest>> getContestAll() {
		return contestManagerService.getContestAll();
	}

	/**
	 * 学生报名比赛
	 * 需要字段
	 * name(项目名字)
	 * logo(封面地址)
	 * url(文件地址)
	 * contest_id(比赛id)
	 * is_money(是否缴费)
	 * brief(简介最好是富文本)
	 * @param work
	 * @return
	 */
	@PostMapping("/work")
	public UserOV work(@RequestBody Work work,HttpServletRequest req){
		return contestManagerService.work(work, req);
	}

	/**
	 * 报名线上比赛
	 * @param contestApply
	 * @return
	 */
	@PostMapping("/apply")
	public UserOV apply(@RequestBody ContestApply contestApply,HttpServletRequest req){
		return contestManagerService.apply(contestApply,req);
	}

	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	@PostMapping("/record")
	public UserOV record(@RequestBody Record record, HttpServletRequest req){
		return contestManagerService.record(record,req);
	}

	/**
	 * 根据类型查看比赛列表
	 * @param type
	 * @return
	 */
	@GetMapping("/type/contest")
	public UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type){
		return contestManagerService.getTypeContest(type);
	}

	/**
	 * 修改比赛
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest")
	public UserOV<Contest> updateContest(@RequestBody Contest contest, HttpServletRequest req){
		return contestManagerService.updateContest(contest,req);
	}

	/**
	 * 增加队员
	 * @param team
	 * @return
	 */
	@PostMapping("/member")
	public UserOV addMember(@RequestBody Team team){
		return contestManagerService.addMember(team);
	}

	/**
	 * 删除队员
	 * @param team
	 * @return
	 */
	@DeleteMapping("/member")
	public UserOV deleteMember(@RequestBody Team team, HttpServletRequest req){
		return  contestManagerService.deleteMember(team,req);
	}

	/**
	 * 删除比赛
	 * @param contest id token
	 * @return
	 */
	@DeleteMapping("/contest")
	public UserOV deleteContest(@RequestBody Contest contest, HttpServletRequest req){
		return contestManagerService.deleteContest(contest,req);
	}

	/**
	 * 删除项目
	 * @param work id token
	 * @return
	 */
	@DeleteMapping("/work")
	public UserOV deleteWork(@RequestBody Work work, HttpServletRequest req){
		return contestManagerService.deleteWork(work,req);
	}

	/**
	 * 删除评委
	 * @param power id token
	 * @return
	 */
	@DeleteMapping("/power")
	public UserOV deletePower(@RequestBody Power power, HttpServletRequest req){
		return contestManagerService.deletePower(power,req);
	}

	/**
	 * 评分
	 * @param grade
	 * @return
	 */
	@PostMapping("/score")
	public UserOV addScore(@RequestBody Grade grade, HttpServletRequest req){
		return contestManagerService.addScore(grade,req);
	}

	/**
	 * 修改评分
	 * @param grade
	 * @return
	 */
	@PutMapping("/score")
	public UserOV updateScore(@RequestBody Grade grade, HttpServletRequest req){
		return contestManagerService.updateScore(grade,req);
	}

	/**
	 * 查看公开了排行榜的比赛列表
	 * @return
	 */
	@GetMapping("/contest/score")
	public UserOV<List<Contest>> checkShowScoreContest(){
		return contestManagerService.checkShowScoreContest();
	}

	/**
	 * 根据id查看某个比赛的项目分数列表
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/score/{id}")
	public UserOV<Work> checkWorkScore(@PathVariable("id")int id){
		return contestManagerService.checkWorkScore(id);
	}

	/**
	 * 修改比赛排行榜是否公开
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest/show")
	public UserOV updateContestIsShow(@RequestBody Contest contest, HttpServletRequest req){
		return contestManagerService.updateContestIsShow(contest,req);
	}

	/**
	 * 修改项目
	 * @param work
	 * @return
	 */
	@PutMapping("/work")
	public UserOV updateWork(@RequestBody Work work, HttpServletRequest req){
		return contestManagerService.updateWork(work,req);
	}

	/**
	 * 比赛修改是否开放报名
	 * @param contest
	 * @return
	 */
	@PutMapping("/contest/open")
	public UserOV updateContestIsOpen(@RequestBody Contest contest,HttpServletRequest req){
		return contestManagerService.updateContestIsOpen(contest,req);
	}

	/**
	 * 获取当前老师拥有权限的比赛列表
	 * @param req
	 * @return
	 */
	@GetMapping("/teacher/contest")
	public UserOV<List<Contest>> listTeacherContest(HttpServletRequest req){
		return contestManagerService.listTeacherContest(req);
	}

	/**
	 * 获取根据比赛id获取比赛的项目列表
	 * @param id
	 * @return
	 */
	@GetMapping("/teacher/contest/work/{id}")
	public UserOV<List<Work>> listTeacherContestWork(@PathVariable("id") int id,HttpServletRequest req){
		return contestManagerService.listTeacherContestWork(id,req);
	}

	/**
	 * 根据比赛id查看该比赛的线上考试排行
	 * @param id
	 * @return
	 */
	@GetMapping("/contest/apply/{id}")
	public UserOV<List<ContestApply>> listContestApply(@PathVariable("id") int id){
		return contestManagerService.listContestApply(id);
	}


}
