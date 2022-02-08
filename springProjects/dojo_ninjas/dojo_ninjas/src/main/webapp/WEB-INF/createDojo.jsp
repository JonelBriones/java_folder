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
    <title>Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/ninja">New Ninja</a>
   <h1>New Dojo</h1>
	<form:form action="/dojo/create" method="post" modelAttribute="dojo">
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
	<h1>All Dojos:</h1>	
	<table>
		<thead>
			<c:forEach var="dojo" items="${dojos}">
			<tr>
				<td>
					<a href="/dojo/<c:out value="${dojo.id}"/>"><c:out value="${dojo.name}"/></a>
				</td>
			</tr>
			</c:forEach>
		</thead>
			
	</table>
</body>
</html>