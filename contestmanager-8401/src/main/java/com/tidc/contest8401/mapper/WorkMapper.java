package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Work;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae WorkMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface WorkMapper {
	@Insert("insert into work(name,student_id,logo,url,contest_id,is_money,score,brief) values(#{name},#{student_id},#{logo},#{url},#{contest_id},#{is_money},#{score},#{brief})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	void insetWork(Work work);

	@Select("select student_id from work where contest_id = #{id}")
	List<Integer> listStudentID(int id);

	@Select("select student_id from work where id=#{id}")
	Integer checkLeader(int id);

	@Delete("delete from work where id = #{id}")
	int deleteWork(int id);

	@Select("select * from work where contest_id = #{contest_id}")
	List<Work> listWork(int contest_id);
}
