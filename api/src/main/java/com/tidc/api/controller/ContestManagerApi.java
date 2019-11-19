package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.fallback.MessageManagerFallbackFactory;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae ContestManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "CONTESTMANAGER",fallbackFactory = ContestManagerFallbackFactory.class)
public interface ContestManagerApi {
	@RequestMapping(value = "/contest",method = RequestMethod.POST)
	UserOV foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email);
	@RequestMapping(value = "/power",method = RequestMethod.POST)
	UserOV addPower(@RequestBody Power power,@RequestParam("email") String email);
}
