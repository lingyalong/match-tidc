package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;

import java.text.ParseException;

/**
 * @ClassNmae FoundService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FoundService {
	UserOV<Integer> foundService(Contest contest,String school_email) throws ParseException;
}
