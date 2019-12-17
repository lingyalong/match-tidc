package com.tidc.consumer8001.service;

import com.tidc.api.pojo.UserOV;

import javax.servlet.http.HttpServletRequest;
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
	 * @param req
	 * @return
	 */
	UserOV<List<Student>> listSchoolStudent(HttpServletRequest req);

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

	/**
	 * 关闭老师的权限
	 * @param teacher email
	 * @return
	 */
	UserOV closeTeacher(Teacher teacher,HttpServletRequest req);
}
