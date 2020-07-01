<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>VinaEnter EDU - Đã học là làm được</title>
	<meta name="description" content="Thiet ke website, dao tap lap trinh">
	<meta name="keywords" content="thiet ke website, dao tap lap trinh">
	<link href="<%=request.getContextPath() %>/anews/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- <%=request.getContextPath()%> :đường dẫn thư mục gốc của dự án /jspd2--%>
	<div class="wrapper">
		<!-- begin header -->
		<div id="header">
			<div class="header-left fl">
				<a href="index.html" title=""><img src="<%=request.getContextPath() %>/anews/images/logo_edu.png" alt="" /></a>
			</div>
			<div class="header-right fr">
				<a href="index.html" title=""><img src="<%=request.getContextPath() %>/anews/images/banner.jpg" alt="" /></a>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end header -->
		
		<!-- begin menu -->
		<div id="menu">
			<ul>
				<li class="active"><a href="<%=request.getContextPath() %>/anews/index.jsp" title="">Trang chủ</a></li>
				<li><a href="<%=request.getContextPath() %>/anews/tintuc.jsp" title="">Tin tức</a></li>
				<li><a href="<%=request.getContextPath() %>/anews/lienhe.jsp" title="">Liên hệ</a></li>
			</ul>
			<div class="clr"></div>
		</div>
		<!-- end menu -->