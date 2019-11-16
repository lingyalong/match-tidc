package com.tidc.contest8401.mapper;

import com.tidc.api.pojo.Contest;
import org.apache.ibatis.annotations.Insert;

/**
 * @ClassNmae ContestMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface ContestMapper {
	@Insert("insert into contest(name,domain,is_mark,is_anonymous,is_exam,is_automation,is_money,brief,start,over,test_id,url,logo,school_id,number,money) values(#{name},#{domain},#{is_mark},#{is_anonymous},#{is_exam},#{is_automation},#{is_money},#{brief},#{start},#{over},#{test_id},#{url},#{logo},#{school_id},#{number},#{money})")
	void insetContest(Contest contest);
}
