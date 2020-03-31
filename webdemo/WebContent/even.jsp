<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="even.jsp">
		Enter a number: <input type="text" name="num" size="10"
			value="${param.num }" />
		<p>
			<input type="submit" value="Submit" />
	</form>
	<%
		String num = request.getParameter("num");
		if (num != null && num.length() > 0) {
			int n = Integer.parseInt(num);
			if (n % 2 == 0) {
				out.println("<h3>Even Number</h3>");
			} else {
				out.println("<h3>Odd Number</h3>");
			}
		}
	%>
</body>
</html>