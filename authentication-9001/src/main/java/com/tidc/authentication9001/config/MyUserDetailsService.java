package com.tidc.authentication9001.config;

import com.tidc.authentication9001.mapper.UserMapper;
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
	private ClientDetailsService clientDetailsService;
	@Autowired
	private UserMapper userMapper;
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
		String[] power1 = {"Role_user"};
		com.tidc.api.pojo.user.User user = userMapper.login(email);

		power = org.apache.commons.lang.StringUtils.join(power1, ",");
		return returnUser(email,user.getPassword(),power);
	}
	public User returnUser(String email,String password,String power){
		return new User(email,password,
				true,true,true,true,
				AuthorityUtils.commaSeparatedStringToAuthorityList(power));
	}
}
