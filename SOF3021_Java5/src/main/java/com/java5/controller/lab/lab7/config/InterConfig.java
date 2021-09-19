package com.java5.controller.lab.lab7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.java5.controller.lab.lab7.interceptor.AuthInterceptor;
import com.java5.controller.lab.lab7.interceptor.GlobalInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor auth;

	@Autowired
	private GlobalInterceptor global;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String prefixURI = "/lab/lab7";
		registry.addInterceptor(global)
				.addPathPatterns("/**")
				.excludePathPatterns("/assets/**");

		registry.addInterceptor(auth)
				.addPathPatterns(prefixURI + "/account/edit", 
								prefixURI + "/account/chgpwd", 
								prefixURI + "/oder/**",
								prefixURI + "/admin/**")
				.excludePathPatterns("/assets/**", prefixURI + "/admin/home/index");
	}
}
