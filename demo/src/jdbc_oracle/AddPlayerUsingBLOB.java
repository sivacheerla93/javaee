package jdbc_oracle;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddPlayerUsingBLOB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DBUtilOracle.getConnection()) {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter player name: ");
			String playername = s.nextLine();
			System.out.println("Enter photo filename: ");
			String photofilename = s.nextLine();

			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("insert into players values(?, ?)");

			File picfile = new File(photofilename);
			FileInputStream is = new FileInputStream(picfile);
			ps.setString(1, playername);
			ps.setBinaryStream(2, is, (int) picfile.length());
			ps.executeUpdate();
			con.commit();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
