package com.tidc.api.pojo.exam;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassNmae HistoryExamination
 * @Description TODO
 * @Author 冯涛滔
 **/
@Data
@Accessors(chain = true) //这个注解可以使这个类的set方法返回当前对象
@Scope(value = "prototype")
@Component()
public class HistoryExamination implements Serializable {
	private Integer id;
	private Integer contest_id;
	private String name;
	private String brief;
	private Integer time;
	private Integer school_id;



	private List<HistoryQuestion> historyQuestionList;
	private List<Integer> historyQuestionIds;
	private Integer examinationId;
	public HistoryExamination( ) {
		super();
	}
	public HistoryExamination(Examination ex) {
		this.name = ex.getName();
		this.brief = ex.getBrief();
		this.time = ex.getTime();
		this.school_id = ex.getSchool_id();
		this.examinationId = ex.getId();
	}
}
