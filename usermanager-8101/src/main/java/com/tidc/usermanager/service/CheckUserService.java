package com.tidc.usermanager.service;


import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.UserOV;
import org.springframework.web.bind.annotation.PathVariable;

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
	UserOV userInfo(String email);

	/**
	 * 根据学校id查询这个学校的所有学生
	 * @param id
	 * @return
	 */
	UserOV<List<Student>> listSchoolStudent( int id);
}
