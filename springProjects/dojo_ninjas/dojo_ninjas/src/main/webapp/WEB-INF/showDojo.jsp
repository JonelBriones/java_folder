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
	<a href="/dojo">Go Back</a>
 	 <h1><c:out value="${dojo.name}"/></h1>

 
	<table class="table">
    <thead class="thead-dark">
        	<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
        	</tr>
    	</thead>
    	<tbody>
    		<!-- This is to link the dojo id to ninja.dojo_id -->
	        <c:forEach var="ninja" items="${dojo.ninja}">
	        <tr>
	        	<td>
	                <c:out value="${ninja.name}"/>
	            </td>
	            <td>
	                <c:out value="${ninja.lastName}"/>
	            </td>
	            <td>
	                <c:out value="${ninja.age}"/>
	            </td>
	        </tr>
	        </c:forEach>
    	</tbody>
	</table>
</body>
</html>