package jdbc_oracle;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDataSourceConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ods.setUser("hr");
		ods.setPassword("hr");

		try (Connection con = ods.getConnection()) {
			System.out.println("Connected to Oracle using DataSource");
		}
	}

}
