package com.tidc.api.controller;

import com.tidc.api.fallback.UserManagerFallbackFactory;
import com.tidc.api.pojo.Student;
import com.tidc.api.pojo.Teacher;
import com.tidc.api.pojo.UserOV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNmae UserManagerApi
 * @Description TODO
 * @Author 冯涛滔
 **/
@FeignClient(value = "USERMANAGER",fallbackFactory = UserManagerFallbackFactory.class)
public interface UserManagerApi {
	@RequestMapping(value = "/teacher/register",method = RequestMethod.POST)
	UserOV teacherRegister(@RequestBody Teacher teacher);

	@RequestMapping(value = "/user/info",method = RequestMethod.GET)
	UserOV userInfo(@RequestParam("email") String email);

	@RequestMapping(value = "/teacher/open",method = RequestMethod.PUT)
	UserOV teacherOpen(@RequestBody  Teacher teacher);

	@RequestMapping(value = "/school/student/{id}",method = RequestMethod.GET)
	UserOV<List<Student>> listSchoolStudent(@PathVariable("id") int id);

	@RequestMapping(value = "/student/register",method = RequestMethod.POST)
	UserOV studentRegister(@RequestBody Student student);

	@RequestMapping(value = "/list/student/email",method = RequestMethod.GET)
	UserOV<List<String>> listStudentEmail(@RequestParam("list") List<Integer> list);
}
