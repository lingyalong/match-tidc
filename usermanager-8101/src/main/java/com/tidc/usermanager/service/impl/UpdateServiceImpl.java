package com.tidc.usermanager.service.impl;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.exception.UltraViresException;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;
import com.tidc.api.pojo.user.UserDetail;
import com.tidc.usermanager.mapper.UserDetailMapper;
import com.tidc.usermanager.mapper.UserMapper;
import com.tidc.usermanager.service.UpdateService;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNmae UpdateServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class UpdateServiceImpl implements UpdateService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserDetailMapper userDetailMapper;
	private Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);
	/**
	 * 解封老师账号
	 * @param teacher
	 * @return
	 */
	@Override
	public UserOV switchTeacher(User teacher) throws UltraViresException {
		UserOV userOV = new UserOV();
		UserDetail userInfo = userDetailMapper.getUserInfo(teacher.getUserDetail().getId());
		if (!userInfo.getSchool_id().equals(teacher.getUserDetail().getSchool_id())){
			throw new UltraViresException(457,teacher+"越权更改老师账号状态");
		}
		int count = userDetailMapper.updateIsOpen(teacher.getUserDetail());

		if(count==1){
			userOV.setStatus(CodeConstant.UPDATE);
		}else{
			userOV.setStatus(CodeConstant.FAIL).setMessage("解封失败");
		}
		return userOV;
	}
}
