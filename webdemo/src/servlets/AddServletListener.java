package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AddServletListener
 *
 */
@WebListener()
public class AddServletListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String[] urlPatterns = new String[] { "/dynamic" };
		ServletContext context = sce.getServletContext();
		ServletRegistration sr = context.addServlet("DynamicServlet", "servlets.DynamicServlet");
		sr.addMapping(urlPatterns);
	}

}
