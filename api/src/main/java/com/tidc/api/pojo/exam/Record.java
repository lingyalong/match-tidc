package com.tidc.api.pojo.exam;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassNmae Record
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class Record implements Serializable {
	private Integer id;
	private Integer student_id;
	private Integer history_examination_id;
	private Integer time;
	private Integer correct;
	private String answer;
	private BigDecimal score;
	private Integer contest_id;
}
