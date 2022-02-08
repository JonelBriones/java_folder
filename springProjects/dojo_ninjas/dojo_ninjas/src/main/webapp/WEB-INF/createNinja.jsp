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
   <h1>New Ninja</h1>
	<form:form action="/ninja/create" method="post" modelAttribute="ninja">
		   	<!--- inside the form:form --->
	    	<!--- Drop down select menu --->
	    	<form:select path="dojo">
	        	<c:forEach var="dojo" items="${dojos}">
	            <!--- Each option VALUE is the id of the person --->
	            	<form:option value="${dojo}" path="dojo">
	            <!--- This is what shows to the user as the option --->
	               	 <c:out value="${dojo.name}"/>
	            	</form:option>
	       		 </c:forEach>
	    	</form:select>
	    	<p>
		        <form:label path="name">First Name:</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name:</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>
		    <p>
		        <form:label path="age">Age:</form:label>
		        <form:errors path="age"/>     
		        <form:input type="number" path="age"/>
		    </p>
			<!--- ... --->
	    <input type="submit" value="Submit"/>
	</form:form>	
</body>
</html>