package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Team;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae DeleteController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class DeleteController {
	@Autowired
	private DeleteService deleteService;
	@DeleteMapping("/member")
	public UserOV deleteMember(@RequestBody Team team){
		return deleteService.deleteMember(team);
	}
}
