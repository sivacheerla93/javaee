<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servlets.DBUtilOracle"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.json.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		try (Connection con = DBUtilOracle.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select first_name ||' '|| last_name fullname from employees where job_id = ?");) {

			ps.setString(1, request.getParameter("jobid"));
			ResultSet rs = ps.executeQuery();

			JsonArrayBuilder emps = Json.createArrayBuilder();

			while (rs.next()) {
				emps.add(rs.getString("fullname"));
			}

			out.println(emps.build().toString());
		}
	%>
</body>
</html>