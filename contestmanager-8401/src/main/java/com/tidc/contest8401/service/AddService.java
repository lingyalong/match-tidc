package com.tidc.contest8401.service;

import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae AddService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface AddService {
	UserOV addPower(Power power,String email);
}
