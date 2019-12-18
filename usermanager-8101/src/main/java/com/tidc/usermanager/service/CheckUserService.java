package com.tidc.usermanager.service;


import com.tidc.api.pojo.UserOV;
import com.tidc.api.pojo.user.User;

import java.util.List;

/**
 * @ClassNmae CheckUserService
 * @Description TODO
 * @Author 冯涛滔
 **/
public interface CheckUserService {
	/**
	 *
	 * @param email
	 * @return 根据邮箱号返回用户详细信息
	 */
	UserOV<User> userInfo(String email);

	/**
	 * 根据学校id查询这个学校的所有学生
	 * @param id
	 * @return
	 */
	UserOV<List<User>> listSchoolStudent( int id);

	/**
	 * 使用学生id查询他们的email
	 * @param list
	 * @return
	 */
	UserOV<List<String>> listStudentEmail(List<Integer> list);

	/**
	 * 使用email查询学生
	 * @param email
	 * @return
	 */
	UserOV<Student> getStudent(String email);
}
