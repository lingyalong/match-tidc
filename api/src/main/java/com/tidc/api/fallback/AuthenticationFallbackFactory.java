package com.tidc.api.fallback;

import com.tidc.api.controller.AuthenticationApi;
import feign.hystrix.FallbackFactory;

/**
 * @ClassNmae AuthenticationFallbackFactory
 * @Description TODO
 * @Author 冯涛滔
 **/
public class AuthenticationFallbackFactory  implements FallbackFactory<AuthenticationApi> {
	public AuthenticationApi create(Throwable throwable) {
		return new AuthenticationApi() {
			public Object login(String username, String password, String client_id, String client_secret, String grant_type) {
				return null;
			}

			public Object getUserInfo(String email) {
				return null;
			}
		};
	}
}
