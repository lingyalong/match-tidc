package com.tidc.contest8401.utils;

import com.tidc.api.pojo.Contest;
import com.tidc.contest8401.mapper.ContestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
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
	public static boolean is_open(String start,String format) throws ParseException {
		//当前时间
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date parse = formatter.parse(start);
//		boolean after(Date date)
//		若当调用此方法的Date对象在指定日期之钱返回true,否则返回false。
		System.out.println(parse.compareTo(time));
		return !time.after(parse);
	}

	/**
	 * 计算交卷时间
	 * @param startTime 比赛开始时间
	 * @param time 分钟数
	 * @return
	 */
	public static boolean calculatePaperTime(String startTime,int time) throws ParseException {
//		现在
		LocalDateTime now = LocalDateTime.now();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date parse = formatter.parse(startTime);
//		开始的时间
		LocalDateTime start = LocalDateTime.ofInstant(parse.toInstant(), ZoneId.systemDefault());
//		结束时间
		LocalDateTime finish = start.plusMinutes((long) time);
		return now.isAfter(start) && now.isBefore(finish);
	}
	//	秒 分 时 日 月 周几
	@Scheduled(cron = "0 0 3 * * *")
	public void check() throws ParseException {
		//当前时间
		Date time = new Date();
		List<Contest> contests = contestMapper.listContestTime();
		for (Contest contest : contests) {
			if(is_open(contest.getStart(),"yyyy-MM-dd")){
				//这里是某个比赛的报名时间到了
				contestMapper.upOpen(contest.getId());
			}
			//判断已经开始报名的比赛是否到了报名结束时间
			if(contest.getIs_open()==1){
				if(is_open(contest.getFinish(),"yyyy-MM-dd")){
					//过期了
					contestMapper.downOpen(contest.getId());
				}
			}
		}
	}

}
