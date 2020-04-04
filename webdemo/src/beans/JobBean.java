package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import servlets.DBUtilOracle;

public class JobBean {
	private String id, title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addJob() throws SQLException, Exception {
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into jobs values(?, ?, null, null)")) {
			ps.setString(1, getId());
			ps.setString(2, getTitle());
			ps.executeUpdate();
		}
	}
}
