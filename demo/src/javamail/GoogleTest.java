package javamail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GoogleTest {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public static void main(String args[]) throws Exception {

		// Security.addProvider(new Provider());
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username", "abc");
			}
		});

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("username@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("enduser@yahoo.com"));
		msg.setSubject("Testing JavaMail");
		msg.setText("A Simple Mail For Testing Purpose");
		Transport.send(msg);
		System.out.println("Sucessfully Sent Successfully");
	} // end of main
}