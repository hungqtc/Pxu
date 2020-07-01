<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bai 2</title>
		<link href="<%=request.getContextPath() %>/Bai2/style.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<%
		String msg = "";
		String name = "", id = "", quanity = "", price = "";
		if(request.getParameter("error") != null){
			String err = request.getParameter("error");
			name = request.getParameter("name");
			id = request.getParameter("id");
			quanity = request.getParameter("quanity");
			price = request.getParameter("price");
					
		}
		if(request.getAttribute("msg") != null) {
			msg = (String)request.getAttribute("msg");
		}
		%>
		<div class='wrapper'>
		<h1>Mua hoa </h1>
		
		<form action="<%=request.getContextPath()%>/hoa" method="post">
			<label>Id hoa:</label>
			<input type="text" value="<%=id %>" name="id"> <br/>
			<label>Tên hoa:</label>
			<input type="text" value="<%=name %>" name="name"> <br/>
			<label>Số lượng:</label>
			<input type="text" value="<%=quanity %>" name="quanity"> <br/>
			<label>Giá:</label>
			<input type="text" value="<%=price %>" name="price"> <br/>
			<input type="submit" value="Mua hoa"  />
		
		</form>
		<h4><%=msg %></h4>
	</div>
	</body>
</html>