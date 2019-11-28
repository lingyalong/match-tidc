package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Team;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @ClassNmae TeamMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Mapper
public interface TeamMapper {
	@Insert("insert into team(student_id,work_id,is_leader) values(#{student_id},#{work_id},1)")
	int insertLeader(Team team);

	@Insert("insert into team(student_id,work_id,is_leader) values(#{student_id},#{work_id},0)")
	void insertMember(Team team);

	@Select("select id from Team where student_id = #{student_id} and work_id = #{work_id} ")
	Integer checkRepetition(Team team);

	@Select("select student_id from team where work_id = #{work_id} and is_leader = 1 ")
	Integer checkLeader(int work_id);

	@Delete("delete from team where student_id = #{student_id} and work_id = #{work_id}")
	int deleteMember(Team team);

	@Delete("delete from team where work_id = #{word_id}")
	int deleteWorkTeam(int work_id);
}
