package com.tidc.usermanager.service;

import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassNmae RegisterService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface RegisterService {
	/**
	 * 注册老师账号
	 * @param teacher
	 * @return Data.email
	 */
	UserOV teacherRegister(Teacher teacher, String code);

	/**
	 * 注册学生账号
	 * @param student
	 * @param code
	 * @return
	 */
	UserOV studentRegister(@RequestBody Student student, @RequestParam("code") String code);
}
