package com.tidc.api.exception;


import lombok.Data;

/**
 * @ClassNmae DeleteFailedException
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
public class DeleteFailedException extends Exception{
	private String message;
	public DeleteFailedException(String message){
		this.message = message;
	}
}
