package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sun.awt.SunHints;

import java.util.List;

/**
 * @ClassNmae TeacherMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface TeacherMapper {
	@Insert("insert into teacher(name,email,telephone,idEntity,department,position,titles,password,teacher_school_id,schoolName,is_open) values(#{name},#{email},#{telephone},#{idEntity},#{department},#{position},#{titles},#{password},#{teacher_school_id},#{schoolName},#{is_open})")
	int teacherRegister(Teacher teacher);
	@Select("select email,password from teacher where email=#{email}")
	Teacher chickEmail(String email);
	@Select("select e.name from teacher_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	List<String> listPower(int id);
	@Select("select id,name, email, telephone, department, idEntity, titles from teacher where email=#{email}")
	Teacher getTeacher(String email);
	@Update("update teacher set is_open=#{is_open} where email=#{email}")
	int updateTeacherOpen(Teacher teacher);

}
