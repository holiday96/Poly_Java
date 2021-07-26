package com.java4.controller.lab.lab7;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class RRSharer {
	
	@SuppressWarnings("unchecked")
	private static Map<Long, HttpServletRequest> requestMap = new HashedMap();
	@SuppressWarnings("unchecked")
	private static Map<Long, HttpServletResponse> responseMap = new HashedMap();
	
	public static void add(HttpServletRequest request, HttpServletResponse response) {
		requestMap.put(Thread.currentThread().getId(), request);
		responseMap.put(Thread.currentThread().getId(), response);
	}
	
	public static void remove() {
		requestMap.remove(Thread.currentThread().getId());
		responseMap.remove(Thread.currentThread().getId());
	}
	
	public static HttpServletRequest request() {
		return requestMap.get(Thread.currentThread().getId());
	}
	
	public static HttpServletResponse response() {
		return responseMap.get(Thread.currentThread().getId());
	}
}
