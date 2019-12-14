package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.ContestApply;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import com.tidc.api.pojo.exam.Record;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;

/**
 * @ClassNmae FoundService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FoundService {
	UserOV<Integer> foundService(Contest contest,String school_email) throws ParseException;
	UserOV work(Work work,String email);

	/**
	 * 报名线上比赛
	 * @param contestApply
	 * @return
	 */
	UserOV apply(ContestApply contestApply);

	/**
	 * 交卷 传个match_id 和 答案  学生id
	 * @param record
	 * @return
	 */
	UserOV record(Record record) throws ParseException;
}
