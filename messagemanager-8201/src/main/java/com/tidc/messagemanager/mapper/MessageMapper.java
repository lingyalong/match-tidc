package com.tidc.messagemanager.mapper;

import com.tidc.messagemanager.pojo.Message;
import org.apache.ibatis.annotations.Insert;

/**
 * @ClassNmae MessageMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface MessageMapper {
	@Insert("insert into message(receiver_email,message,head,is_read) values(#{receiver_email},#{message},#{head},#{is_read})")
	public void insertMessage(Message message);
}
