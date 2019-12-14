package com.tidc.rabbitmq.service;

import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.exam.HistoryExamination;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae SendService
 * @Description TODO
 * @Author 冯涛滔
 **/

public interface SendService {
	void sendMessage(Message message);
	void sendListMessage(Map map);
	void deleteFile(String path);
	void deleteWorkANdTeam(int contestId);
	/**
	 * 创建历史试卷
	 * @param contestId
	 * @param examinationId
	 */
	void foundHistoryExamination(int contestId,int examinationId);

	/**
	 * 创建好历史试卷之后给他连接试题
	 * @param historyExamination
	 */
	void historyJoinQuestion(HistoryExamination historyExamination);
}
