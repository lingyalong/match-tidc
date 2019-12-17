package com.tidc.contest8401.utils;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.exam.Record;
import com.tidc.contest8401.mapper.ContestApplyMapper;
import com.tidc.contest8401.mapper.ContestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae CheckUtils
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class CheckUtils {
	@Autowired
	private ContestMapper contestMapper;
	@Autowired
	private ContestApplyMapper contestApplyMapper;
	//查重
	public boolean checkContest(Contest contest){
		Integer contestLeader = contestMapper.checkLeader(contest.getId());
		if(contestLeader.equals(contest.getSchool_id())){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 查看比赛是否开启报名
	 * @param contestId
	 * @return
	 */
	public boolean checkWorkApplyOpen(int contestId){
		return contestMapper.checkApply(contestId)!=null;
	}

	/**
	 * 查看学生是否有报名某个线上比赛
	 * @return
	 */
	public boolean checkApply(Record record){
		return contestApplyMapper.checkApply(record)!=null;
	}
	public boolean checkPublic(int id){
		Contest contest = contestMapper.getContest(id);
		return contest.getIs_show()==1;
	}
}
