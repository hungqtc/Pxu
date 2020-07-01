<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
    <div class="article">
      <%
				if (request.getAttribute("listSong") != null) {
					ArrayList<Song> listSong = (ArrayList<Song>) request.getAttribute("listSong");
					if (listSong.size() > 0) {
						int i = 0;
						for (Song objSong : listSong) {
							i++;
			%>
			<h2>
				<a href="<%=request.getContextPath()%>/public/detail?id=<%=objSong.getCat().getId()%>" title="<%=objSong.getName()%>"><%=objSong.getName()%></a>
			</h2>
			<p class="infopost">
				Ngày đăng:
				<%=objSong.getDateCreate()%>
				Lượt xem:
				<%=objSong.getCounter()%>
				<a href="#" class="com"><span><%=i %></span></a>
			</p>
			<div class="clr"></div>
			<div class="img">
				<img
					src="<%=request.getContextPath()%>/uploads/<%=objSong.getPicture()%>"
					width="177" height="213" alt="<%=objSong.getName()%>" class="fl" />
			</div>
			<div class="post_content">
				<p><%=objSong.getDescription()%></p>
				<p class="spec">
					<a href="<%=request.getContextPath()%>/public/detail?id=<%=objSong.getCat().getId()%>" class="rm">Chi tiết &raquo;</a>
				</p>
			</div>
			<div class="clr"></div>
			<%
				}
					}
				}
			%>
    </div>
    <p class="pages"><small>Trang 1 của 5</small>
    <span>1</span>
    <a href="">2</a>
    <a href="">3</a>
    <a href="">4</a>
    <a href="">5</a>
    <a href="#">&raquo;</a></p>
  </div>
  <div class="sidebar">
      <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
