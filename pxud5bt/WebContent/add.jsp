<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hung.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.hung.service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<style>
</style>
</head>
<body>
	
	<h2>Add Customer</h2>
	<a href="index">Back</a>

<form action="doAdd" method="post">
  <label> Fullname:</label><br>
  <input type="text" name="fullname"><br><br>
  <label> Address:</label><br>
  <input type="text" name="address"><br><br>
  <label> Email:</label><br>
  <input type="text" name="email"><br><br>
  
  <input type="hidden" name="id">
  <input type="submit" value="Submit">
</form>	
</body>
</html>