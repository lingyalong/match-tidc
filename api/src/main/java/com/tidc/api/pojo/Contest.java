package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassNmae Contest
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Component
@Scope("prototype")
public class Contest implements Serializable {
	private Integer id;
	private String name;
	private String domain;
	//是否开启评分功能
	private Integer is_mark;
	//是否开启匿名模式
	private Integer is_anonymous;
	//是否是线上考试
	private Integer is_exam;
	//是否使用系统改卷
	private Integer is_automation;
	//是否收费 如果收这个字段就是收多少钱
	private Integer is_money;
	private String brief;
	private Date start;
	private Date over;
	//试卷id
	private Integer test_id;
	private String url;
	private String logo;
	//发起学校
	private Integer school_id;
	private Integer number;
	//收多少钱保留到小数点后两位 10,1
	private BigDecimal money;
}
