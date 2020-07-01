<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VNT CMS</title>
</head>
<body>
	<p> Họ tên:<%=session.getAttribute("fullName") %> </p>
	<p> Họ tên:<%=session.getAttribute("age") %> </p>
	
	<h1>VNT CSM</h1>
	<ul>
		<li><a href="<%=request.getContextPath()%>/views/login.jsp" title="">Đăng nhập</a></li>
		<li><a href="<%=request.getContextPath()%>/views/upload.jsp" title="">Upload ảnh</a></li>
	</ul>
	
</body>
</html>