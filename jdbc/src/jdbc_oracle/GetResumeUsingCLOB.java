package jdbc_oracle;

import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetResumeUsingCLOB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select resume from applicants where id = 1");
			rs.next();
			Clob clob = rs.getClob(1);

			InputStream is = clob.getAsciiStream();
			int ch;

			while ((ch = is.read()) != -1) {
				System.out.println((char) ch);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
