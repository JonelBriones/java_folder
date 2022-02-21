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
   <h1>Welcome ${user.userName}</h1>
	<a href="/user/logout">Logout</a>
	<a href="/project/new"><button>+ New Project</button></a>
	<hr>
	<div>
	<p>All Projects</p>
	<table>
		<thead>
			<tr>
				<td>Projects</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Actions</td>
			</tr>
		</thead>
		<!-- Itterate through projects -->
			<c:forEach var="project" items="${projects}">
			<!-- if project id does not match user.id then show -->
			<c:if test="${project.user.id != user.id }">
				<!-- All projects that the user is not a part of -->
				<tr>
					<td>${project.title}</td>
					<td>${project.user.userName}</td>
					<td>${project.date}</td>
					<td><a href="/project/join/<c:out value="${project.id}"/>">Join Team</a>
					</td> 
				</tr>
			</c:if>
		</c:forEach>
	</table>
	</div>
	<hr>
	<div>
	<p>Your Projects</p>
	<table>
		<thead>
			<tr>
				<td>Projects</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Actions</td>
			</tr>
		</thead>
		
		<c:forEach var="project" items="${projects}">
		<c:choose>
			<c:when test="${project.user.id == user.id }">
				<tr>
					<td>${project.title}</td>
					<td>${project.user.userName}</td>
					<td>${project.date}</td>
					<td><a href="/project/edit/project/<c:out value="${project.id}"/>">Edit</a>
						<form action="/project/delete/project/<c:out value="${project.id}"/>" method="post">
				    		<input type="hidden" name="_method" value="delete">
				    		<input type="submit" value="Delete">
						</form>
					</td> 
				</tr>
			</c:when>
		</c:choose>
		</c:forEach>
	
	</table>
	</div>
</body>
</html>