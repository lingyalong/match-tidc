package com.tidc.api.constant;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae CodeConstant
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Component()
public class CodeConstant {
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	public static final String ERROR = "ERROR";
	public static final String UPDATE = "UPDATE";
	public static final String NMSL="nmsl";
}
