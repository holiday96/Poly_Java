package com.java4.controller.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/lab/2/bai4" })
public class Lab2Bai4Controller extends HttpServlet {

	private static final long serialVersionUID = 5979727585524443455L;
	
	int count;
	Path path = Paths.get("C:/Users/XuShiTa/git/Poly_Java/SOF3011_Java4/src/main/resources/count.txt");

	@Override
	public void init() throws ServletException {
		try {
			count=Integer.parseInt(Files.readAllLines(path).get(0));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab2bai4.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void destroy() {
		try {
			Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
