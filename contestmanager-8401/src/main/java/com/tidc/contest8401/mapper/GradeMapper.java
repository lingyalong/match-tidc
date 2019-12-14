package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


/**
 * @ClassNmae GradeMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository

public interface GradeMapper {
	@Insert("insert into grade(teacher_id,work_id,score,contest_id) values(#{teacher_id},#{work_id},#{score},#{contest_id})")
	int insertGrade(Grade grade);
	@Update("update grade set score = #{score} where teacher_id = #{teacher_id} and work_id = #{work_id}")
	int updateGrade(Grade grade);
	@Select("select score from grade where teacher_id = #{teacher_id} and work_id = #{work_id}")
	BigDecimal  getOldScore(Grade grade);
}
