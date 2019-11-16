package com.tidc.api.fallback;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

/**
 * @ClassNmae UserManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
public class UserManagerFallbackFactory implements FallbackFactory<UserManagerApi> {
	public UserManagerApi create(Throwable throwable) {
		return new UserManagerApi() {
			public UserOV teacherRegister(Teacher teacher, String code) {
				return null;
			}

			public UserOV userInfo(String email) {
				return null;
			}

			public UserOV teacherOpen(Teacher teacher) {
				return null;
			}

			public UserOV teacherOpen(String email) {
				return null;
			}
		};
	}
}
