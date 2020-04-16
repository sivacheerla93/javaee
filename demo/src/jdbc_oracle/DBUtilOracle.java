package jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtilOracle {

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		return con;
	}

	public static void main(String[] args) throws Exception {
		Connection con = DBUtilOracle.getConnection();
		System.out.println("Connected!");
		con.close();
	}

}
