package com.tidc.authentication9001.mapper;

import com.tidc.api.pojo.user.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae UserMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface UserMapper {
	@Select("SELECT password,status FROM user WHERE email = #{email}")
	User login(String email);



	User getUserInfo(User user);
}
