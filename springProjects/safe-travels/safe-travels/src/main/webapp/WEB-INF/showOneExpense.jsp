<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c:forEach -->
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Details</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expenses/show">Go back</a>
	<p>Expense Name: <c:out value="${expense.item}"/></p>
	<p>Expense Description: <c:out value="${expense.description}"/></p>
	<p>Vendor: <c:out value="${expense.vendor}"/></p>
	<p>Amount Spent: $<c:out value="${expense.amount}"/></p>
</body>
</html>