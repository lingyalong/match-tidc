package com.tidc.authentication9001.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNmae DruidConfig
 * @Description TODO
 * @Author 冯涛滔
 **/
@Configuration
public class DruidConfig {
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druid(){
		return new DruidDataSource();
	}
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String,String> map = new HashMap<>();

		map.put("loginUsername","root");
		map.put("loginPassword","546100");
		servletRegistrationBean.setInitParameters(map);
		return servletRegistrationBean;
	}
}
