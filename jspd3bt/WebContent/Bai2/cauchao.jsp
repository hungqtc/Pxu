<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bài tập 2</title>
		<link href="<%=request.getContextPath() %>/Bai2/style.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<h2>In câu chào</h2>
			<form action="<%=request.getContextPath()%>/in-cau-chao" method="post">	
				
			<label>Nhập tên</label>
			<%if(request.getAttribute("Ans") != null) { %>
			<input type="text" value="<%=request.getAttribute("name") %>" name="name" /> <br/>
			<label><%=request.getAttribute("Ans") %></label><br>
			
			<%} else {%> 
			<input type="text" value="" name="name" /> <br/>
			
			<% }%>
			
			<input type="submit" value="In câu chào"  /> 
		</form>
		</div>
		
	</body>
</html>