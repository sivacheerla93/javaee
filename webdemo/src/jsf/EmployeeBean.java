package jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import servlets.DBUtilOracle;

@ManagedBean
public class EmployeeBean {
	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ArrayList<SelectItem> getJobs() {
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from jobs")) {
			ResultSet rs = ps.executeQuery();
			ArrayList<SelectItem> al = new ArrayList<SelectItem>();
			while (rs.next()) {
				al.add(new SelectItem(rs.getString("job_id"), rs.getString("job_title")));
			}
			rs.close();
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error In getjobs() -->" + e.getMessage());
			return null;
		}
	}

	public RowSet getEmployees() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees where job_id = ?");
			rs.setString(1, job);
			rs.execute();
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
