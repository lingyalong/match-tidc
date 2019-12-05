package com.tidc.exam.mapper;

import com.tidc.api.pojo.Examination;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae ExaminationMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ExaminationMapper {
	@Insert("insert into examination(name,brief,time,school_id) values(#{name},#{brief},#{time},#{school_id})")
	int foundExamination(Examination examination);

	@Select("select id,name,time from examination where school_id = #{schoolId}")
	List<Examination> listSchoolExamination(int schoolId);

	@Select("select * from examination where id = #{id}")
	Examination getExamination(int id);

	Examination getExaminationInQuestion(int id);
}
