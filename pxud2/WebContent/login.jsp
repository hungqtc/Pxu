<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method = "POST" action="home">
		<label for="fname">Name:</label> <br> 
		<input type="text" id="name" name="name" ><br> 
		<label for="lname">Password:</label> <br> 
		<input type="password" id="password" name="password"><br>
		<br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>