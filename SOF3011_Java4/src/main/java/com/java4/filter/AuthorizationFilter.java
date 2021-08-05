package com.java4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java4.dto.UserDTO;
import com.java4.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	@SuppressWarnings("unused")
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletRespone, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletRespone;
		String url = request.getRequestURI();
		if (url.startsWith("/admin")) {
			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
			if (user != null) {
				if (user.isRole()) {
					filterChain.doFilter(servletRequest, servletRespone);
				} else {
					response.sendRedirect(
							request.getContextPath() + "/login?message=" + "Not permission" + "&alert=warning");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login?&message=" + "Not login" + "&alert=warning");
			}
//		} else if (url.startsWith("/login") || url.startsWith("/register")) {
//			UserDTO user = (UserDTO) SessionUtil.getInstance().getValue(request, "USER");
//			if (user != null) {
//				response.sendRedirect(request.getContextPath() + "/home");
//			}
		} else {
			filterChain.doFilter(servletRequest, servletRespone);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
