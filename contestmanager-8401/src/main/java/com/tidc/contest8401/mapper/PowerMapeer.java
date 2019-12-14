package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Power;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @ClassNmae PowerMapeer
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface PowerMapeer {
	@Insert("insert into power(teacher_id,contest_id) values(#{teacher_id},#{contest_id})")
	void insetPower(Power power);

	@Select("select id from power where teacher_id = #{teacher_id} and contest_id = #{contest_id}")
	Integer checkRepetition(Power power);

	@Delete("delete from power where contest_id = #{contest_id}")
	int deleteContestPower(int Contest_id);

	@Delete("delete from power where id = #{id}")
	int deletePower(int id);
}
