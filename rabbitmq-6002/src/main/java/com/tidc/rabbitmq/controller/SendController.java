package com.tidc.rabbitmq.controller;

import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.exam.Examination;
import com.tidc.api.pojo.exam.HistoryExamination;
import com.tidc.rabbitmq.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae SendController
 * @Description TODO
 * @Author 冯涛滔
 **/
@RestController
@CrossOrigin
public class SendController {
	@Autowired
	private SendService sendService;
	@PostMapping("/send/message")
	public void sendMessage(@RequestBody  Message message){
		sendService.sendMessage(message);
	}

	@PostMapping("/send/list/message")
	public void sendListMessage(@RequestBody Map map){
		sendService.sendListMessage(map);
	}

	@PostMapping("/delete/file")
	public void deleteFile(@RequestParam("path") String path){
		sendService.deleteFile(path);
	}

	@PostMapping("/delete/contest/work/team")
	public void deleteWorkANdTeam(@RequestParam("contestId") int contestId){
		sendService.deleteWorkANdTeam(contestId);
	}

	/**
	 * 创建历史试卷
	 * @param contestId
	 * @param examinationId
	 */
	@PostMapping("/history/examination")
	public void foundHistoryExamination(@RequestParam("contestId") int contestId,
										@RequestParam("examinationId") int examinationId){
		sendService.foundHistoryExamination(contestId,examinationId);
	}
	/**
	 * 创建好历史试卷之后给他连接试题 需要原试卷id和历史试卷id
	 * @param
	 */
	@PostMapping("/history/join/question")
	public void historyJoinQuestion(@RequestBody HistoryExamination historyExamination){
		sendService.historyJoinQuestion(historyExamination);
	}
}
