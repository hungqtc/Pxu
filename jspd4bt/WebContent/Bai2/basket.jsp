<%@page import="object.Hoa"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
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
	
	ArrayList<Hoa> ListHoa = (ArrayList)session.getAttribute("listHoa"); 
	for(int i = 0; i< ListHoa.size(); i++) {
		
	
	
	%>
		<table border="1" width="500px" style="text-align: center">
			<tr>
				<th>Tên sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Tổng tiền</th>
			</tr>
			<tr>
				<td><%=ListHoa.get(i).getTenHoa() %></td>
				<td><%=ListHoa.get(i).getGiaBan() %></td>
				<td><%=ListHoa.get(i).getSoLuong() %></td>
				<td><%=ListHoa.get(i).totalPrice() %></td>
			</tr>
			
		</table>
		<% } %>
	</body>
</html>