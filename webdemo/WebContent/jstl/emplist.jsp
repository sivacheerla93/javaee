<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
</head>
<body>
	<sql:setDataSource driver="oracle.jdbc.driver.OracleDriver" var="con"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="hr" password="hr" />

	<sql:query var="emplist" dataSource="${con}">
        select employee_id, first_name, salary from employees 
    </sql:query>

	<h2>Employees</h2>

	<ul>
		<c:forEach items="${emplist.rows}" var="emp">
			<li>${emp.employee_id },${emp.first_name },${emp.salary }</li>
		</c:forEach>
	</ul>

</body>
</html>