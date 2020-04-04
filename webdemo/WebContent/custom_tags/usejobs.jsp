<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.srikanthtechnologies.com/dec1" prefix="st"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List Of Jobs</h2>
	<ul>
		<st:jobs>
			<li>${id},${title}</li>
		</st:jobs>
	</ul>

	<h2>Jobs</h2>
	<table border="1">
		<tr>
			<th>Job Id</th>
			<th>Job Title</th>
		</tr>
		<st:jobs>
			<tr>
				<td>${id }</td>
				<td>${title }</td>
			</tr>
		</st:jobs>
	</table>
</body>
</html>