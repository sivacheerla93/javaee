package jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestThinConnection {

	public static void main(String[] args) throws Exception {

		// ARM
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			System.out.println("Connected!");
		}

	}

}