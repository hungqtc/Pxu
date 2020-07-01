<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
    <div class="article">
    	<% 
    		Category category  = (Category) request.getAttribute("listCat");
    		if (category != null ) {
    			
    	%>
		<h1><%=category.getName() %></h1>
		<% } %>
    </div>
    <% 
    	ArrayList<Song> listSongById = (ArrayList<Song>) request.getAttribute("listSongById");
    	if (listSongById != null && listSongById.size() > 0) {
    		int i = 0;
    		for(Song song: listSongById) {
    		i++;
    %>
    <div class="article">
      <h2><a href="<%=request.getContextPath()%>/public/detail?id=<%=song.getCat().getId()%>" title="<%=song.getName() %>"><%=song.getName() %></a></h2>
      <p class="infopost">Ngày đăng: <%=song.getDateCreate()%> Lượt xem: <%=song.getCounter() %> <a href="#" class="com"><span><%=i %></span></a></p>
      <div class="clr"></div>
      <div class="img"><img src="<%=request.getContextPath()%>/uploads/<%=song.getPicture()%>" width="177" height="213" alt="<%=song.getName() %>" class="fl" /></div>
      <div class="post_content">
        <p><%=song.getDescription() %></p>
        <p class="spec"><a href="<%=request.getContextPath()%>/public/detail?id=<%=song.getCat().getId()%>" class="rm">Chi tiết &raquo;</a></p>
      </div>
      <div class="clr"></div>
    </div>
    <% } } %>
    
    <%	
    	int numberOfPages = (Integer)request.getAttribute("numberOfPages");
		int currentPage = (Integer)request.getAttribute("currentPage"); 
		ArrayList<Song> listSong = (ArrayList<Song>)request.getAttribute("listSongById");
   		if(listSong != null && listSong.size() > 0) {
	%>
    <p class="pages"><small>Trang 1 của 3</small>
    <% 
    	for (int i = 1; i <= numberOfPages; i++) { 
    %>
    <%if (currentPage == i) { %>
    <span><%=i %></span>
    <% } else { %>
    <a href="<%=request.getContextPath()%>/public/cat?id=<%=category.getId()%>&page=<%=i%>"><%=i %></a>
    <% } } %>
   
    <a href="#">&raquo;</a>
    
    </p>
    <% } %>
  </div>
  <div class="sidebar">
      <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>