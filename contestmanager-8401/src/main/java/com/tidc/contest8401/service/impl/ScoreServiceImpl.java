package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Grade;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.GradeMapper;
import com.tidc.contest8401.mapper.PowerMapeer;
import com.tidc.contest8401.mapper.WorkMapper;
import com.tidc.contest8401.service.ScoreService;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassNmae ScoreServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private PowerMapeer powerMapeer;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	public UserOV addScore(Grade grade) {
		UserOV userOV = checkAuthenticationAndNull(grade);
		if(userOV.getStatus().equals(CodeConstant.SUCCESS)){
			BigDecimal  oldScore = gradeMapper.getOldScore(grade);
			if(oldScore==null){
				int gradeCount = gradeMapper.insertGrade(grade);
				if(gradeCount==0){
					userOV.setStatus(CodeConstant.FAIL).setMessage("评分失败");
				}else{
					workMapper.updateScore(grade.getScore());
				}
			}else{
				userOV.setMessage("不要重复评分");
			}

		}
		return userOV;
	}

	@Override
	public UserOV updateScore(Grade grade) {
		UserOV userOV = checkAuthenticationAndNull(grade);
		if(userOV.getStatus().equals(CodeConstant.SUCCESS)){
			BigDecimal  oldScore = gradeMapper.getOldScore(grade);
			int gradeCount = gradeMapper.updateGrade(grade);
			if(gradeCount==0){
				userOV.setStatus(CodeConstant.FAIL).setMessage("修改失败");
			}else{
				BigDecimal  v = grade.getScore().subtract(oldScore);
				workMapper.updateScore(v);
			}
		}
		return userOV;
	}

	public UserOV checkAuthenticationAndNull(Grade grade){
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL);
		Power power = new Power();
		power.setContest_id(grade.getContest_id()).setTeacher_id(grade.getTeacher_id());
		Integer powerCount = powerMapeer.checkRepetition(power);
		if (CheckObjectIsNullUtils.contestObjCheckIsNull(grade)){
			if(powerCount != 0) {
				userOV.setStatus(CodeConstant.SUCCESS);
			}else{
				userOV.setMessage("你没有权限修改这个评分");
			}
		}else{
			userOV.setMessage("有字段未填写");
		}

		return userOV;
	}
}

