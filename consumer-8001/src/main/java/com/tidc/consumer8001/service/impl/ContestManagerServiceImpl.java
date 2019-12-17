package com.tidc.consumer8001.service.impl;

import com.tidc.api.controller.AuthenticationApi;
import com.tidc.api.controller.ContestManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.api.pojo.exam.Record;
import com.tidc.consumer8001.service.AuthenticationService;
import com.tidc.consumer8001.service.ContestManagerService;
import com.tidc.consumer8001.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae ContestManagerServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class ContestManagerServiceImpl implements ContestManagerService {
	@Autowired
	private ContestManagerApi contestManagerApi;
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private AuthenticationApi authenticationApi;
	@Override
	public UserOV<Integer> foundContest(Contest contest, HttpServletRequest req) {
		String school_email = userInfo.getUserName(req);
		return contestManagerApi.foundContest(contest,school_email);
	}

	@Override
	public UserOV addPower(Power power, HttpServletRequest req) {
		String teacher_email = userInfo.getUserName(req);
		return contestManagerApi.addPower(power,teacher_email);
	}

	@Override
	public UserOV addType(String name) {
		return contestManagerApi.addType(name);
	}

	@Override
	public UserOV<List<Contest>> getContestAll() {
		return contestManagerApi.getContestAll();
	}

	@Override
	public UserOV<Contest> getContestDetails(int id) {
		return contestManagerApi.getContestDetails(id);
	}

	@Override
	public UserOV<HistoryExamination> getContestExamination(int id) {
		return contestManagerApi.getContestExamination(id);
	}


	@Override
	public UserOV work(Work work,HttpServletRequest req) {
		String email = userInfo.getUserName(req);
		return contestManagerApi.work(work,email);
	}

	@Override
	public UserOV apply(ContestApply contestApply, HttpServletRequest req) {
		Student student = (Student) userInfo.userInfo(req, 1);
		contestApply.setStudent_id(student.getId()).setStudent_name(student.getName());
		return contestManagerApi.apply(contestApply);
	}

	@Override
	public UserOV record(Record record,HttpServletRequest req) {
		Student student = (Student) userInfo.userInfo(req, 1);
		record.setStudent_id(student.getId());

		return contestManagerApi.record(record);
	}

	@Override
	public UserOV<List<Contest>> getTypeContest(String type) {
		return contestManagerApi.getTypeContest(type);
	}

	@Override
	public UserOV<Contest> updateContest(Contest contest, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		contest.setSchool_id(school.getId());
		return contestManagerApi.updateContest(contest);
	}

	@Override
	public UserOV addMember(Team team) {
		return contestManagerApi.addMember(team);
	}

	@Override
	public UserOV deleteMember(Team team, HttpServletRequest req) {
		Student student = (Student) userInfo.userInfo(req,1);
		team.setLeaderId(student.getId());
		return contestManagerApi.deleteMember(team);
	}

	@Override
	public UserOV deleteContest(Contest contest, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		contest.setSchool_id(school.getId());
		return contestManagerApi.deleteContest(contest);
	}

	@Override
	public UserOV deleteWork(Work work, HttpServletRequest req) {
		Student student = (Student) userInfo.userInfo(req,1);
		work.setStudent_id(student.getId());
		return contestManagerApi.deleteWork(work);
	}

	@Override
	public UserOV deletePower(Power power, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		power.setUserId(school.getId());
		return contestManagerApi.deletePower(power);
	}

	@Override
	public UserOV addScore(Grade grade, HttpServletRequest req) {
		Teacher teacher = (Teacher) userInfo.userInfo(req,2);
		grade.setTeacher_id(teacher.getId());
		return contestManagerApi.addScore(grade);
	}

	@Override
	public UserOV updateScore(Grade grade, HttpServletRequest req) {
		Teacher teacher = (Teacher) userInfo.userInfo(req,2);
		grade.setTeacher_id(teacher.getId());
		return contestManagerApi.updateScore(grade);
	}

	@Override
	public UserOV<List<Contest>> checkShowScoreContest() {
		return contestManagerApi.checkShowScoreContest();
	}

	@Override
	public UserOV<Work> checkWorkScore(int id) {
		return contestManagerApi.checkContestWorkScore(id);
	}

	@Override
	public UserOV updateContestIsShow(Contest contest, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		contest.setSchool_id(school.getId());
		return contestManagerApi.updateContestIsShow(contest);
	}

	@Override
	public UserOV updateWork(Work work, HttpServletRequest req) {
		Student student = (Student) userInfo.userInfo(req,1);
		work.setStudent_id(student.getId());
		return contestManagerApi.updateWork(work);
	}

	@Override
	public UserOV updateContestIsOpen(Contest contest, HttpServletRequest req) {
		School school = (School) userInfo.userInfo(req,3);
		contest.setSchool_id(school.getId());
		return contestManagerApi.updateContestIsOpen(contest);
	}

	@Override
	public UserOV<List<Contest>> listTeacherContest(HttpServletRequest req) {
		Teacher teacher = (Teacher) userInfo.userInfo(req,2);
		return contestManagerApi.listTeacherContest(teacher.getId());
	}

	@Override
	public UserOV<List<Work>> listTeacherContestWork(int id, HttpServletRequest req) {
		Teacher teacher = (Teacher) userInfo.userInfo(req,2);
		return contestManagerApi.listTeacherContestWork(id,teacher.getId());
	}

	@Override
	public UserOV<List<ContestApply>> listContestApply(int id) {
		return contestManagerApi.listContestApply(id);
	}


}
