package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) {

		// ARM
		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from jobs");

			while (rs.next()) {
				System.out.printf("%-10s  %s\n", rs.getString("job_id"), rs.getString("job_title"));
			}
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

	}

}