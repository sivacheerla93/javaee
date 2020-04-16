package jdbc_oracle;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBUtilOracle.getConnection()) {
			Statement st = con.createStatement();
			int count = st.executeUpdate("update employees set salary = salary * 1.1 where employee_id = 206");
			if (count == 1)
				System.out.println("Updated Salary Successfully!");
			else
				System.out.println("Could not find employee!");

		}

	}

}