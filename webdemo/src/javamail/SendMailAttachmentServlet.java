package javamail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailAttachmentServlet
 */
@WebServlet(urlPatterns = { "/sendfile" }, name = "SendMailAttachmentServlet")
public class SendMailAttachmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String to = "contact@sivacheerla.com";
		String from = "info@sivacheerla.com";
		String subject = "ship";
		String body = "Here is a ship...";
		String filename = "ship.jpg";

		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(body);
			MimeBodyPart mbp2 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(getServletContext().getRealPath(filename));
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName(fds.getName());
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);
			msg.setContent(mp);
			Transport.send(msg);
			out.println("<h4>Mail has been sent with attachment.</h4>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
