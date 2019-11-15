package com.tidc.usermanager.mapper;

import com.tidc.usermanager.pojo.School;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae SchoolMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SchoolMapper {
	@Select("select id, name, email from school where code=#{cede}")
	public School getSchoolCode(String code);
	@Select("select email,password from school where email=#{email}")
	public School chickEmail(String email);
	@Select("select e.name from school_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
	@Select("select name, brief, email, from school where email=#{email}")
	public School getSchool(String email);
}
