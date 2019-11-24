package com.tidc.filemanager.exception;

/**
 * @ClassNmae TypeException
 * @Description TODO
 * @Author 冯涛滔
 **/
public class TypeException extends Exception{
	private String message;
	public TypeException(String message){
		this.message = message;
	}
}
