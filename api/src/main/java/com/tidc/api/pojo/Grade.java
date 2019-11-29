package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae Grade
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Grade implements Serializable {
	private Integer id;
	private Integer teacher_id;
	private Integer work_id;
	private Double score;
	private String token;
	private Integer Contest_id;
}
