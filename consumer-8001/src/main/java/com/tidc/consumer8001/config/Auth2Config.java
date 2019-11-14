package com.tidc.consumer8001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @ClassNmae Auth2Config
 * @Description TODO
 * @Author 冯涛滔
 **/
@Configuration
@EnableResourceServer//这个配置相当于securityConfig
public class Auth2Config extends ResourceServerConfigurerAdapter {
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//		super.configure(resources);
//		resources.authenticationEntryPoint(new LLGAuthenticationEntryPoint());
//
//	}


	@Primary
	@Bean
	public RemoteTokenServices tokenServices() {
		final RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:9001/oauth/check_token");
		tokenService.setClientId("TIDC");
		tokenService.setClientSecret("computer");
		return tokenService;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//全部放行
		http.sessionManagement()
				.and().cors()
				.and().csrf().disable();
		http.authorizeRequests().anyRequest().permitAll();

	}


}