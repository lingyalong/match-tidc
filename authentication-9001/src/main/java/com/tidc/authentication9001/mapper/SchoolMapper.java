package com.tidc.authentication9001.mapper;

import com.tidc.authentication9001.pojo.School;
import com.tidc.authentication9001.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae School
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SchoolMapper {
	@Select("select email,password from school where email=#{email}")
	public School chickEmail(String email);
	@Select("select e.name from school_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
	@Select("select name, brief, email, from school where email=#{email}")
	public School getSchool(String email);
}
