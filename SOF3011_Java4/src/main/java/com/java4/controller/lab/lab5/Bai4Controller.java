package com.java4.controller.lab.lab5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.controller.lab.lab3.CookieUtils;
import com.java4.controller.lab.lab3.EmailUtils;
import com.java4.utils.FormUtil;

@WebServlet(urlPatterns = { "/lab/5/bai4", "/lab/5/bai4/signin", "/lab/5/bai4/signup", "/lab/5/bai4/edit-profile",
		"/lab/5/bai4/signout", "/lab/5/bai4/forgot-password", "/lab/5/bai4/change-password" })
public class Bai4Controller extends HttpServlet {

	private static final long serialVersionUID = -3618075838592636709L;

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("username", CookieUtils.get("username", request));
		request.setAttribute("password", CookieUtils.get("password", request));
		request.setAttribute("remember", CookieUtils.get("remember", request));

		String uri = request.getRequestURI();
		if (uri.contains("signout")) {
			request.getSession().invalidate();
		} else if (uri.contains("forgot-password")) {
			try {
				String email = request.getParameter("email");
				UserDTO user = userService.findByEmail(email);
				EmailUtils.sendEmail(email, "Retrieve Password",
						"Your Profile:\nUsername: " + user.getId() + "\nPassword: " + user.getPassword()
								+ "\nFullname: " + user.getFullname() + "\nRole: "
								+ (user.isAdmin() ? "Admin" : "User"));
			} catch (Exception e) {
				request.setAttribute("message", "Email is not exists!");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab5/bai4.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String remember = request.getParameter("remember");
		UserDTO user = FormUtil.toModel(UserDTO.class, request);
		String uri = request.getRequestURI();
		if (uri.contains("signin")) {
			try {
				user = userService.findOne(user.getId(), user.getPassword());
				request.getSession().setAttribute("model", user);
				request.getSession().setMaxInactiveInterval(60 * 15);
				request.setAttribute("message", "Login success");

				int hours = (remember == null) ? 0 : 1;
				CookieUtils.add("username", user.getId(), hours, response);
				CookieUtils.add("password", user.getPassword(), hours, response);
				CookieUtils.add("remember", remember, hours, response);
			} catch (Exception e) {
				request.setAttribute("message", "Username or Password wrong!");
			}
		} else if (uri.contains("signup")) {
			String id = userService.save(user);
			if (id != null) {
				request.setAttribute("message", "Sign Up success!");
			} else {
				request.setAttribute("message", "Failed! Username was exists!");
			}
		} else if (uri.contains("change-password")) {
			userService.update(user);
			request.setAttribute("model", user);

			int hours = (remember == null) ? 0 : 1;
			CookieUtils.add("username", user.getId(), hours, response);
			CookieUtils.add("password", user.getPassword(), hours, response);
			CookieUtils.add("remember", remember, hours, response);
		} else if (uri.contains("edit-profile")) {
			try {
				userService.update(user);
				request.setAttribute("model", user);

				int hours = (remember == null) ? 0 : 1;
				CookieUtils.add("username", user.getId(), hours, response);
				CookieUtils.add("password", user.getPassword(), hours, response);
				CookieUtils.add("remember", remember, hours, response);
			} catch (Exception e) {
				request.setAttribute("message", "Failed! Username was exists!");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab5/bai4.jsp");
		rd.forward(request, response);
	};
}
