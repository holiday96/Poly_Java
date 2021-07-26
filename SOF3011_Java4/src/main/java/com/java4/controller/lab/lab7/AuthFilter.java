package com.java4.controller.lab.lab7;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab5.UserDTO;

@WebFilter({ "/lab/5/bai3", "/lab/5/bai3/edit", "/lab/5/bai3/add" })
public class AuthFilter implements HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = request.getRequestURI();
		UserDTO user = (UserDTO) request.getSession().getAttribute("model");
		String error = "";
		if (user == null) {
			error = response.encodeURL("Please login to access!");
		} else if (!user.isAdmin() && uri.contains("/lab/5/bai3")) {
			error = response.encodeURL("Permission denied!");
		}
		if (!error.isEmpty()) {
			request.setAttribute("error", error);
			response.sendRedirect("/lab/5/bai4?error=" + response.encodeURL(error));
		} else {
			chain.doFilter(request, response);
		}
	}
}
