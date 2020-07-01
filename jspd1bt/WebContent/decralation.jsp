<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Decralation</title>
</head>
<body>
	<h2>Decralation</h2>
	
	<%!
		float chieudai = 5;
		float chieurong = 2;
		public float chuviHCN(float chieudai, float chieurong) {
		return (chieudai + chieurong) * 2;
	}
	
	public float dientichHCN(float chieudai, float chieurong) {
		return chieudai * chieurong;
			}
	%>
	
	<div>
		<h3>Thông tin Hình chữ nhật</h3>
		<p>Chu vi hình chữ nhật: <span style="color: blue"> <%=dientichHCN(chieudai, chieurong) %></span></p>
		<p>Diện tích hình chữ nhật: <span style="color: blue"><%=chuviHCN(chieudai, chieurong) %></span></p>
	</div>
</body>
</html>