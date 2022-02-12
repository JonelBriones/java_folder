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
	<h1>Welcome</h1>
	<p>Join our growing community!</p>
	<div>
		<h1>Register</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
		    <p>
		        <form:label path="userName">User Name</form:label>
		        <form:errors path="userName"/>
		        <form:input path="userName"/>
		    </p>
		    <p>
		        <form:label path="email">Email:</form:label>
		        <form:errors path="email"/>
		        <form:input path="email"/>
		    </p>
		    <p>
		        <form:label path="password">Password:</form:label>
		        <form:errors path="password"/>
		        <form:input path="password"/>
		    </p>
		    <p>
		        <form:label path="confirm">Confirm Password:</form:label>
		        <form:errors path="confirm"/>     
		        <form:input path="confirm"/>
		    </p>    
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
	<div>
		<h1>Login</h1>
		<p>
		   <c:out value="${error}"/>
		</p>
		<form action="/login" method="post" >
		    
		       <label>Email:</label>
		       <input type="text" name="email"/>
		       
		       <label>Password:</label>
		       <input type="text" name="password"/>
		    <input type="submit" value="Submit"/>
		</form>
	</div>
	
</body>
</html>