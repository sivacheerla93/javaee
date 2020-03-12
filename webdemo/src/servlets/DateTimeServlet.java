package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/datetime")
public class DateTimeServlet extends HttpServlet {
	int count = 0;

	@Override
	public void init(ServletConfig config) {
		String company = config.getInitParameter("company");
		System.out.println(company);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><h1>" + new Date() + "</h1></html>");
		out.println("<h3>" + ++count + "</h3");
	}

}