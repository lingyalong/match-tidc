package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae UserMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface UserMapper {
	@Insert("insert into user(name,email,password,status,user_role_id) values(#{name},#{email},#{password},#{status},#{user_role_id})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int Register(User user);
	@Select("select id, name, email from user where code=#{cede} and status = 3")
	User getSchoolCode(String code);
	@Select("SELECT id FROM user WHERE email = #{email}")
	Integer checkRepetition(String email);
	@Select("SELECT user.* FROM user LEFT JOIN user_detail ud ON user.id = ud.detail_user_id WHERE ud.school_id = #{schoolId}")
	List<User> listSchoolStudent(int schoolId);

	User getUserInfo(String email);
}
