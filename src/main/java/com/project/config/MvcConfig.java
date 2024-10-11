package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.interceptor.AuthCheckInterceptor;


@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).excludePathPatterns("/login","/loginProcess","/agreement","/agreementForm","/signupForm","/signupProcess","/findcheck","/findid","findidProcess","/findpwd","/findpwdProcess","/changepwd","/resources/**");
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
}