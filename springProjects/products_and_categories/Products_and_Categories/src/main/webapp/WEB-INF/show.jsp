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
	<a href="/products/all">All Products</a>
	<a href="/categories/all">All Categories</a>
	<a href="/products/add">Add Products</a>
	<a href="/categories/add">Add Category</a>
	<a href="/user/logout">Logout</a>
	<h1>${product.name}</h1>
	<p>Added by ${product.user.userName}</p>
		<div>
			<h3>Categories:${product.categories.size()}</h3>
			<table>
				<tr>
					<c:forEach var="category" items="${product.categories}">
					<hr>${category.name}
					</c:forEach>
				</tr>
			</table>	
				
			${products.categories.size()}
			<form action="/products/add/category/${product.id}" method="post">
				<select name="category_id">
					<c:forEach var="category" items="${categories}">
						<option value="${category.id}">
							${category.name}
						</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add to ${product.name}"/>
			</form>
		</div>


</body>
</html>