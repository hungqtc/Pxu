<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>URL - Detail</title>
</head>
<body>
	<h1>Danh sách tin mới</h1>
	<ul>
		<li><a
			href="<%=request.getContextPath()%>/detail?id=1&name=Lập trình Java">Lap
				trinh java </a></li>

		<li><a
			href="<%=request.getContextPath()%>/detail?id=2&name=Lập trình Php">Lap
				trinh php </a></li>

		<li><a
			href="<%=request.getContextPath()%>/detail?id=3&name=Lập trình Android">Lap
				trinh android </a></li>
	</ul>
</body>
</html>