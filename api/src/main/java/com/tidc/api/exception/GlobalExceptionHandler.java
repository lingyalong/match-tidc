package com.tidc.api.exception;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassNmae GlobalExceptionHandler
 * @Description TODO
 * @Author 冯涛滔
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(RepetitionException.class)
	public UserOV repetitionException(RepetitionException exception){
		logger.error(exception.toString());
		UserOV userOV = new UserOV();
		userOV.setCode(429).setStatus(CodeConstant.FAIL).setMessage(exception.getMessage());
		return userOV;
	}
	@ExceptionHandler(DeleteFailedException.class)
	public UserOV deleteFailedException(DeleteFailedException exception){
		logger.error(exception.toString());
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.FAIL).setMessage(exception.getMessage()).setCode(408);
		return userOV;
	}
}
