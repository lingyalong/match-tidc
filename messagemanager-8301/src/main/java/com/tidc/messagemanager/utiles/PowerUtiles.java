package com.tidc.messagemanager.utiles;

import com.tidc.api.pojo.Message;
import com.tidc.messagemanager.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassNmae PowerUtiles
 * @Description TODO
 * @Author 冯涛滔
 **/
@Component
public class PowerUtiles {
	@Autowired
	private MessageMapper messageMapper;
	public boolean msgAuthentication(Message message){
		Integer messagePower = messageMapper.getMessagePower(message);
		return messagePower!=null?true:false;
	}
}
