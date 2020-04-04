<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Interest</title>
</head>
<body>
	<h2>Simple Interest</h2>
	<%
		String samount = request.getParameter("amount");
		String srate = request.getParameter("rate");

		double amount = Double.parseDouble(samount);
		double rate = Double.parseDouble(srate);

		double interest = amount * rate / 100;

		out.println("Interest  = " + interest);
	%>
</body>
</html>