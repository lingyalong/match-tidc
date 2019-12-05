package com.tidc.contest8401.utils;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Contest;
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
	//查重
	public boolean checkContest(Contest contest){
		Integer contestLeader = contestMapper.checkLeader(contest.getId());
		if(contestLeader.equals(contest.getSchool_id())){
			return true;
		}else{
			return false;
		}
	}
}
