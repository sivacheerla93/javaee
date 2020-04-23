package jsf;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class EmployeesBean {

	// employees property
	public RowSet getEmployees() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from employees");
			rs.execute();
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

}