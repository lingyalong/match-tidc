package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.user.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae UserRoleMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface UserRoleMapper {
	@Insert("INSERT INTO user_role(user_id,role_id) VALUES(#{user_id},#{role_id})")
	int insert(UserRole userRole);
}
