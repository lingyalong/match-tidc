package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Power;
import org.apache.ibatis.annotations.Insert;

/**
 * @ClassNmae PowerMapeer
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface PowerMapeer {
	@Insert("insert into power(teacher_id,school_id) values(#{teacher_id},#{school_id})")
	void insetPower(Power power);
}
