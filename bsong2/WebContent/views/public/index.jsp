<%@page import="model.bean.Song"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<%
				if (request.getAttribute("listSong") != null) {
					ArrayList<Song> listSong = (ArrayList<Song>) request.getAttribute("listSong");
					if (listSong.size() > 0) {
						for (Song objSong : listSong) {
			%>
			<h2>
				<a href="<%=request.getContextPath()%>/chi-tiet?sid=<%=objSong.getCatId()%>" title="Đổi thay"><%=objSong.getName()%></a>
			</h2>
			<p class="infopost">
				Ngày đăng:
				<%=objSong.getDate_create()%>
				Lượt xem:
				<%=objSong.getCounter()%>
				<a href="#" class="com"><span>1</span></a>
			</p>
			<div class="clr"></div>
			<div class="img">
				<img
					src="<%=request.getContextPath()%>/public/images/<%=objSong.getPicture()%>"
					width="177" height="213" alt="Đổi thay" class="fl" />
			</div>
			<div class="post_content">
				<p><%=objSong.getPreview()%></p>
				<p class="spec">
					<a href="" class="rm">Chi tiết &raquo;</a>
				</p>
			</div>
			<div class="clr"></div>
			<%
				}
					}
				}
			%>
		</div>


		<p class="pages">
			<small>Trang 1 của 5</small> <span>1</span> <a href="">2</a> <a
				href="">3</a> <a href="">4</a> <a href="">5</a> <a href="#">&raquo;</a>
		</p>
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp"%>
