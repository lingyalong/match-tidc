package com.tidc.api.exception;

import lombok.Data;

/**
 * @ClassNmae UltraVires
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
public class UltraViresException extends Exception {
//	457
	private int code;
	private String message;
	public UltraViresException(int code, String message){
		super();
		this.code = code;
		this.message = message;
	}
}
