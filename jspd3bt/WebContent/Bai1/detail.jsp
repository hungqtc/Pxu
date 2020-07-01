<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Truyền biến qua url - bài tập</h1>
	<a href="<%=request.getContextPath()%>/detail?id=5&name=Trung tâm đào tạo Vinaenter" title="">Xem chi tiết</a>
</body>
</html>