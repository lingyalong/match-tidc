package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Power;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassNmae PowerMapeer
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface PowerMapeer {
	@Insert("insert into power(teacher_id,contest_id) values(#{teacher_id},#{contest_id})")
	void insetPower(Power power);
	@Select("select id from power where teacher_id = #{teacher_id} and contest_id = #{contest_id}")
	Integer checkRepetition(Power power);
}
