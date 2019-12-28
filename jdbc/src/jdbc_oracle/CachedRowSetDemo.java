package jdbc_oracle;

import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();
		while (crs.next()) {
			System.out.println(crs.getString(2) + ":" + crs.getInt(3));
		}
		crs.absolute(1);

		crs.updateInt(3, crs.getInt(3) + 1000);
		crs.updateRow();

		crs.beforeFirst();
		while (crs.next()) {
			System.out.println(crs.getString(2) + ":" + crs.getInt(3));
		}
		crs.acceptChanges();
	}

}
