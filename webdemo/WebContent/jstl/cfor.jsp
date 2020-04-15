<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i % 2 == 0 }">
			${i } <br />
		</c:if>
	</c:forEach>

	<p />

	<c:forEach var="i" begin="10" end="20" step="2">
			${i } <br />
	</c:forEach>

	<ul>
		<c:forEach var="name" items="james, anders, roberts, micheal, hunter">
			<li>${name }</li>
		</c:forEach>
	</ul>

	<ul>
		<c:forTokens var="name" items="james:roberts, micheal:hunter"
			delims=":,">
			<li>${name }</li>
		</c:forTokens>
	</ul>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Value</th>
		</tr>
		<c:forEach var="hname" items="<%=request.getHeaderNames()%>">
			<tr>
				<td>${hname }</td>
				<td>${header[hname] }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>