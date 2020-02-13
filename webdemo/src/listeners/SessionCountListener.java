package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCountListener implements ServletContextListener, HttpSessionListener {

	ServletContext ctx = null;

	public void sessionCreated(HttpSessionEvent arg0) {
		int count = (Integer) ctx.getAttribute("count");
		count++;
		ctx.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

		int count = (Integer) ctx.getAttribute("count");
		count--;
		ctx.setAttribute("count", count);

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		ctx = sce.getServletContext();
		ctx.setAttribute("count", 0);
	}

}