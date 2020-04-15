<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="http://localhost:8888/webdemo/jstl/catalog.xml"
		var="doc" />
	<x:parse doc="${doc }" var="catalog" />
	<x:forEach select="$catalog/catalog/product" var="product">
		<x:out select="$product/name" /> : 
		<x:out select="$product/price" />
		<br>
	</x:forEach>
</body>
</html>