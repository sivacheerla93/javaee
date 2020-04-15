<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sqlplus.jsp" method="post">
		Enter Query: <br>
		<textarea rows="3" name="query">
			${param.query }
		</textarea>
		<br /> <input type="submit" value="Execute" />
	</form>

	<%
		String query = request.getParameter("query");
		if (query == null || query.length() == 0)
			return;
	%>

	<sql:setDataSource driver="oracle.jdbc.driver.OracleDriver" var="con"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="hr" password="hr" />

	<sql:query var="results" dataSource="${con }">
		${param.query }
	</sql:query>

	<table border="1" cellpadding="3" width="100%s">
		<tr>
			<c:forEach var="cn" items="${results.columnNames }">
				<th>${cn }</th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${results.rowsByIndex }">
			<tr>
				<c:forEach var="colvalue" items="${row }">
					<td>${colvalue }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>