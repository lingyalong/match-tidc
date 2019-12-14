package com.tidc.exam.mapper;

import com.tidc.api.pojo.exam.HistoryExamination;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae HistoryExaminationMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface HistoryExaminationMapper {
	@Insert("INSERT INTO history_examination(contest_id,name,brief,time,school_id) VALUES(#{contest_id},#{name},#{brief},#{time},#{school_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int insertHistoryExamination(HistoryExamination examination);

	HistoryExamination getHistoryExaminationAndQuestion(int id);
}
