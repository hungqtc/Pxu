<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<%=request.getContextPath() %>/Bai1/style.css" type="text/css" rel="stylesheet">
		<title>Bai 1</title>
	</head>
<body>
	<div class='wrapper'>
		<h1>Login </h1>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<label>Tên đăng nhập</label>
			<input type="text" value="" name="username"> <br/>
			<label>Mật khẩu</label>
			<input type="text" value="" name="password"> <br/>
			<input type="submit" value="Đăng nhập"  />
		
		</form>
	</div>
</body>
</html>