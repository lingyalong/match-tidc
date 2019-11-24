package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae Apply
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Scope(value = "prototype")
@Component
public class Apply implements Serializable {
	private Integer id;
	//申请人
	private String proposer_email;
	//受理人
	private String acceptor_email;
	//请求类型1是老师请求学校认证 2是学生请求学校认证
	private Integer application_type;
	//0是拒绝 1是同意 -1是未读
	private Integer is_read;
}
