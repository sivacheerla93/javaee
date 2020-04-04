package tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import servlets.DBUtilOracle;

public class JobTagHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext ctx = (PageContext) getJspContext();
		JspFragment body = getJspBody();
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from jobs");
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				ctx.setAttribute("id", rs.getString("job_id"));
				ctx.setAttribute("title", rs.getString("job_title"));
				body.invoke(out);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
