package com.tidc.exam.mapper;

import com.tidc.api.pojo.ExaminationQuestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @ClassNmae ExaminationQuestionMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ExaminationQuestionMapper{
	@Insert("insert into examination_question(examination_id,question_id) values(#{examination_id},#{question_id})")
	int foundRelevance(ExaminationQuestion examinationQuestion);

	@Delete("delete from examination_question where question_id = #{id}")
	int deleteQuestion(int id);

	@Delete("delete from examination_question where examination_id = #{id}")
	int deleteExamination(int id);

	@Delete("delete from examination_question where question_id = #{question_id} and examination_id = #{examination_id}")
	int examinationDeleteQuestion(ExaminationQuestion examinationQuestion);
}
