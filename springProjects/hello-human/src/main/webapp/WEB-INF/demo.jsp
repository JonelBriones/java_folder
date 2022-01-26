<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP DEMO</title>
</head>
<body>
	<h2>Hello World!</h2>
	<% for(int i = 0; i < 5; i++) { %>
		<h1><%= i %></h1>
	<% } %>
	<p>The time is: <%= new Date() %></p>
	
	<h1>Two plus two is:</h1>
	<h2><c:out value="${2+2}"/></h2>
	
	<h1>Fruit of the Day:</h1>
	<h2><c:out value="${fruit}"/></h2> <!-- fruit will be the name for our key and holding a value -->
	
</body>
</html>