package jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) {

		try (Connection con = DBUtil.getConnection()) {
			Statement st = con.createStatement();
			int count = st.executeUpdate("update employees set salary = salary * 1.1 where id = 1");
			if (count == 1)
				System.out.println("Updated Salary Successfully!");
			else
				System.out.println("Could not find employee!");

		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

	}

}