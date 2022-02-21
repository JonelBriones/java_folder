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
    <title>New Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Edit Project</h1>
	<a href="/projects/new"><button>+ New Project</button></a>
	
	<form:form action="/project/edit/project/update" method="post" modelAttribute="updateProject">
		  <!-- Passes the product.id  -->
		  <form:input type="hidden" path="id"/>
		<p>
			<form:label path="title">Project Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="description">Project Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<p>
			<form:label path="date">Due Date:</form:label>
			<form:errors path="date"/>
			<form:input type="date" path="date"/>
		</p>
		<input type="submit" value="Update User">
	</form:form>
	<form action="/project/delete/project/<c:out value="${project.id}"/>" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete">
		</form>
	
</body>
</html>