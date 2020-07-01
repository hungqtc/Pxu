<%@page import="model.bean.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<div class="article">
			<h1>Nhạc trẻ</h1>
		</div>
		<div class="article">
			<%
				if (request.getAttribute("listSongById") != null) {
					ArrayList<Song> listSongById = (ArrayList<Song>) request.getAttribute("listSongById");
					if (listSongById.size() > 0) {
						for (Song objSong : listSongById) {
			%>

			<h2>
				<a
					href="<%=request.getContextPath()%>/chi-tiet?sid=<%=objSong.getCatId()%>"
					title="Đổi thay"><%=objSong.getName()%></a>
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
				<img src="<%=request.getContextPath()%>/public/images/doi-thay.jpg"
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
	</div>
	<div class="sidebar">
		<%@ include file="/templates/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp"%>