<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Called Page</h1>
	P1 = ${param.p1 }
	<p />
	P2 = ${param.p2 }
	<p />
	P3 = ${param.p3 }
	<p />
	Color = ${requestScope.color }
</body>
</html>