<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servlets.DBUtilOracle"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.json.*"%>

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