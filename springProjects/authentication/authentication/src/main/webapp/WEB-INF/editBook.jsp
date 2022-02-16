<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>  
	<h1><c:out value="${user.userName }"/></h1>
	<a href="/home">Go Home</a>
	<h1>Edit ${user.userName}</h1>
	<div>
		<form:form action="/edit/book/update/" method="post" modelAttribute="editBook">
			
		    <form:hidden  path="user" value="${book.id}"/><!-- Includes user.id to book.user_id -->
 		     
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title" />
		    </p>
		    <p>
		        <form:label path="author">Author</form:label>
		        <form:errors path="author"/>
		        <form:input path="author"/>
		    </p>
		    <p>
		        <form:label path="thought">My thoughts:</form:label>
		        <form:errors path="thought"/>
		        <form:textarea rows="5" cols="30" path="thought"/>
		    </p> 
		    <input type="submit" value="Submit"/>
		</form:form>
		<form action="/delete/<c:out value="${book.id}"/>" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
		</form>
	</div>
	
</body>
</html>