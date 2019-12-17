package com.tidc.api.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassNmae ContestApply
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true)
@Component
@Scope("prototype")
public class ContestApply implements Serializable {
	private Integer id;
	private Integer student_id;
	private Integer contest_id;
	private Integer history_examination_id;
	private Integer is_submit;
	private Integer record_id;
	private BigDecimal score;
	private String studentName;
	private String student_name;
}
