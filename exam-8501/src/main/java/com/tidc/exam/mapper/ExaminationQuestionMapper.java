package com.tidc.exam.mapper;

import com.tidc.api.pojo.ExaminationQuestion;
import org.apache.ibatis.annotations.Insert;

/**
 * @ClassNmae ExaminationQuestionMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ExaminationQuestionMapper{
	@Insert("insert into examination_question(examination_id,question_id) values(#{examination_id},#{question_id})")
	int foundRelevance(ExaminationQuestion examinationQuestion);
}
