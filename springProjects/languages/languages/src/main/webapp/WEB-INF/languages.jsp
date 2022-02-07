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
	<h1>Languages</h1>
	<a href="/languages">Add Language</a>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Creator</td>
				<td>Version</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${languages}">
				<tr>
					<td><a href="/languages/show/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.version}"/></td>
					<td><a href="/languages/edit/<c:out value="${language.id}"/>">Edit</a>
					<form action="/language/delete/<c:out value="${language.id}"/>" method="post">
				    	<input type="hidden" name="_method" value="delete">
				    	<input type="submit" value="Delete">
					</form>
					</td>
				</tr>
			</c:forEach> 		
		</tbody>	
	</table>
</body>
</html>