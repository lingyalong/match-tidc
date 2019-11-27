package com.tidc.api.fallback;

import com.tidc.api.controller.UserManagerApi;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * @ClassNmae UserManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
public class UserManagerFallbackFactory implements FallbackFactory<UserManagerApi> {
	public UserManagerApi create(Throwable throwable) {
		return new UserManagerApi() {


			public UserOV teacherRegister(Teacher teacher) {
				return null;
			}

			public UserOV userInfo(String email) {
				return null;
			}

			public UserOV teacherOpen(Teacher teacher) {
				return null;
			}

			public UserOV<List<Student>> listSchoolStudent(int id) {
				return null;
			}

			public UserOV studentRegister(Student student) {
				return null;
			}


			public UserOV teacherOpen(String email) {
				return null;
			}
		};
	}
}
