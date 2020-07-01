<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bài tập 5</title>
	</head>
<body>

	<div>
		<%
			out.print(request.getAttribute("randNumber"));
		%>
		<br>
		<%
			int rand = Integer.parseInt(request.getAttribute("randNumber").toString());
			if (rand % 2 == 0) {
				out.print("Đây là số chẵn");
			} else {
				out.print("Đây là số lẻ");
			}
		%>

	</div>

</body>
</html>