package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.interceptor.AuthCheckInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).excludePathPatterns("/login", "/loginProcess", "/agreement",
				"/agreementForm", "/signupForm", "/signupProcess", "/signupProcess2", "/findcheck", "/findid",
				"/findid2", "/findidProcess", "/findpwd", "/findpwdProcess", "/changepwd", "/changepwdProcess",
				"/resources/**", "/checkM_acctidDuplicate", "/checkM_emailDuplicate", "/api/**");
	}

	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("https://www.app-check.shop", "https://app-check.shop", "http://localhost:3000",
						"https://localhost:3000")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS").allowedHeaders("*")
				.allowCredentials(true).maxAge(3600);
	}
}