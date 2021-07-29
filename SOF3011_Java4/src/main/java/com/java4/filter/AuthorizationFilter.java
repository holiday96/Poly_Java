package com.java4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletRespone, FilterChain filterChain)
			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse respone = (HttpServletResponse) servletRespone;
//		String url = request.getRequestURI();
//		if (url.startsWith("/admin")) {
//			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
//			if (model != null) {
//				if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
//					filterChain.doFilter(servletRequest, servletRespone);
//				} else if (model.getRole().getCode().equals(SystemConstant.USER)) {
//					respone.sendRedirect(
//							request.getContextPath() + "/login?action=login&message=not_permission&alert=warning");
//				}
//			} else {
//				respone.sendRedirect(request.getContextPath() + "/login?action=login&message=not_login&alert=warning");
//			}
//		} else {
			filterChain.doFilter(servletRequest, servletRespone);
//		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
