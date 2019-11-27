package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassNmae TeamMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface TeamMapper {
	@Insert("insert into team(student_id,work_id,is_leader) values(#{student_id},#{work_id},1)")
	void insertLeader(Team team);
	@Insert("insert into team(student_id,work_id,is_leader) values(#{student_id},#{work_id},0)")
	void insertMember(Team team);
	@Select("select id from Team where student_id = #{student_id} and work_id = #{work_id} ")
	Integer CheckRepetition(Team team);

}
