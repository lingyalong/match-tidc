package com.tidc.contest8401.service;

import com.tidc.api.pojo.ContestType;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae AddService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface AddService {
	UserOV addPower(Power power,String email);
	UserOV addType(String name);
}
