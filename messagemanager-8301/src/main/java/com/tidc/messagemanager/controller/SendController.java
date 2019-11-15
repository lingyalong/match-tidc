package com.tidc.messagemanager.controller;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNmae SendController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class SendController {
	@Autowired
	private SendService sendService;
	@GetMapping("/teacher/approve")
	public UserOV teacherApproveMessage(@RequestParam("schoolEmail") String schoolEmail, @RequestParam("teacherEmail") String teacherEmail){
		return sendService.teacherApproveMessage(schoolEmail, teacherEmail);
	}
}
