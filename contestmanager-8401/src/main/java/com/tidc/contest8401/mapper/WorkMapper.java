package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Work;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @ClassNmae WorkMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface WorkMapper {
	@Insert("insert into work(name,student_id,logo,url,contest_id,is_money,score,brief) values(#{name},#{student_id},#{logo},#{url},#{contest_id},#{is_money},#{score},#{brief})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	void insetWork(Work work);
}
