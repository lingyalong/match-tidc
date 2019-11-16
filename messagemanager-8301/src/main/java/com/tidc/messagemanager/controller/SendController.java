package com.tidc.messagemanager.controller;
import com.tidc.api.pojo.UserOV;
import com.tidc.messagemanager.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@PostMapping("/teacher/approve")
	public UserOV teacherApproveMessage(@RequestParam("schoolEmail") String schoolEmail, @RequestParam("teacherEmail") String teacherEmail){
		return sendService.teacherApproveMessage(schoolEmail, teacherEmail);
	}
}
