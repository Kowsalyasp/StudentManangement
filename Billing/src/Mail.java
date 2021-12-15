import java.net.Inet4Address;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	static String recipient = "pandiarajkumar8@gmail.com";
	static String sender = "devidurga201299@gmail.com";
	static String password = "deepika@12345";
	static String subject = "Holiday Tracker";
	static String message;
	public static void sendMail(String sender, String password, String recipient, String subject, String body) {

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("spkowsalya7@gmail.com", "deepika@12345");
			}

		});

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(sender));

			message.addRecipient(Message.RecipientType.TO, new Inet4Address());

			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
			System.out.println("Mail sent successfully...");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

