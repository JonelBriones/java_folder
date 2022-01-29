<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter Show</title>
</head>
<body>
	<h1>You have visited this site <c:out value="${countToShow}"/>times</h1>
	<a href="/your_server">Test another visit?</a> 

</body>
</html>