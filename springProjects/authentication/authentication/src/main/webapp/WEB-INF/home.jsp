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
	<h1>Welcome <c:out value="${user.userName}"/></h1>
	<a href="/logout">Logout</a>
	<a href="/add/<c:out value="${user.id}"/>">Add a book!</a>
	<div>
		<table>
			<thead>
				<tr>
					<td colspan="2">ID</td>
					<td>Title</td>
					<td>Author</td>
					<td>Posted By</td>
				</tr>
			</thead>
 			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/><td>
					<td><a href="/book/show/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
				
				</tr>
			</c:forEach> 
		</table>
	</div>
	
</body>
</html>