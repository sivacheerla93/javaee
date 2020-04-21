<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="servlets.DBUtilOracle"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.json.*"%>

<%
	try (Connection con = DBUtilOracle.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from jobs");
			ResultSet rs = ps.executeQuery();) {

		JsonArrayBuilder jobs = Json.createArrayBuilder();

		while (rs.next()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", rs.getString("job_id"));
			job.add("title", rs.getString("job_title"));
			jobs.add(job.build());
		}

		out.println(jobs.build().toString());
	}
%>