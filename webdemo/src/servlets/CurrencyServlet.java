package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyServlet
 */
@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {
	public static double RATE = 66;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String samount = request.getParameter("amount");
		if (samount != null) {
			double amount = Double.parseDouble(samount);
			double usd = amount / RATE;
			out.println(" USD = " + usd);
		} else {
			out.println("<h3>Amount is required!</h3>");
		}
	}

}
