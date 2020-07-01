<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Form | VinaEnter Edu</title>
<link href="style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<h1>Thông tin Mr.VinaEnter</h1>
		<form action="<%=request.getContextPath()%>/info" method="post">
			<p>
				<label>Họ tên:</label> <input type="text" name="hoten" id="hoten"
					value="VinaEnter Edu" />
			</p>
			<p>
				<label>Tuổi:</label> <input type="text" name="tuoi" id="tuoi"
					value="100" />
			</p>
			<p>
				<label>Chiều cao:</label> <input type="text" name="chieucao"
					id="chieucao" value="1m75" />
			</p>
			<p>
				<label>Hình ảnh:</label> <input type="file" name="hinhanh"
					id="hinhanh" />
			</p>
			<p>
				<input type="submit" name="submit" id="submit" value="Gửi thông tin" />
			</p>
		</form>

		<div class="button">
			<a href="" title="">Lấy tên</a> || <a href="" title="">Lấy tuổi</a>
			|| <a href="" title="">Lấy chiều cao</a>
		</div>
	</div>
</body>
</html>
