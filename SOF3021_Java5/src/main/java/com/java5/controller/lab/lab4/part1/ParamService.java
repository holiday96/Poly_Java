package com.java5.controller.lab.lab4.part1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

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

	public File save(String dataBase64, String path, String name) {
		String[] strings = dataBase64.split(",");
		String extension;
		switch (strings[0]) {
		case "data:image/jpeg;base64":
			extension = "jpeg";
			break;
		case "data:image/gif;base64":
			extension = "gif";
			break;
		case "data:image/png;base64":
			extension = "png";
			break;
		default:
			extension = "jpg";
			break;
		}
		byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
		String pathApp = application.getRealPath("/");
		File file = new File(pathApp + path + "/" + name + "." + extension);
		try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
			outputStream.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
