package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassNmae MessageManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface MessageManagerService {
	UserOV<List<Message>> checkMessage(String token);
	UserOV readMessage(int id);
	UserOV readMessageAll( String access_token);
	UserOV<List<Apply>> checkApply(String access_token);
	UserOV approvalApply(Apply apply);
}
