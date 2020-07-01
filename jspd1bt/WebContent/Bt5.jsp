<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCRIPLET</title>
</head>
<body>
	<h1>SCRIPLET</h1>
	<% 
		int number1 = 10;
		int number2 = 20;
		int sum = number1 + number2;
		
	%>
	<div>
		<p>Số thứ nhất: <%=number1%></p>
		<p>Số thứ hai: <% out.print(number2); %> </p>
		<p style="color: red;font-weight: bold">Tổng: <% out.print(sum); %> </p>
	</div>
	
</body>
</html>