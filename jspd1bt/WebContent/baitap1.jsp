<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập áp dụng</title>
</head>
<body>
	<% 
		Random rand = new Random();
		int sonn = rand.nextInt(10);
	%>
	<p>Số ngẫu nhiên: <span style="color: red"><%=sonn%></span></p>
</body>
</html>