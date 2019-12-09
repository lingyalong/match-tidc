package com.tidc.consumer8001.exception;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
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
	@ExceptionHandler(InvalidTokenException.class)
	public UserOV invalidTokenException(InvalidTokenException e){
		logger.error(e.toString());
		UserOV userOV = new UserOV();
		userOV.setStatus(CodeConstant.ERROR).setMessage("登录过期").setCode(401);
		return userOV;
	}

}
