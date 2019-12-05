package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassNmae Question
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Question implements Serializable {
	private Integer id;
	//标题
	private String title;
//	1单选/2多选/3判断/4填空/5简答
	private Integer genre;
	//答案
	private String answer;
	//选项  以 | 分割
	private String option;
	//解析
	private String analysis;
	private BigDecimal score;
	private Integer school_id;

}
