package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.Status;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassNmae StatusMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface StatusMapper {
	@Select("select is_status from status where email=#{email}")
	Integer getStatus(String email);
	@Insert("insert into status(email,is_status) values(#{email},#{is_status})")
	int insertStatus(Status status);
}
