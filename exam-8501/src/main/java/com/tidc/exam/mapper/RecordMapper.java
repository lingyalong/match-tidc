package com.tidc.exam.mapper;

import com.tidc.api.pojo.exam.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae RecordMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface RecordMapper {
	@Insert("INSERT INTO record(student_id,history_examination_id,time,correct,answer,score,contest_id) " +
			"VALUES(#{student_id},#{history_examination_id},#{time},#{correct},#{answer},#{score},#{contest_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int insertRecord(Record record);
}
