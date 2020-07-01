<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bài tập 3</title>
		<style type="text/css">
			.error {
			color: red;
			font-style: italic;
			}
		</style>
	</head>
	<body>
		<div class="wrapper">
			<h2>Hình tròn</h2>
			<%if(request.getParameter("msg") != null) {
				String msg = request.getParameter("msg");
				if("0".equals(msg)) {
					out.print("<p class='error'>Bạn không nhập rỗng</p>");
				}
				else if ("1".equals(msg)) {
					out.print("<p class='error'>Bạn vui lòng nhập 1 trong 2 giá trị</p>");
				}
				else  if ("2".equals(msg)) {
					out.print("<p class='error'>Bạn vui lòng nhập đúng định dạng của số</p>");
				}
			}
			double dienTich = 0;
			double banKinh = 0;
			if(request.getAttribute("dienTich") != null && request.getAttribute("banKinh") != null) {
				banKinh = (Double)request.getAttribute("banKinh");
				dienTich = (Double)request.getAttribute("dienTich");
			}
			%>
			
			<form action="<%=request.getContextPath()%>/hinh-tron" method="post">			
			<label>Diện tích</label>
			
			<input type="text" value="<%=(dienTich == 0)? "" : dienTich %>" name="dientich" /> <br/>
			<label>Bán kính</label>
			
			<input type="text" value="<%if(banKinh != 0) {out.print(banKinh);}  %>" name="bankinh" /> <br/>
			
						
			<input type="submit" value="Submit" id="submit" /> 
			
		</form>
		</div>
	</body>
</html>