package com.tidc.messagemanager.controller;
import com.tidc.api.pojo.Message;
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
	@PostMapping("/message")
	public UserOV sendMessage(@RequestBody Message message){
		return sendService.sendMessage(message);
	}

	/**
	 * 根据学校的id给所有学生发送信息
	 * @param id 学校id
	 * @param message 具体信息
	 * @return
	 */
	@PostMapping("/school/message")
	public UserOV sendSchoolMessage(@RequestParam("id") int id,@RequestParam("message") String message){
		return sendService.sendSchoolMessage(id, message);
	}
}
