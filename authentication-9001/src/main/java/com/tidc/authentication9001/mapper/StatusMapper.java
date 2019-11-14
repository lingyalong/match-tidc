package com.tidc.authentication9001.mapper;

import com.tidc.authentication9001.pojo.Status;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassNmae StatusMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface StatusMapper {
	@Select("select is_status from status where email=#{email}")
	public Integer getStatus(String email);
}
