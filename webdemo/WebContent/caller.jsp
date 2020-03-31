<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Caller Page</h1>
	P1 = ${param.p1 }
	<p />
	P2 = ${param.p2 }
	<p />
	<%
		request.setAttribute("color", "Red");
	%>
	<jsp:include page="called.jsp">
		<jsp:param value="30" name="p3" />
	</jsp:include>
	<h2>Back in Caller</h2>
</body>
</html>