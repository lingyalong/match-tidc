package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.PowerMapeer;
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
	@Override
	public UserOV addPower(Power power,String email) {
		UserOV userOV = new UserOV();
		//这里可以发一条消息说他获得了某某比赛的评分权限
		Message message = new Message();
		message.setHead("你获得了一个比赛的评分权限");
		message.setIs_read(0);
		message.setReceiver_email(email);
		message.setMessage("详情查看个人页面");
		rabbitManagerApi.sendMessage(message);
		powerMapeer.insetPower(power);
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}
}
