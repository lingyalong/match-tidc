package com.tidc.api.fallback;

import com.tidc.api.controller.MessageManagerApi;
import com.tidc.api.pojo.Apply;
import com.tidc.api.pojo.Message;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * @ClassNmae MessageManagerFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class MessageManagerFallbackFactory implements FallbackFactory<MessageManagerApi> {
	public MessageManagerApi create(Throwable throwable) {
		return new MessageManagerApi() {
			public UserOV teacherApproveMessage(String schoolEmail, String teacherEmail) {
				return null;
			}

			public UserOV<List<Message>> checkMessage(String receiver_Message) {
				return null;
			}

			public UserOV readMessage(int id) {
				return null;
			}

			public UserOV readMessageAll(String receiver_email) {
				return null;
			}

			public UserOV<List<Apply>> checkApply(String acceptor_email) {
				return null;
			}

			public UserOV approvalApply(Apply apply) {
				return null;
			}

			public UserOV sendMessage(Message message) {
				return null;
			}
		};
	}
}
