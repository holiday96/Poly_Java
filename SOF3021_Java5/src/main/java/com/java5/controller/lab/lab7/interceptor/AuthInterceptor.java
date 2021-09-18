package com.java5.controller.lab.lab7.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user")==null) {
			request.getSession().setAttribute("secureURI", request.getRequestURI());
			response.sendRedirect("/lab/lab7/auth/login");
			return false;
		}
		return true;
	}
}
