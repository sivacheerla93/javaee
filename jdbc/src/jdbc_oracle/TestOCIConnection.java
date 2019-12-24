package jdbc_oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestOCIConnection {

	public static void main(String[] args) throws Exception {

		// ARM
		try (Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr")) {
			System.out.println("Connected!");
		}

	}

}