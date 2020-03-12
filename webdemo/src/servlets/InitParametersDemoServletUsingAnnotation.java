package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParametersDemoServlet
 */
@WebServlet(urlPatterns = { "/initparamsdemowithannotation" }, initParams = {
		@WebInitParam(name = "fname", value = "Siva"), @WebInitParam(name = "lname", value = "Cheerla") })
public class InitParametersDemoServletUsingAnnotation extends HttpServlet {
	String fname;
	String lname;
	int counter = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		counter++;
		out.println("<h1>" + fname + " " + lname + ". </h1><h3>Displayed for " + counter + " time(s)" + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		fname = config.getInitParameter("fname");
		lname = config.getInitParameter("lname");
	}

}
