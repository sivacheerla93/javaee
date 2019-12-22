package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "9866850403");

		return con;

	}

	public static void main(String[] args) throws Exception {

		Connection con = DBUtil.getConnection();

		System.out.println("Connected!");

		con.close();

	}

}