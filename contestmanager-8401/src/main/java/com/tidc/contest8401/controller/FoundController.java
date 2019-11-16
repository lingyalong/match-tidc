package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Contest;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae foundController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class FoundController {
	@Autowired
	private FoundService foundService;
	@PostMapping("/contest")
	public UserOV foundContest(@RequestBody Contest contest, @RequestParam("school_email")String school_email){
		return foundService.foundService(contest, school_email);
	}
}
