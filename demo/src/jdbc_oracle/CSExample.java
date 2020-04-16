package jdbc_oracle;

import java.sql.CallableStatement;
import java.sql.Connection;

public class CSExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection();
				CallableStatement cs = con.prepareCall("{call UpdateSalary(?, ?)}");) {
			cs.setInt(1, 100);
			cs.setInt(2, 6000);
			cs.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
