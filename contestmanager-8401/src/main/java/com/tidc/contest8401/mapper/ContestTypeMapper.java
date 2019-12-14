package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.ContestType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae ContestTypeMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface ContestTypeMapper {
	@Select("select name from contest_type")
	List<String> listType();
	@Insert("insert into contest_type(name) values(#{name})")
	void insertContestType(String name);
	@Select("select id from contest_type where name = #{name}")
	Integer checkRepetition(String name);
}
