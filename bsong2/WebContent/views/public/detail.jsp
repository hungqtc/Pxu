<%@page import="model.bean.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  	<% Song objSong = (Song) request.getAttribute("objSong");
  		if (objSong != null) {
  	%>
    <div class="article">
    	
      <h1><%=objSong.getName() %></h1>
      <div class="clr"></div>
      <p>Ngày đăng: <%=objSong.getDate_create() %>. Lượt xem: <%=objSong.getCounter() %></p>
      <div class="vnecontent">
          <%=objSong.getPreview()%>
      </div>
   <% } %>
    </div>
    <div class="article">
      <h2>Bài viết liên quan</h2>
      <div class="clr"></div>
      <div class="comment"> <a href=""><img src="<%=request.getContextPath() %>/templates/public/images/only-love.jpg" width="40" height="40" alt="" class="userpic" /></a>
        <h2><a href="">Only Love</a></h2>
        <p>có phải một ngày nào đó em cũng mãi xa cuộc đời tôi ! có phải tôi vẫn luôn là người ngộ nhận về một câu chuyện tình yêu tuyệt đẹp !</p>
      </div>
    </div>
  </div>
  <div class="sidebar">
  <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
