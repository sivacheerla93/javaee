package javamail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet(name = "SendMailServlet", urlPatterns = { "/sendmail" })
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String to = request.getParameter("toaddress");
		String from = request.getParameter("fromaddress");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");

		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setDataHandler(new DataHandler(body, "text/html"));
			msg.setSentDate(new Date());
			msg.setSubject(subject);
			Transport.send(msg);
			out.println("\n Mail was sent successfully.");
		} catch (Exception ex) {
			out.println("Error --> " + ex.getMessage());
		}

	}

}
