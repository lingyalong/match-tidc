package com.tidc.messagemanager.mapper;

import com.tidc.api.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassNmae MessageMapper
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface MessageMapper {
	@Insert("insert into message(receiver_email,message,head,is_read) values(#{receiver_email},#{message},#{head},#{is_read})")
	int insertMessage(Message message);
	@Select("select * from message where receiver_email=#{receiver}")
	List<Message> listMessage(String receiver_email);
	@Update("update message set is_read=1 where id=#{id}")
	void updateMessageRead(int id);
	@Update("update message set is_read=1 where receiver_email=#{value}")
	void updateMessageReadAll(String email);
	@Select("select id from message where receiver_email=#{receiver_emial} and id=#{id}")
	Integer getMessagePower(Message message);
}
