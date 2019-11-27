package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.exception.RepetitionException;
import com.tidc.api.pojo.*;
import com.tidc.contest8401.mapper.ContestTypeMapper;
import com.tidc.contest8401.mapper.PowerMapeer;
import com.tidc.contest8401.mapper.TeamMapper;
import com.tidc.contest8401.service.AddService;
import com.tidc.utils.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae AddServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class AddServiceImpl implements AddService {
	@Autowired
	private PowerMapeer powerMapeer;
	@Autowired
	private RabbitManagerApi rabbitManagerApi;
	@Autowired
	private ContestTypeMapper contestTypeMapper;
	@Autowired
	private TeamMapper teamMapper;
	@Override
	public UserOV addPower(Power power,String email) throws RepetitionException {
		Integer repetition = powerMapeer.checkRepetition(power);
		if(repetition!=null){
			throw new RepetitionException(429,"无法重复添加同一个评委");
		}
		UserOV userOV = new UserOV();
		//这里可以发一条消息说他获得了某某比赛的评分权限
		Message message = new Message();
		message.setHead("你获得了一个比赛的评分权限");
		message.setIs_read(0);
		message.setReceiver_email(email);
		message.setMessage("详情查看个人页面");
		powerMapeer.insetPower(power);
		rabbitManagerApi.sendMessage(message);
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}

	@Override
	public UserOV addType(String name) throws RepetitionException {
		Integer repetition = contestTypeMapper.checkRepetition(name);
		if(repetition!=null){
			throw new RepetitionException(429,"已有这个类型");
		}
		contestTypeMapper.insertContestType(name);
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}

	@Override
	public UserOV addMember(Team team) throws RepetitionException {
		Integer repetition = teamMapper.CheckRepetition(team);
		if(repetition!=null){
			//重复了
			throw new RepetitionException(429,"重复添加队员操作"+team);
		}
		teamMapper.insertMember(team);
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.SUCCESS);
		return userOV;
	}
}
