package com.tidc.contest8401.service;

import com.tidc.api.pojo.Team;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae DeleteService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface DeleteService {
	UserOV deleteMember(Team team);
}
