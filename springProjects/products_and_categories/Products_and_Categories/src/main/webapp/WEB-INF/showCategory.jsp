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
    <title>${category.name}</title>
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
	<h1>${category.name}</h1>
	<p>Added by ${category.user.userName}</p>
		<div>
			<h3>Products:</h3>
				<c:if test="${category.products.contains(categories_products)}">
				<c:forEach var="product" items="${products}">
					${product.name}
				</c:forEach>
				</c:if>
				 ${category.products.size()}

				
   			 <form action="/categories/add/product/${category.id}" method="post">
				<form:select path="products">	
					<c:if test="${!category.products.contains(category) }">
					<c:forEach var="product" items="${products}">
						<option value="${product.id}">
							${product.name}
						<option>
					</c:forEach>
					</c:if>
				</form:select> 
				<input type="submit" value="Add Product to ${category.name}"/>
 	 		</form>
		</div>
</body>
</html>