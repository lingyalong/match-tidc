package com.tidc.api.exception;

import lombok.Data;

/**
 * @ClassNmae RepetitionException
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
public class RepetitionException extends Exception {
	//返回码 429 重复操作
	private int code;
	private String message;
	public RepetitionException(int code, String message){
		super();
		this.code = code;
		this.message = message;
	}
}
