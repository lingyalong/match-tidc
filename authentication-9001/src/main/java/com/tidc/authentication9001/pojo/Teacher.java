package com.tidc.authentication9001.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae Teacher
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Teacher implements Serializable {
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private String Telephone;
	//部门
	private String department;
	private String idEntity;
	//职务
	private String position;
	//职称
	private String titles;
	private String password;
	private Integer teacher_school_id;
}
