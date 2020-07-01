<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HCNe</title>
	</head>
	<body>
		<form action="<%=request.getContextPath() %>/hinh-chu-nhat" method="get">
		<label>Chiều dài: </label>
		<input type="text" value="" name="chieudai" /> <br> <br>
		<label>Chiều rộng: </label>
		<input type="text" value="" name="chieurong" /> <br> <br>
		<input type="submit" value="Tính" name="submit" />
		</form>
</html>