package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae Work
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Work implements Serializable {
	private Integer id;
	private String name;
	private Integer student_id;
	private String logo;
	private String url;
	private Integer contest_id;
	private Integer is_money;
	private Double score;
	private String brief;
}
