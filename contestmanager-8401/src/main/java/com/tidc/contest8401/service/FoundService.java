package com.tidc.contest8401.service;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;

/**
 * @ClassNmae FoundService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface FoundService {
	UserOV<Integer> foundService(Contest contest,String school_email) throws ParseException;
	UserOV apply(Work work,String email);
}
