package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae SchoolMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SchoolMapper {
	@Select("select id, name, email from user where code=#{cede} and status = 3")
	User getSchoolCode(String code);
	@Select("select email,password from school where email=#{email}")
	School chickEmail(String email);
	@Select("select e.name from school_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	List<String> listPower(int id);
	@Select("select id,name,brief,email from school where email=#{email}")
	School getSchool(String email);
}
