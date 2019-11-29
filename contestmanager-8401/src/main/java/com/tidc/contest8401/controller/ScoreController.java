package com.tidc.contest8401.controller;

import com.tidc.api.pojo.Grade;
import com.tidc.api.pojo.UserOV;
import com.tidc.contest8401.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae ScoreController
 * @Description TODO
 * @Author 冯涛滔
 **/
@CrossOrigin
@RestController
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	/**
	 * 评分
	 * @param grade
	 * @return
	 */
	@PostMapping("/score")
	public UserOV addScore(@RequestBody Grade grade){
		return scoreService.addScore(grade);
	}

	/**
	 * 修改评分
	 * @param grade
	 * @return
	 */
	@PutMapping("/score")
	public UserOV updateScore(@RequestBody Grade grade){

		return	scoreService.updateScore(grade);
	}
}
