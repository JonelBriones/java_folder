<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
 	<h1>Here's Your Omikuji!</h1>
 	<h1>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${fullName}"/> as your roommate, <c:out value="${hobby}"/>. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${niceNote}"/> </h1>
</body>
</html>