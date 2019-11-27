package com.tidc.authentication9001.mapper;
import com.tidc.api.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae TeacherMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface TeacherMapper {
	@Select("select id,email,password from teacher where email=#{email}")
	Teacher chickEmail(String email);
	@Select("select e.name from teacher_role r left outer join role e on r.teacher_role_id=e.id where r.teacher_id = #{id}")
	List<String> listPower(int id);
	@Select("select name, email, telephone, department idEntity titles from teacher where email=#{email}")
	Teacher getTeacher(String email);

}
