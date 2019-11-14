package com.tidc.consumer8001.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @ClassNmae Oauth2ResourceServerConfig
 * @Description TODO 为了开启方法上的安全配置
 * @Author 冯涛滔
 **/

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class Oauth2ResourceServerConfig extends GlobalMethodSecurityConfiguration {
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler()
	{
		OAuth2MethodSecurityExpressionHandler oAuth2MethodSecurityExpressionHandler = new OAuth2MethodSecurityExpressionHandler();
		return oAuth2MethodSecurityExpressionHandler;
	}
//	@Autowired
//	CustomMetadataSource metadataSource;
//	@Autowired
//	UrlAccessDecisionManager urlAccessDecisionManager;
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//					@Override
//					public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//						o.setSecurityMetadataSource(metadataSource);
//						o.setAccessDecisionManager(urlAccessDecisionManager);
//						return o;
//					}
//				})
//				.and().csrf().disable();
////                權限不足的控制器
//
//	}

}

