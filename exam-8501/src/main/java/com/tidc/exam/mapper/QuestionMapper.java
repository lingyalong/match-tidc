package com.tidc.exam.mapper;

import com.tidc.api.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNmae QuestionMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface QuestionMapper {
	@Insert("insert into question(`title`, `genre`, `answer`, `school_id`, `option`, `analysis`, `score`) values(#{title},#{genre},#{answer},#{school_id},#{option},#{analysis},#{score})")
	int foundQuestion(Question question);

	@Select("select * from question where id = #{id}")
	Question getQuestion(int id);

	@Select("select id,title,genre,score from question where school_id = #{schoolId}")
	List<Question> listSchoolQuestion(int schoolId);


	int updateQuestion(Question question);
}
