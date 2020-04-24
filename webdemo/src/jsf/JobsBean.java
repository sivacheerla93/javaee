package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
@RequestScoped
public class JobsBean {
	private int count;

	public int getCount() {
		return count;
	}

	public RowSet getJobs() {
		try {
			CachedRowSet rs = new OracleCachedRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			rs.setUsername("hr");
			rs.setPassword("hr");
			rs.setCommand("select * from jobs");
			rs.execute();
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}
