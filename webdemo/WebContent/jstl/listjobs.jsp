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

	<sql:query var="jobs" dataSource="${con}">
        select * from jobs 
    </sql:query>

	<h2>Jobs</h2>

	<c:forEach items="${jobs.rows}" var="job">
       ${job.job_title}
       <br />
	</c:forEach>


</body>
</html>