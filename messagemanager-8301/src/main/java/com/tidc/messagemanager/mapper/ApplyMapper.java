package com.tidc.messagemanager.mapper;

import com.tidc.api.pojo.Apply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassNmae ApplyMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ApplyMapper {
	@Insert("insert into apply(proposer_email,acceptor_email,application_type,is_read) values(#{proposer_email},#{acceptor_email},#{application_type},#{is_read})")
	void insertApply(Apply apply);
	@Select("select * from apply where acceptor_email=#{acceptor_email}")
	List<Apply> listApply(String acceptor_email);
	@Update("update apply set is_read=#{is_read} where id=#{id}")
	void updateApplyRead(Apply apply);
}
