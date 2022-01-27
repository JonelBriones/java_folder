<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Store</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<h3>Name/Price</h3>
	<c:forEach var="fruit" items="${fruits}">
		<p><c:out value="${fruit.name}"/></p>
		<p><c:out value="${fruit.price}"/></p>
	</c:forEach>
	
</body>
</html>