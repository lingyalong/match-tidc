package com.tidc.consumer8001.service;

import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;

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
	 * @param code
	 * @return
	 */
	UserOV teacherRegister(Teacher teacher,String code);

	/**
	 * 根据学校id查询该学校的所有学生
	 * @param id
	 * @return
	 */
	UserOV<List<Student>> listSchoolStudent(int id);
}
