<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bài tập 4</title>
		<link href="<%=request.getContextPath() %>/Bai4/style.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper">
			<h2>Thay thế chuỗi</h2>
			<form action="<%=request.getContextPath()%>/thay-the-chuoi" method="post">			
			<label class="lb1">Đoạn văn gốc</label> <br>
			
			<textarea name="chuoigoc"><%if(request.getAttribute("chuoigoc")!= null)
				
			 out.print(request.getAttribute("chuoigoc")); %></textarea> <br/>
			
			<label>Từ gốc</label>
					
			<input type="text" value="<%if(request.getAttribute("tugoc")!= null)
				
			 out.print(request.getAttribute("tugoc")); %>" name="tugoc" /> 
			<label>thay thế bằng</label>
			
			
			<input type="text" value="<%if(request.getAttribute("tuthaythe")!= null)
				
			 out.print(request.getAttribute("tuthaythe")); %>" name="tuthaythe" /> <br>
			<textarea name="chuoithaydoi"> <%if(request.getAttribute("chuoithaythe") != null){
				out.print(request.getAttribute("chuoithaythe"));
			} %></textarea> <br/>
					
			<input type="submit" value="Thực hiện" id="submit" /> 
		</form>
		</div>
		<div class="err">
				<%if(request.getAttribute("error") != null) {
					%>
					<p><%=request.getAttribute("error") %></p>
				<% } %>
			</div>
	</body>
</html>