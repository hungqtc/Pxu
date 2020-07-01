<%@page import="model.bean.Friend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp"%>

<!---//End-banner---->
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title">Những người bạn</h1>				 
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
					 	<% 
					 	if (request.getAttribute("listFriends") != null) {
					 		ArrayList<Friend> listFriends = (ArrayList<Friend>) request.getAttribute("listFriends");
							if (listFriends.size() > 0) {
								for (Friend objFr : listFriends) {
					 	%>
							 <h3><a href="chi-tiet.jsp"><%=objFr.getName() %></a></h3>
							 <h4>Đăng ngày: <%=objFr.getDate() %> - Lượt xem: <%=objFr.getCount() %></h4>
							 <p><%=objFr.getPreview() %></p>
							 <img src="<%=request.getContextPath() %>/anews/images/anh<%=objFr.getId() %>.jpg" alt=""/>
							 <a class="bttn" href="chi-tiet.jsp">Chi tiết bạn tôi</a>
							 <br/>
							 <%
								} } }
							 %>
					 </div>
				 </div>
				
						 
			 </div>
			 
			 <%@include file="inc/right-bar.jsp"%>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="inc/footer.jsp"%>