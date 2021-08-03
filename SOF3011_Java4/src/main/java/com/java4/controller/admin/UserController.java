package com.java4.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.UserDTO;
import com.java4.service.IUserService;

@WebServlet(urlPatterns = { "/admin/user", "/admin/user/edit" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1672833033433878897L;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserDTO> users = userService.findAll();
		String uri = request.getRequestURI();
		String id = request.getParameter("id");
		String view = "";
		if (uri.contains("edit")) {
			if (id != null) {
				UserDTO user = userService.findOne(Long.valueOf(id));
				request.setAttribute("user", user);
			}
			view = "/views/admin/user/edit.jsp";
		} else {
			request.setAttribute("users", users);
			view = "/views/admin/user/list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
