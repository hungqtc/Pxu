<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<h2>Tính tổng 1 dãy số</h2>
			<form action="<%=request.getContextPath() %>/tinh-tong" method="get">
				<label>Điền vào dãy số: </label> 
				<input type="text" value="" name="dayso"> <br> <br>
				<input type="submit" value="Tính tổng" name="submit"> <br> <br>
			
			</form>
		</div>
		
		
	</body>
</html>