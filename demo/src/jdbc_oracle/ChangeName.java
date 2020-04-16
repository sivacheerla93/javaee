package jdbc_oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChangeName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con
						.prepareStatement("update employees set first_name = ? where employee_id = ?");) {
			ps.setString(1, "SMITH");
			ps.setInt(2, 100);
			int rows = ps.executeUpdate();
			if (rows == 1) {
				System.out.println("Updation is successful");
			} else {
				System.out.println("Updation is not successful");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
