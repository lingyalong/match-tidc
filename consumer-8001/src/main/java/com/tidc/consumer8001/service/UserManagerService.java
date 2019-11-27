package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassNmae UserManagerService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface UserManagerService {
	/**
	 * 注册一个老师账号
	 * @param teacher
	 * @return
	 */
	UserOV teacherRegister(Teacher teacher);

	/**
	 * 根据学校id查询该学校的所有学生
	 * @param token
	 * @return
	 */
	UserOV<List<Student>> listSchoolStudent(String token);

	/**
	 * 注册学生账号
	 * @param student
	 * @return
	 */
	UserOV studentRegister(Student student);

	/**
	 * 使用email查看student信息
	 * @param email
	 * @return
	 */
	UserOV<Student> getStudent(String email);
}
