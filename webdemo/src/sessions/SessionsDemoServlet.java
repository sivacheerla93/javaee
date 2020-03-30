package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionsDemoServlet
 */
@WebServlet("/sessionsdemo")
public class SessionsDemoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String act = request.getParameter("act");
		String key, value;
		key = request.getParameter("key");
		HttpSession s = request.getSession();
		if (act.equals("Add")) {
			value = request.getParameter("value");
			s.setAttribute(key, value);
		} else {
			s.removeAttribute(key);
		}
		out.println("<h3>Available Session Variables</h3>");
		Enumeration e = s.getAttributeNames();

		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			value = s.getAttribute(key).toString();
			out.println(key + " : " + value + "<br />");
		}
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

}
