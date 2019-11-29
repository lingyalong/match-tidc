package com.tidc.api.fallback;

import com.tidc.api.controller.RabbitManagerApi;
import com.tidc.api.pojo.Message;
import feign.hystrix.FallbackFactory;

import java.util.List;
import java.util.Map;

/**
 * @ClassNmae RabbitFallbcakFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class RabbitManagerFallbcakFactory implements FallbackFactory<RabbitManagerApi> {
	public RabbitManagerApi create(Throwable throwable) {
		return new RabbitManagerApi() {
			public void sendMessage(Message message) {

			}

			public void sendListMessage(Map map) {

			}

			public void deleteFile(String path) {

			}

			public void deleteWorkANdTeam(int contestId) {

			}

			public void sendListMessage(List<Message> list) {

			}
		};
	}
}
