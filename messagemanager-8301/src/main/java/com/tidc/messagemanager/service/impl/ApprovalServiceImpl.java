package com.tidc.messagemanager.service.impl;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.mapper.ApplyMapper;
import com.tidc.messagemanager.service.ApprovalService;
import com.tidc.messagemanager.utiles.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae ApprovalServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class ApprovalServiceImpl implements ApprovalService {
	@Autowired
	private ApplyMapper applyMapper;
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private ApplicationContextProvider ac;
	@Override
	public UserOV readApply(Apply apply) {
		Teacher teacher = ac.getBean(Teacher.class);
		teacher.setEmail(apply.getProposer_email());
		int count = applyMapper.updateApplyRead(apply);

		if(apply.getIs_read()==1){
			teacher.setIs_open(1);
		}else{
			//拒绝
			teacher.setIs_open(-1);
		}
		UserOV userOV = userManagerApi.teacherOpen(teacher);
		return userOV;
	}
}
