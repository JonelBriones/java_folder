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
<title>Insert title here</title>
</head>
<body>
	<h1>Safe Travels</h1>
	<table>
		<thead>
			<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Description</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneExpense" items="${expenses}">
				<tr>
					<td><c:out value="${oneExpense.item}"/></td>
					<td><c:out value="${oneExpense.vendor}"/></td>
					<td>$<c:out value="${oneExpense.amount}"/></td>
					<td><c:out value="${oneExpense.description}"/></td>
					<td><a href="/expense/edit/<c:out value="${oneExpense.id}"/>">Edit</a></td>
				</tr>
			</c:forEach> 		
		</tbody>	
	</table>

</body>
</html>