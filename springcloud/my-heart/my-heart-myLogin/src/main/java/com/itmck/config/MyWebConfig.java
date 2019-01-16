package com.itmck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.itmck.api.anno.RoleInterceptor;



@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public RoleInterceptor getRoleInterceptor() {
		
		return new RoleInterceptor();
	}
	
	
	/**
	 * 
	 * 	配置拦截器
	 * 	配置多个... 谁在上边谁先执行
	 * 	如下配置:执行顺序	3--1---2
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截器
		InterceptorRegistration interceptor3 = registry.addInterceptor(getRoleInterceptor());
		interceptor3.addPathPatterns("/**");//拦截所有路径
		interceptor3.excludePathPatterns("/index");//不拦截的路径
	}
}
