package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae Student
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Student implements Serializable  {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Integer age;
	private String idEntity;
	private String telephone;
	private String school;
	//院系
	private String department;
	//专业
	private String major;
	//班级
	private String grade;
	private String studentNumber;
	private Integer student_school_id;
}
