<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	<h2>Update Salary</h2>
	<h3 style="color: red">
		<%
			Class.forName("oracle.jdbc.driver.OracleDriver");

			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
				ps.setInt(1, Integer.parseInt(request.getParameter("salary")));
				ps.setInt(2, Integer.parseInt(request.getParameter("id")));

				int count = ps.executeUpdate();

				if (count == 1)
					out.println("Updated Salary Successfully!");
				else
					out.println("Could not find employee!");
			} catch (Exception ex) {
				out.println("Error -> " + ex.getMessage());
			}
		%>
	</h3>
</body>
</html>