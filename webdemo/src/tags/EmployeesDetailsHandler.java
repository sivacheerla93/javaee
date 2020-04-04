package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeesDetailsHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		JspFragment body = this.getJspBody();
		PageContext ctx = (PageContext) this.getJspContext();

		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees");
			crs.execute();

			while (crs.next()) {
				// create attributes in page context
				ctx.setAttribute("name", crs.getString("first_name"));
				ctx.setAttribute("salary", crs.getString("salary"));
				ctx.setAttribute("job", crs.getString("job_id"));

				// process body
				body.invoke(out);
			}

			crs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}