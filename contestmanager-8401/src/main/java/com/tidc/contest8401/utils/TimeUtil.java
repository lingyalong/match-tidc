package com.tidc.contest8401.utils;

import com.tidc.api.pojo.Contest;
import com.tidc.contest8401.mapper.ContestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassNmae TimeUtil
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class TimeUtil {
	@Autowired
	private ContestMapper contestMapper;
	/**
	 * 判断当前时间是否超过了输入的时间如果是则为真
	 * @param start
	 * @return
	 * @throws ParseException
	 */
	public static boolean is_open(String start) throws ParseException {
		//当前时间
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date parse = formatter.parse(start);
//		如果指定的数与参数相等返回0。
//		如果指定的数小于参数返回 -1。
//		如果指定的数大于参数返回 1。
		if(time.compareTo(parse)==1){
			//当前时间超过了输入的时间
			return true;
		}else{
			return false;
		}
	}
	//	秒 分 时 日 月 周几
	@Scheduled(cron = "0 0 3 * * *")
	public void check() throws ParseException {
		//当前时间
		Date time = new Date();
		List<Contest> contests = contestMapper.listContestTime();
		for (Contest contest : contests) {
			if(is_open(contest.getStart())){
				//这里是某个比赛的报名时间到了
				contestMapper.upOpen(contest.getId());
			}
			//判断已经开始报名的比赛是否到了报名结束时间
			if(contest.getIs_open()==1){
				if(is_open(contest.getFinish())){
					//过期了
					contestMapper.downOpen(contest.getId());
				}
			}
		}
	}

}
