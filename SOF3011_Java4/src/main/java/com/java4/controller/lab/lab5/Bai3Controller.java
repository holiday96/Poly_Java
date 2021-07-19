package com.java4.controller.lab.lab5;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.utils.FormUtil;

@WebServlet(urlPatterns = { "/lab/5/bai3", "/lab/5/bai3/edit", "/lab/5/bai3/add" })
public class Bai3Controller extends HttpServlet {

	private static final long serialVersionUID = -5121834079327355960L;

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			UserDTO user = FormUtil.toModel(UserDTO.class, request);
			if (user.getType().equals("edit")) {
				user = userService.findById(user.getId());
				request.setAttribute("user", user);
			} else if (user.getType().equals("delete")) {
				userService.delete(user.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<UserDTO> list = userService.findAll();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab5/bai3.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDTO user = FormUtil.toModel(UserDTO.class, request);
		String uri = request.getRequestURI();
		if (uri.contains("add")) {
			userService.save(user);
			request.setAttribute("message", "Thêm mới thành công");
		} else if(uri.contains("edit")) {
			userService.update(user);
			request.setAttribute("message", "Cập nhật thành công");
		}

		List<UserDTO> list = userService.findAll();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab5/bai3.jsp");
		rd.forward(request, response);
	}
}
