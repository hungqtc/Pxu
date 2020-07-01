<%@page import="model.bean.Friend"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="inc/header.jsp"%>
<!---//End-banner---->
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title"><span>Những người bạn >> </span>Bạn quen thời phổ thông</h1>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							
							 <% 
							 	ArrayList<Friend> listFriends = (ArrayList<Friend>)request.getAttribute("listFriendbyID");
								if(listFriends.size() > 0) {
									for (Friend objFriend : listFriends) {
								
							 %>
							  <h3><a href="chi-tiet.jsp"><%=objFriend.getName() %></a></h3>
							 <h4>Đăng ngày: <%=objFriend.getDate() %> - Lượt xem: <%=objFriend.getCount() %>></h4>
							 <p><%=objFriend.getPreview() %> </p>
							 <img src="images/anh1.jpg" alt=""/>
							 <a class="bttn" href="chi-tiet.jsp">Chi tiết bạn tôi</a>
							 <% 
									} 
									}
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