package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae UserMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface UserMapper {
	@Insert("insert into user(name,email,password,status) values(#{name},#{email},#{password},#{status})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int Register(User user);
}
