package jdbc_oracle;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.Statement;

public class BatchUpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection()) {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			try {
				stmt.addBatch("update employees set salary = salary + 2000 where salary > 10000");
				stmt.addBatch("update employees set salary = salary + 1000 where salary < 10000");

				int[] uc = stmt.executeBatch();
				con.commit();

				for (int i = 0; i < uc.length; i++) {
					System.out.println(i + ":" + uc[i]);
				}
			} catch (BatchUpdateException ex) {
				System.out.println("Batch Update Exception: " + ex.getMessage());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
