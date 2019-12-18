package com.tidc.api.exception;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassNmae RegisterExpetion
 * @Description TODO
 * @Author 冯涛滔
 **/
@Accessors(chain = true)
@Data
public class RegisterException extends Exception{
	private int code;
	private String message;
//	455 邀请码错误 456 邮箱重复
	public RegisterException(int code,String message){
		this.code = code;
		this.message = message;
	}
}
