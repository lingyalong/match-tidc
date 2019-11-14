package com.tidc.api.fallback;

import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

/**
 * @ClassNmae MessageManagerFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class MessageManagerFallbackFactory implements FallbackFactory<MessageManagerApi> {
	public MessageManagerApi create(Throwable throwable) {
		return new MessageManagerApi() {
			public UserOV teacherApprove(String schoolEmail, String teacherEmail) {
				return null;
			}
		};
	}
}
