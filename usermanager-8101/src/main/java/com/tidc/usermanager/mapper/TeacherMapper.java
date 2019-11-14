package com.tidc.usermanager.mapper;

import com.tidc.usermanager.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import sun.awt.SunHints;

import java.util.List;

/**
 * @ClassNmae TeacherMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface TeacherMapper {
	@Insert("insert into teacher(name,age,email,telephone,idEntity,department,position,titles,password,teacher_school_id,schoolName,is_open) values(#{name},#{age},#{email},#{telephone},#{idEntity},#{department},#{position},#{titles},#{password},#{teacher_school_id},#{schoolName},#{is_open})")
	void teacherRegister(Teacher teacher);
	@Select("select email,password from teacher where email=#{email}")
	public Teacher chickEmail(String email);
	@Select("select e.name from teacher_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
	@Select("select name, age, email, telephone, deparment idEntity titles from teacher where email=#{email}")
	public Teacher getTeacher(String email);

}
