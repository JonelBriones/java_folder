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
	<a href="/bookmarket">Back to the shelves</a>
	<div>
		<h1><c:out value="${book.title}"/></h1>
 		<h2><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
		<p><c:out value="${book.thought}"/></p>
		
		<!-- Will check if the book id matches the user, will display edit or delete button -->
		<c:if test="${book.user.id == user_id}">
			<a href="/edit/book/<c:out value="${book.id}"/>">Edit</a>
				<form action="/delete/bookmarket/<c:out value="${book.id}"/>" method="post">
		    		<input type="hidden" name="_method" value="delete">
		    		<input type="submit" value="Delete">
				</form>
		</c:if> 
	</div>
	
</body>
</html>