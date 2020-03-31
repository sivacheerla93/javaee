package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "UploadServlet", urlPatterns = { "/upload" })
@MultipartConfig
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Part p1 = request.getPart("file");
			InputStream is = p1.getInputStream();

			Part p2 = request.getPart("filename");
			Scanner s = new Scanner(p2.getInputStream());
			String filename = s.nextLine();

			String outputfile = getServletContext().getRealPath(filename);
			FileOutputStream os = new FileOutputStream(outputfile);

			int ch = is.read();
			while (ch != -1) {
				os.write(ch);
				ch = is.read();
			}
			os.close();
			out.println("<h3>File uploaded successfully!</h3>");
		} finally {
			out.close();
		}
	}

}
