package com.tidc.contest8401.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.*;
import com.tidc.contest8401.mapper.ContestMapper;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.FoundService;
import com.tidc.contest8401.utils.TimeUtil;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.scope.Scope;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedHashMap;

/**
 * @ClassNmae foundServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FoundServiceImpl implements FoundService {
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private TeamMapper teamMapper;
	@Override
	public UserOV<Integer> foundService(Contest contest, String school_email) throws ParseException {
		UserOV userOV2 = userManagerApi.userInfo(school_email);
		LinkedHashMap data = (LinkedHashMap) userOV2.getData();
		//这里获取到创建学校的所有信息
		School school = objectMapper.convertValue(data, new TypeReference<School>(){});
		contest.setSchool_id(school.getId());
		contest.setNumber(0);
		contest.setIs_show(0);
		boolean open = TimeUtil.is_open(contest.getStart());
		if(open){
			contest.setIs_open(1);
		}else{
			contest.setIs_open(0);
		}
		UserOV<Integer> userOV = new UserOV<>();
		if (!CheckObjectIsNullUtils.contestObjCheckIsNull(contest)) {
			userOV.setStatus(CodeConstant.FAIL).setMessage("有字段未填写");
		}else{
			int count = contestMapper.insetContest(contest);
			if (count == 1) {
				userOV.setStatus(CodeConstant.SUCCESS).setData(contest.getId());
			} else {
				userOV.setStatus(CodeConstant.FAIL);
			}
		}
		return userOV;
	}

	/**
	 * 报名比赛
	 * @param work
	 * @param email
	 * @return
	 */
	@Override
	public UserOV apply(Work work,String email) {
		UserOV userOV1 = userManagerApi.userInfo(email);
//		Student student = (Student) userOV1.getData();
		Student student = objectMapper.convertValue(userOV1.getData(), new TypeReference<Student>() {});
		work.setStudent_id(student.getId());
		work.setScore(new BigDecimal("0.00"));
		workMapper.insetWork(work);
		//增加一个队长
		Team team = new Team();
		team.setStudent_id(student.getId());
		team.setWork_id(work.getId());
		int count = teamMapper.insertLeader(team);
		//增加比赛number
		int count2 = contestMapper.addNumber(work.getContest_id());
		UserOV userOV = new UserOV();

		if(count==1&&count2==1){
			userOV.setStatus(CodeConstant.SUCCESS);
		}else{
			userOV.setStatus(CodeConstant.FAIL);
		}

		return userOV;
	}

}
