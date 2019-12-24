package jdbc_oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {

		// ARM
		try (Connection con = DBUtilOracle.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from jobs");

			while (rs.next()) {
				System.out.printf("%-10s  %s\n", rs.getString("job_id"), rs.getString("job_title"));
			}
		}

	}

}