package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae StudentMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface StudentMapper {
	@Select("select id,email,password from student where email=#{email}")
	Student chickEmail(String email);
	@Select("select e.name from student_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	List<String> listPower(int id);
	@Select("select id,name, email, age, idEntity, telephone, school, department, major, grade, studentNumber from student where email=#{email}")
	Student getStudent(String email);
	@Select("select * from student where student_school_id=#{id}")
	List<Student> listSchoolStudent(int id);
}
