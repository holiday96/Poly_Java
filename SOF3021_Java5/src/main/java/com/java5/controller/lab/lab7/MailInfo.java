package com.java5.controller.lab.lab7;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {

	private String from;
	private String to;
	private String subject;
	private String body;
	private String[] cc;
	private String[] bcc;
	private List<String> paths;

	public MailInfo(String to, String subject, String body) {
		this.from = "Lab 7 - Spring Boot<java5@fpt.edu.vn>"; //reply to
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}
