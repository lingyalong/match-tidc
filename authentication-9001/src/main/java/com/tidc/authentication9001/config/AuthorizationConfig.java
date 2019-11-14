package com.tidc.authentication9001.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ClassNmae AuthorizationConfig
 * @Description TODO
 * @Author 冯涛滔
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Primary
	@Bean
	public TokenStore tokenStore(){

		return new RedisTokenStore(redisConnectionFactory);
	}
	@Primary
	@Bean
	public AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		//access_token 60分钟
		defaultTokenServices.setAccessTokenValiditySeconds(60*60);
		// refresh_token 3天
		defaultTokenServices.setRefreshTokenValiditySeconds(60*60*24*3);
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setReuseRefreshToken(false);
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("TIDC")
				.secret(passwordEncoder.encode("computer"))
				.scopes("all")
				.accessTokenValiditySeconds(60*60*10)//访问令牌有效期
				.refreshTokenValiditySeconds(60*60*72)//刷新令牌有效期
				.authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token", "password","/oauth/check_token");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
				.tokenServices(tokenServices())
				.tokenStore(tokenStore())
				.authenticationManager(authenticationManager);
	}
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		oauthServer.allowFormAuthenticationForClients();
	}
}
