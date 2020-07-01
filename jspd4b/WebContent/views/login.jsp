<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VNT CMS - login</title>
</head>
<body>
	<h1>Login form</h1>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		Username: <input type="text" name="username" value="" /><br /><br />
		Password: <input type="password" name="password" value="" /><br /><br />
		
		<input type="submit" name="submit" value="Login" />
	</form>
</body>
</html>