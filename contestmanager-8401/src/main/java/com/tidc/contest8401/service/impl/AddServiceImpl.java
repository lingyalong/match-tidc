package com.tidc.contest8401.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.mapper.PowerMapeer;
import com.tidc.contest8401.service.AddService;
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
	@Override
	public UserOV addPower(Power power) {
		UserOV userOV = new UserOV();
		//这里可以发一条消息说他获得了某某比赛的评分权限

		powerMapeer.insetPower(power);
		userOV.setStatus(CodeConstant.UPDATE);
		return userOV;
	}
}
