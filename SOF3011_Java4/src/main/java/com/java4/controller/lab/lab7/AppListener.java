package com.java4.controller.lab.lab7;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements HttpSessionListener, ServletContextListener {

	ServletContext context;
	HttpSession session;
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
		context = e.getServletContext();
		Integer visitors = 0;
		try {
			String path = context.getRealPath("/visitors.txt");
			List<String> lines = Files.readAllLines(Paths.get(path));
			visitors = Integer.valueOf(lines.get(0));
		} catch (Exception e2) {
			visitors = 0;
		}
		context.setAttribute("visitors", visitors);
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		context = e.getServletContext();
		Integer visitors = (Integer) context.getAttribute("visitors");
		try {
			String path = context.getRealPath("/visitors.txt");
			byte[] data = String.valueOf(visitors).getBytes();
			Files.write(Paths.get(path), data, StandardOpenOption.CREATE);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		session = e.getSession();
		context = session.getServletContext();
		Integer visitors = (Integer) context.getAttribute("visitors");
		context.setAttribute("visitors", visitors + 1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {

	}
}
