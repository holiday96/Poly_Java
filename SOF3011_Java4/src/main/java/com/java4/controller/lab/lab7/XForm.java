package com.java4.controller.lab.lab7;

import static com.java4.controller.lab.lab7.RRSharer.request;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

public class XForm {

	/**
	 * Check parameter exist
	 * 
	 * @param name
	 * @return
	 */
	public static boolean exist(String name) {
		return request().getParameter(name) != null;
	}

	/**
	 * Read String from parameter of form
	 * 
	 * @param name,   parameter of form
	 * @param defval, default value
	 * @return
	 */
	public static String getString(String name, String defval) {
		String value = request().getParameter(name);
		return value == null ? defval : value;
	}

	/**
	 * Read Integer from parameter of form
	 * 
	 * @param name,   parameter of form
	 * @param defval, default value
	 * @return
	 */
	public static int getInt(String name, int defval) {
		String value = getString(name, String.valueOf(defval));
		return Integer.parseInt(value);
	}

	/**
	 * Read Double from parameter of form
	 * 
	 * @param name,   parameter of form
	 * @param defval, default value
	 * @return
	 */
	public static double getDouble(String name, double defval) {
		String value = getString(name, String.valueOf(defval));
		return Double.parseDouble(value);
	}

	/**
	 * Read Boolean from parameter of form
	 * 
	 * @param name,   parameter of form
	 * @param defval, default value
	 * @return
	 */
	public static boolean getBoolean(String name, boolean defval) {
		String value = getString(name, String.valueOf(defval));
		return Boolean.parseBoolean(value);
	}

	/**
	 * Read time from parameter of form
	 * 
	 * @param name,   parameter of form
	 * @param defval, default value
	 * @return
	 */
	public static Date getDate(String name, Date defval) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = getString(name, sdf.format(defval));
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			return defval;
		}
	}

	/**
	 * Save the uploaded file to a folder with a unique name
	 * 
	 * @param name,   parameter of form
	 * @param folder, name of folder
	 * @return
	 */
	public static File save(String name, String folder) {
		File dir = new File(request().getServletContext().getRealPath(folder));
		if (!dir.exists()) {
			dir.mkdir();
		}
		try {
			Part part = request().getPart(name);
			if (part != null && part.getSize() > 0) {
				String fn = System.currentTimeMillis() + part.getSubmittedFileName();
				String fileName = Integer.toHexString(fn.hashCode()) + fn.substring(fn.lastIndexOf("."));
				File file = new File(dir, fileName);
				part.write(file.getAbsolutePath());
				return file;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dir;
	}

	/**
	 * Read form parameter values into bean's properties of the same name
	 * 
	 * @return Bean contains form data
	 */
	public static <T> T getBean(Class<T> clazz) {
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("MM/dd/yyyy");
		ConvertUtils.register(dtc, Date.class);
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, request().getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
