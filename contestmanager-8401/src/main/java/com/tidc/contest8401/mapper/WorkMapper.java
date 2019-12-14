package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Work;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassNmae WorkMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
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

	@Update("update work set score = score+#{score}")
	int updateScore(BigDecimal  score);

	Integer updateWork(Work work);

	List<Work> checkScore(int Contest_id);
}
