package com.tidc.consumer8001.mapper;

import com.tidc.consumer8001.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae StudentMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface StudentMapper  {
	@Select("select email,password from student where email=#{email}")
	public Student chickEmail(String email);
	@Select("select e.name from student_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
}
