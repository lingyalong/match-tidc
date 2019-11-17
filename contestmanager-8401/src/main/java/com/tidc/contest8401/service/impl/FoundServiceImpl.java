package com.tidc.contest8401.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tidc.api.constant.CodeConstant;
import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.School;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.FoundService;
import com.tidc.utils.CheckObjectIsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.scope.Scope;

import java.util.LinkedHashMap;

/**
 * @ClassNmae foundServiceImpl
 * @Description TODO
 * @Author 冯涛滔
 **/
@Service
public class FoundServiceImpl implements FoundService {
	@Autowired
	private UserManagerApi userManagerApi;
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public UserOV foundService(Contest contest, String school_email) {
		UserOV userOV2 = userManagerApi.userInfo(school_email);
		LinkedHashMap data = (LinkedHashMap) userOV2.getData();
		School school = objectMapper.convertValue(data, new TypeReference<School>() {});
		contest.setSchool_id(school.getId());
		contest.setNumber(0);
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.UPDATE);
		if (!CheckObjectIsNullUtils.contestObjCheckIsNull(contest)) {
			userOV.setStatus(CodeConstant.FAIL).setMessage("有字段未填写");
		}
		return userOV;
	}
}
