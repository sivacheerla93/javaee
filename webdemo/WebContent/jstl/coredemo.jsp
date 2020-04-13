<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Core Tags</title>
</head>
<body>

	<c:set var="title" value="Srikanth Technologies" scope="session"></c:set>

	<h2>${sessionScope.title}</h2>

	<c:forEach var="i" begin="1" end="10">
        ${i} <br />
	</c:forEach>

</body>
</html>