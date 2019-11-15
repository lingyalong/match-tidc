package com.tidc.messagemanager.mapper;

import com.tidc.api.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassNmae MessageMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface MessageMapper {
	@Insert("insert into message(receiver_email,message,head,is_read) values(#{receiver_email},#{message},#{head},#{is_read})")
	public void insertMessage(Message message);
	@Select("select * from message where receiver_email=#{receiver}")
	public List<Message> listMessage(String receiver_email);
}
