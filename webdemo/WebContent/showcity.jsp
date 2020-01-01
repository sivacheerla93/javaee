<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>
		${cookie.city.value}

		<%
			boolean found = false;
			Cookie cl[] = request.getCookies();
			for (Cookie c : cl) {
				if (c.getName().equals("city")) {
					found = true;
					break;
				}
			}

			if (!found)
				out.println("Sorry! City not known!");
		%>
	</h2>

</body>
</html>