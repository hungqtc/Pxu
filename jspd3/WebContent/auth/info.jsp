<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information</title>
</head>
<body>
	<h1>THÔNG TIN NGƯỜI DÙNG</h1>
	<%
		String username = (String)request.getAttribute("username");
		String fullname = (String)request.getAttribute("fullname");
	%>
	<p>Tên người dùng: <%=username %> </p>
	<p>Họ tên: <%=fullname %></p>
</body>
</html>