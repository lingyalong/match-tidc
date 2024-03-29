package com.tidc.exam.mapper;

import com.tidc.api.pojo.exam.ExaminationQuestion;
import com.tidc.api.pojo.exam.Question;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae QuestionMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface QuestionMapper {
	@Insert("insert into question(`title`, `genre`, `answer`, `school_id`, `option`, `analysis`, `score`) values(#{title},#{genre},#{answer},#{school_id},#{option},#{analysis},#{score})")
	int foundQuestion(Question question);

	@Select("select * from question where id = #{id}")
	Question getQuestion(int id);

	@Select("select id,title,genre,score from question where school_id = #{schoolId}")
	List<Question> listSchoolQuestion(int schoolId);

	@Delete("delete from question where id = #{id}")
	int deleteQuestion(int id);

	List<Question> listQuestion(List<ExaminationQuestion> list);

	int updateQuestion(Question question);
}
