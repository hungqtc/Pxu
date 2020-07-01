<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getParameter("msg") != null) {
	%>
	<p style="color: red">Sai tên đăng nhập hoặc mật khẩu</p>
	<%
		}
	%>


	<form action="<%=request.getContextPath()%>/login" method="post">
		<table border="1" width="500px" style="text-align: center">
			<tr>
				<th>Username</th>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>