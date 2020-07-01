<%@page import="object.Account"%>
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
			Account account = (Account)session.getAttribute("account");
			String username = (String)session.getAttribute("username");	
			String password = (String)session.getAttribute("password");
			if((session.getAttribute("account") != null) && ("admin".equals(username)) 
					&& ("123456".equals(password))) {
				out.print("<p>Chào! admin</p>");
			}
			else {
				out.print("<p>Sai username hoặc password</p>");
			}
		%>
	</body>
</html>