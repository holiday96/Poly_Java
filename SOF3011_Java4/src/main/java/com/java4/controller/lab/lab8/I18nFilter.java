package com.java4.controller.lab.lab8;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab7.HttpFilter;

@WebFilter("/*")
public class I18nFilter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String lang = request.getParameter("lang");
		if (lang != null) {
			request.getSession().setAttribute("lang", lang);
		}
		chain.doFilter(request, response);
	}
}
