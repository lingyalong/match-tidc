package com.tidc.contest8401.service;

import com.tidc.api.pojo.Grade;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNmae ScoreService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ScoreService {
	/**
	 * 评分
	 * @param grade
	 * @return
	 */
	UserOV addScore(Grade grade);

	/**
	 * 修改评分
	 * @param grade
	 * @return
	 */
	UserOV updateScore(Grade grade);
}
