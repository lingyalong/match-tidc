package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;

/**
 * @ClassNmae UserManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UserManagerService {
	UserOV teacherRegister(Teacher teacher,String code);
}
