<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/form" method="post">
		<div>
			<p>Pick any number from 5 to 25</p>
			<input type="number" name="number">
		</div>
		<div>
			<p>Enter the name of any city.</p>
			<input type="text" name="city">
		</div>
		<div>
			<p>Enter the name of any real person.</p>
			<input type="text" name="fullName">
		</div>
		<div>
			<p>Enter professional endeavor or hobby:</p>
			<input type="text" name="hobby">
		</div>
		<div>
			<p>Enter any type of living thing.</p>
			<input type="text" name="thing">
		</div>
		<div>
			<p>Say something nice to someone.</p>
			<input type="text" name="niceNote">
		</div>
			<label>Submit:</label>
			<input type="submit" name="Submit">
	</form>
</body>
</html>