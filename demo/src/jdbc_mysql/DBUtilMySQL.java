package jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtilMySQL {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "9866850403");
		return con;
	}

	public static void main(String[] args) throws Exception {
		Connection con = DBUtilMySQL.getConnection();
		System.out.println("Connected!");
		con.close();
	}

}