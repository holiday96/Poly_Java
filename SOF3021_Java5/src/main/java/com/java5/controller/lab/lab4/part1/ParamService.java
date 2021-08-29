package com.java5.controller.lab.lab4.part1;

import java.io.File;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ServletContext application;

	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		if (value.isBlank()) {
			return defaultValue;
		}
		return value;
	}

	public int getInt(String name, Integer defaultValue) {
		String value = request.getParameter(name);
		if (value.isBlank()) {
			return defaultValue;
		}
		return Integer.valueOf(value);
	}

	public double getDouble(String name, Double defaultValue) {
		String value = request.getParameter(name);
		if (value.isBlank()) {
			return defaultValue;
		}
		return Double.valueOf(value);
	}

	public boolean getBoolean(String name, Boolean defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}
		return Boolean.valueOf(true);
	}

	public Date getDate(String name, String pattern) throws ParseException {
		String date = request.getParameter(name);
		if (!date.isBlank()) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date value = sdf.parse(date);
			return value;
		}
		return null;
	}

	public File save(MultipartFile multipartFile, String path) {
		try {
			if (!multipartFile.isEmpty()) {
				String pathApp = application.getRealPath("/");
				File file = new File(pathApp + path + "/" + multipartFile.getOriginalFilename());
				multipartFile.transferTo(Path.of(file.getAbsolutePath()));
				return file;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
