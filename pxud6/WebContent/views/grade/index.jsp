<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
<style>
table {
	border-collapse: collapse;
	width: 88%;
}

td, th {
	border: 1px soild #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h2>Customer List</h2>
	<a href="doAdd">Add</a>

	<table style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Grade</th>
			<th>Address</th>
			<th>Email</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${listStudent}" var="student">
			<tr>
				<td>${student.name}</td>
				<td>${student.grade.name}</td>
				<td>${student.address}</td>
				<td>${student.email}</td>
				<td><a href="<c:url value="doUpdate?id=${cus.id}"></c:url>">Edit</a>&nbsp;&nbsp;
					<a href="<c:url value="doDelete?id=${cus.id}"></c:url>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>