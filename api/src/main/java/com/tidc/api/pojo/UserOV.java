package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae UserOv
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class UserOV<T> implements Serializable {
	/**
	 * 状态标识
	 */
	private Enum status;
	/**
	 * 数据对象
	 */
	private T data;
	/**
	 *错误信息
	 */
	private String message;
	/**
	 * 错误代码
	 */
	private Integer code;

}
