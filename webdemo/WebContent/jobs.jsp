<%@ page language="java" import="oracle.jdbc.rowset.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Job</title>
</head>
<body>
	<form action="jobs.jsp" method="post">
		Job Id : <input type="text" name="jobid" value="${param.jobid}" /> <input
			type="submit" value="Employees" />
	</form>
	<p></p>

	<%
		String jobid = request.getParameter("jobid");
		if (jobid == null)
			return; // stop JSP 

		OracleCachedRowSet rs = new OracleCachedRowSet();
		rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rs.setUsername("hr");
		rs.setPassword("hr");
		rs.setCommand("select * from employees where job_id = ?");
		rs.setString(1, jobid);
		rs.execute();
	%>

	<table border="1">
		<tr style="background-color: gray">
			<th>Name</th>
			<th>Salary</th>
			<th>HireDate</th>
		</tr>
		<%
			while (rs.next()) {
				out.println(String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", rs.getString("first_name"),
						rs.getString("salary"), rs.getString("hire_date")));
			}
			rs.close();
		%>

	</table>

</body>
</html>