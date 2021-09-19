package com.java5.controller.lab.lab7.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.java5.controller.lab.lab4.part1.SessionService;
import com.java5.controller.lab.lab5.entity.Lab5AccountEntity;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionService session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String prefixURI = "/lab/lab7";
		String uri = request.getRequestURI();
		Lab5AccountEntity user = session.get("user");

		String error = "";
		if (user == null) {
			error = "Please login!";
		} else if (!user.getAdmin() && uri.startsWith(prefixURI + "/admin/")) {
			error = "Access denied!";
		}
		if (error.length() > 0) {
			session.set("security-uri", uri);
			response.sendRedirect(prefixURI + "/account/login?error=" + error);
			return false;
		}
		return true;
	}
}
