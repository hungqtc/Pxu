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
<title>Edit Customers</title>
<style>
</style>
</head>
<body>
	
	<h2>Edit Customer</h2>
	<a href="index">Back</a>

<form action="doUpdate" method="post">
  <label> Fullname:</label><br>
  <input type="text" name="fullname" value="${cus.fullname}"><br><br>
  <label> Address:</label><br>
  <input type="text" name="address" value="${cus.address}"><br><br>
  <label> Email:</label><br>
  <input type="text" name="email" value="${cus.email}"><br><br>
  
  <input type="hidden" name="id" value="${cus.id}">
  <input type="submit" value="Submit">
</form>	
</body>
</html>