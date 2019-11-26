package com.tidc.api.exception;

import com.tidc.api.constant.CodeConstant;
import com.tidc.api.pojo.UserOV;
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
	@ExceptionHandler(RepetitionException.class)
	public UserOV repetitionException(RepetitionException exception){
		UserOV userOV = new UserOV();
		userOV.setCode(exception.getCode()).setStatus(CodeConstant.FAIL).setMessage(exception.getMessage());
		return userOV;
	}

}
