package com.java4.controller.lab.lab3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

@WebServlet(urlPatterns = { "/lab/3/bai3" })
@MultipartConfig
public class Bai3Controller extends HttpServlet {

	private static final long serialVersionUID = -6939678285731249702L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai3.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		File dir = new File(request.getServletContext().getRealPath("/files"));
		if (!dir.exists()) {
			dir.mkdir();
		}

		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("yyyy-MM-dd");
			ConvertUtils.register(dtc, Date.class);

			Staff staff = new Staff();
			BeanUtils.populate(staff, request.getParameterMap());

			Part photo = request.getPart("photo-file");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			staff.setAvatar(photoFile.getName());

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			request.setAttribute("date", sdf.format(staff.getDate()));
			request.setAttribute("gender", staff.isGender() ? "Nam" : "Nữ");
			request.setAttribute("married", staff.isMarried() ? "Đã kết hôn" : "Chưa kết hôn");
			if (staff.getHobbies() != null) {
				StringBuilder listHobby = new StringBuilder();
				for (String i : staff.getHobbies()) {
					listHobby.append(i + ", ");
				}
				request.setAttribute("hobbies", listHobby.substring(0, listHobby.length() - 2));
			} else {
				request.setAttribute("hobbies", "Không có");
			}

			request.setAttribute("staff", staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/lab/lab3/bai3.jsp");
		rd.forward(request, response);
	}
}
