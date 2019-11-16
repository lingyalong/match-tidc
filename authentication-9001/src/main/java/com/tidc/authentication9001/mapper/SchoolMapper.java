package com.tidc.authentication9001.mapper;

import com.tidc.api.pojo.School;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae School
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SchoolMapper {
	@Select("select id,email,password from school where email=#{email}")
	School chickEmail(String email);
	@Select("select e.name from school_role r left outer join role e on r.school_role_id=e.id where r.school_id = #{id}")
	List<String> listPower(int id);
	@Select("select name, brief, email, from school where email=#{email}")
	School getSchool(String email);
}
