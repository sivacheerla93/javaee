package jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleODBCConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:odbc:oraclejava", "hr", "hr")) {
			System.out.println("Connected using ODBC driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
