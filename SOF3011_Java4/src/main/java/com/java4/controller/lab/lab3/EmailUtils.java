package com.java4.controller.lab.lab3;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
	public static void sendEmail(String to, String subject, String message)
			throws AddressException, MessagingException {
		System.out.println("prepare sending");
		
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		String username = "holiday08071996@gmail.com";
		String password = "Boyqet10";

		// creates a new session with an authenticator
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message msg = prepareMessage(session, username, to, subject, message);
		
		// sends the e-mail
		Transport.send(msg);
		System.out.println("send success");
	}

	private static Message prepareMessage(Session session, String username, String to, String subject, String message) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			InternetAddress[] toAddresses = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(message);
			return msg;
		} catch (Exception e) {
			Logger.getLogger(EmailUtils.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
