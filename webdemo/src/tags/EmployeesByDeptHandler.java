package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeesByDeptHandler extends SimpleTagSupport {
	private int deptno;

	// attribute deptno
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<h3>List Of Employee</h3>");
		out.println("<table border='1'><tr><th>First Name</th><th>Salary </th></tr>");
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from employees where department_id = ?");
			crs.setInt(1, deptno);
			crs.execute();

			while (crs.next()) {
				out.println("<tr><td>" + crs.getString("first_name") + "</td><td>" + crs.getString("salary")
						+ "</td></tr>");
			}

			out.println("</table>");
			crs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}