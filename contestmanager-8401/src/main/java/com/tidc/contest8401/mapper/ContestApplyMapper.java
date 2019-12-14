package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.ContestApply;
import com.tidc.api.pojo.exam.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae ContestApplyMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface ContestApplyMapper{
	@Insert("INSERT INTO contest_apply(student_id,contest_id,history_examination_id,is_submit) " +
			"VALUES(#{student_id},#{contest_id},#{history_examination_id},0)")
	int apply(ContestApply contestApply);

	@Select("SELECT COUNT(id) FROM contest_apply WHERE student_id = #{student_id} and contest_id = #{contest_id}")
	Integer checkApply(Record record);

	@Update("UPDATE contest_apply set record_id = #{id},score = #{score}, is_submit = 1 where contest_id = #{contest_id} and student_id = student_id" )
	int updateRecordAndScore(Record record);
}
