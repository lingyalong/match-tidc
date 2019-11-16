package com.tidc.authentication9001.config;

import com.tidc.api.pojo.*;
import com.tidc.authentication9001.mapper.SchoolMapper;
import com.tidc.authentication9001.mapper.StatusMapper;
import com.tidc.authentication9001.mapper.StudentMapper;
import com.tidc.authentication9001.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.List;

/**
 * @ClassNmae MyUserDetailsService
 * @Description TODO
 * @Author 冯涛滔
 **/
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	SchoolMapper schoolMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	ClientDetailsService clientDetailsService;
	@Autowired
	StatusMapper statusMapper;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email+"正在登录");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
		if(authentication==null){
			ClientDetails clientDetails = clientDetailsService.loadClientByClientId(email);
			//获取app信息
			if(clientDetails!=null){
				//密码
				String clientSecret = clientDetails.getClientSecret();
				return new User(email,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
			}
		}
		String power = "";
		String password = "222";
		List<String> power1 = null;
		Integer status = statusMapper.getStatus(email);
		//如果是未认证的账号登录可以抛一个自定义异常或则 那四个true随便选一个抛false
		switch (status){
			case 1:
				Student student = studentMapper.chickEmail(email);
				power1 = studentMapper.listPower(student.getId());
				password = student.getPassword();
				break;
			case 2:
				Teacher teacher = teacherMapper.chickEmail(email);
				power1 = teacherMapper.listPower(teacher.getId());
				password = teacher.getPassword();
				break;
			case 3:
				School school = schoolMapper.chickEmail(email);
				power1 = schoolMapper.listPower(school.getId());
				power = org.apache.commons.lang.StringUtils.join(power1.toArray(), ",");
				returnUser(email,school.getPassword(),power);
				password = school.getPassword();
				break;
		}
		power = org.apache.commons.lang.StringUtils.join(power1.toArray(), ",");
		return returnUser(email,password,power);
	}
	public User returnUser(String email,String password,String power){
		return new User(email,password,
				true,true,true,true,
				AuthorityUtils.commaSeparatedStringToAuthorityList(power));
	}
}
