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
	<h2>Hello, ${user.userName}. Welcome to...</h2>
	<h1>The Book Broker</h1>
	<a href="/logout">Logout</a>
	<a href="/home">Back to the shelves</a>
	<div>
		<p>Available Books to Borrow</p>
		<table>
			<thead>
				<tr>
					<td colspan="2">ID</td>
					<td>Title</td>
					<td>Author</td>
					<td>Posted By</td>
					<td>Actions</td>
				</tr>
			</thead>
			<!-- My books -->
			<c:forEach var="book" items="${books}">
			<c:choose>
				
				<c:when test="${book.user.id != user.id}"><!--  Will exclude any books that was created by the user in session -->
				
 					<c:if test="${!book.borrows.contains(user)}"> <!--  Will exclude any books that are already being borrowed -->
 					
						<tr><!-- Books that can be borrowed -->
					 		<td><c:out value="${book.id}"/><td>
							<td><a href="/show/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.user.userName}"/></td>
							<td><a href="/bookmarket/borrow/${book.id}">Borrow</a></td>
						</tr>
					</c:if>
				</c:when>
				
				<c:otherwise><!-- Borrowed books that can be returned -->
					<tr>
					<td><c:out value="${book.id}"/><td>
					<td><a href="/show/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
					<td><a href="/edit/book/<c:out value="${book.id}"/>">Edit</a>
						<form action="/delete/bookmarket/<c:out value="${book.id}"/>" method="post">
				    		<input type="hidden" name="_method" value="delete">
				    		<input type="submit" value="Delete">
						</form>
					</td>
					</tr>
				</c:otherwise>
				
				
			</c:choose>
			</c:forEach>
			
		</table>
			<p>Books I'm Borrowing...</p>
		<table>
			<c:forEach var="book" items="${books}">
					<c:if test="${book.borrows.contains(user)}">
					<tr>
				 		<td><c:out value="${book.id}"/><td>
						<td><a href="/show/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
						<td><a href="/bookmarket/return/${book.id}">Return</a></td>
					</tr>
					</c:if>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>