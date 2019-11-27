package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.fallback.MessageManagerFallbackFactory;
import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.Work;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae ContestManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "CONTESTMANAGER",fallbackFactory = ContestManagerFallbackFactory.class)
public interface ContestManagerApi {

	@RequestMapping(value = "/contest",method = RequestMethod.POST)
	UserOV<Integer> foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email);

	@RequestMapping(value = "/power",method = RequestMethod.POST)
	UserOV addPower(@RequestBody Power power,@RequestParam("email") String email);

	@RequestMapping(value = "/type",method = RequestMethod.POST)
	UserOV addType(@RequestParam("name") String name);

	@RequestMapping(value = "/contest",method = RequestMethod.GET)
	UserOV<List<Contest>> getContestAll();

	@RequestMapping(value = "/apply",method = RequestMethod.POST)
	UserOV apply(@RequestBody Work work,@RequestParam("email") String email);

	@RequestMapping(value = "/type/contest",method = RequestMethod.GET)
	UserOV<List<Contest>> getTypeContest(@RequestParam("type") String type);
}
