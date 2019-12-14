package com.tidc.api.pojo.exam;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassNmae HistoryExaminationQuestion
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class HistoryExaminationQuestion implements Serializable {
	private Integer id;
	private Integer history_examination_id;
	private Integer history_question_id;
}
