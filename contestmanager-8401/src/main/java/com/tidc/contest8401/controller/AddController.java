package com.tidc.contest8401.controller;

import com.tidc.api.pojo.ContestType;
import com.tidc.api.pojo.Power;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae AddController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class AddController {
	@Autowired
	private AddService addService;
	@PostMapping("/power")
	public UserOV addPower(@RequestBody Power power,@RequestParam("email") String email){
		return addService.addPower(power,email);
	}
	@PostMapping("/type")
	public UserOV addType(@RequestParam("name") String name){
		return addService.addType(name);
	}

}
