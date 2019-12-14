package com.tidc.api.controller;

import com.tidc.api.fallback.ContestManagerFallbackFactory;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.exam.HistoryExamination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae RabbitManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "RABBITMQ",fallbackFactory = ContestManagerFallbackFactory.class)
public interface RabbitManagerApi {
	@RequestMapping(value = "/send/message",method = RequestMethod.POST)
	void sendMessage(@RequestBody Message message);

	@RequestMapping(value = "/send/list/message",method = RequestMethod.POST)
	void sendListMessage(@RequestBody Map map);

	@RequestMapping(value = "/delete/file",method = RequestMethod.POST)
	void deleteFile(@RequestParam("path") String path);

	@RequestMapping(value = "/delete/contest/work/team",method = RequestMethod.POST)
	void deleteWorkANdTeam(@RequestParam("contestId") int contestId);

	/**
	 * 创建历史试卷
	 * @param contestId
	 * @param examinationId
	 */
	@RequestMapping(value = "/history/examination",method = RequestMethod.POST)
	void foundHistoryExamination(@RequestParam("contestId") int contestId,
										@RequestParam("examinationId") int examinationId);

	/**
	 * 创建好历史试卷之后给他连接试题 需要原试卷id和历史试卷id
	 * @param
	 */
	@RequestMapping(value = "/history/join/question",method = RequestMethod.POST)
	void historyJoinQuestion(@RequestBody HistoryExamination historyExamination);
}
