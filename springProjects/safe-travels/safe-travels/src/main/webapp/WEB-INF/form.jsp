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
	
<h1>Add an Expense</h1>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="item">Item</form:label>
        <form:errors path="item"/>
        <form:input path="item"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/> 
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

	
</body>
</html>