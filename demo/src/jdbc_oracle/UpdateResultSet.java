package jdbc_oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateResultSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection();
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select job_id, job_title, min_salary from jobs");) {
			rs.last();

			// values before change
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));

			// update minimum salary
			rs.updateInt(3, rs.getInt(3) + 1000);
			rs.updateRow();

			// values after change
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
