package com.tidc.usermanager.mapper;

import com.tidc.api.pojo.user.UserDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassNmae UserDetailMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
@Repository
public interface UserDetailMapper {
	@Insert("INSERT INTO user_detail(detail_user_id,id_entity,telephone,school_name,school_id,department,major,student_number,position,brief,code,is_open)" +
			"VALUES(#{detail_user_id},#{id_entity},#{telephone},#{school_name},#{school_id},#{department},#{major},#{student_number},#{position},#{brief},#{code},#{is_open})")
	int InsertDetails(UserDetail userDetail);
	@Update("UPDATE user_detail set is_open = #{is_open} where id =  #{id}")
	int updateIsOpen(UserDetail userDetail);
	@Select("SELECT * FROM user_detail WHERE detail_user_id = #{id}")
	UserDetail getUserInfo(int id);
}
