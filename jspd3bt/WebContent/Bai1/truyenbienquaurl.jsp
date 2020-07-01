<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Truyền biến qua url</title>
</head>
<body>
	<h2>Truyền biến qua url</h2>
	<a
		href="<%=request.getContextPath()%>/tinh-dien-tich-chu-vi?chieudai=5&chieurong=10"
		title=""> Tính diện tích, chu vi HCN</a>
</body>
</html>