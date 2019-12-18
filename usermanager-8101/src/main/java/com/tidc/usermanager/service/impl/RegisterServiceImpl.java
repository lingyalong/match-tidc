package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.exception.RegisterException;
import com.tidc.api.pojo.*;
import com.tidc.api.pojo.user.User;
import com.tidc.api.pojo.user.UserRole;
import com.tidc.usermanager.mapper.*;
import com.tidc.usermanager.service.RegisterService;
import com.tidc.usermanager.utiles.ApplicationContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae RegisterServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDetailMapper userDetailMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private MessageManagerApi messageManagerApi;
	@Autowired
	private ApplicationContextProvider ac;
	@Autowired
	private PasswordEncoder passwordEncoder;
	Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	@Override
	public UserOV register(User user) throws RegisterException {
		UserOV userOV = new UserOV();
		User school = null;
		if(!checkRepetition(user.getEmail())){
			throw new RegisterException(456,"当前邮箱已被使用");
		}
		switch (user.getStatus()){
			case 1:
				break;
			case 2:
				school = userMapper.getSchoolCode(user.getUserDetail().getCode());
				if(school==null) {
					//邀请码错误
					throw new RegisterException(455, "邀请码不存在");
				}
				user.getUserDetail().setSchool_id(school.getId());
				user.getUserDetail().setSchool_name(school.getName());
				user.getUserDetail().setIs_open(0);
				break;
			case 3:
				break;
		}
//		密码
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		int count = userMapper.Register(user);
		//userId
		user.getUserDetail().setDetail_user_id(user.getId());

		if(count==1){
			//插入详细信息
			int infoCount = userDetailMapper.InsertDetails(user.getUserDetail());
			//这里应该有一个权限添加的语句
			UserRole userRole = new UserRole(user.getId(),user.getStatus());
			int roleCount = userRoleMapper.insert(userRole);
			if(roleCount==1){
				if(user.getStatus()==2){
					//发送消息
					messageManagerApi.teacherApproveMessage(school.getEmail(),user.getEmail());
				}
				userOV.setStatus(CodeConstant.SUCCESS);
			}else{
				logger.error("注册过程中身份插入失败");
				userOV.setStatus(CodeConstant.FAIL).setMessage("身份插入失败");
			}
		}else{
			logger.error("注册过程中用户信息插入失败");
			userOV.setStatus(CodeConstant.FAIL).setMessage("注册失败");
		}
		return userOV;
	}


	//真为可以注册
	public boolean checkRepetition(String email){
		//查重
		Integer flag = userMapper.checkRepetition(email);
		return flag==null;
	}
}
