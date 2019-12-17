package com.tidc.api.pojo.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae UserDetail
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Scope(value = "prototype")
@Component
public class UserDetail implements Serializable {
	private Integer id;
	private Integer detail_user_id;
	private Integer id_entity;
	private String telephone;
	private String school_name;
	private Integer school_id;
	private String department;//学院
	private String major; //专业
	private String student_number;
	private String position; //职位
	private String brief; //学校简介
	private String code; //邀请码
	private Integer is_open; //0/1
}
