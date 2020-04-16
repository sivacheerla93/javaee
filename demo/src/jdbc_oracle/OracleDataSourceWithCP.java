package jdbc_oracle;

import java.sql.Connection;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

public class OracleDataSourceWithCP {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		ods.setUser("hr");
		ods.setPassword("hr");
		ods.setConnectionCachingEnabled(true);

		Properties prop = new Properties();
		prop.setProperty("MinLimit", "5");
		prop.setProperty("MaxLimit", "25");
		prop.setProperty("InitialLimit", "5");
		ods.setConnectionCacheProperties(prop);

		try (Connection con = ods.getConnection()) {
			System.out.println("Connected To Oracle using DataSource");
		}
	}

}
