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
<title>Add Book</title>
</head>
<body>  
	<h1><c:out value="${user.userName }"/></h1>
	<a href="/home">Go Home</a>
	<h1>Add a Book to your shelf!</h1>
	<div>
		<form:form action="/add/book" method="post" modelAttribute="newBook">
		    <form:hidden  path="user" value="${user.id}"/>
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="author">Author</form:label>
		        <form:errors path="author"/>
		        <form:input path="author"/>
		    </p>
		    <p>
		        <form:label path="thought">My thoughts:</form:label>
		        <form:errors path="thought"/>
		        <form:input path="thought"/>
		    </p> 
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
	
</body>
</html>