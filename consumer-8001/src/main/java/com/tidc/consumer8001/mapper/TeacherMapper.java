package com.tidc.consumer8001.mapper;
import com.tidc.consumer8001.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae TeacherMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface TeacherMapper {
	@Select("select email,password from teacher where email=#{email}")
	public Teacher chickEmail(String email);
	@Select("select e.name from teacher_role r left outer join role e on r.student_role_id=e.id where r.student_id = #{id}")
	public List<String> listPower(int id);
}
