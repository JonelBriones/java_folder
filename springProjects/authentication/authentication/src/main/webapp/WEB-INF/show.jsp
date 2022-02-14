<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
	
	<a href="/logout">Logout</a>
	<a href="/add/<c:out value="${user.id}"/>">Add a book!</a>
	<div>
		<h1><c:out value="${book.title}"/></h1>
 		<h2><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
		<p><c:out value="${book.thought}"/></p>
	</div>
	
</body>
</html>