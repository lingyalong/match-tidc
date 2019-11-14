package com.tidc.consumer8001.mapper;

import com.tidc.consumer8001.pojo.School;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae School
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface SchoolMapper {
	@Select("select email,password from school where email=#{email}")
	public School getkEmail(String email);
	@Select("select e.name from school_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
}
