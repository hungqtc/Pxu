<%@page import="model.bean.CategoryFather"%>
<%@page import="model.dao.CategoryFatherDAO"%>
<%@page import="utils.StringUtil"%>
<%@page import="model.bean.Comment"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.New"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>

	  <section class="hero-wrap hero-wrap-2" style="background-image: url('<%=request.getContextPath() %>/templates/public/images/bg_4.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate pb-5 text-center">
            <h1 class="mb-3 bread">Our Stories</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="<%=request.getContextPath()%>/public/index">Home <i class="ion-ios-arrow-forward"></i></a></span> <span class="mr-2"><a href="<%=request.getContextPath()%>/public/blog">Blog <i class="ion-ios-arrow-forward"></i></a></span></p>
          </div>
        </div>
      </div>
    </section>
		

    <section class="ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 ftco-animate">
          
          	<%  
          	if(request.getAttribute("listNew") != null) {
				
				ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNew");
				if(listNew.size() > 0) {
					for(New objNew:listNew) {
          	
          	%>
            <h2 class="mb-3"><%=objNew.getName() %></h2>
            <br>
            <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<a href="#" class="mr-2">Admin</a>
	                	<a href="#" class="meta-chat"><span class="icon-chat"></span><%=objNew.getCounter() %></a>
	                </p>
                </div>
             <div> 
             	<%=objNew.getDetail() %>
             </div>
             
            
            <% } } } %>
            
          
			
            <div class="pt-5 mt-5">
              <h3 class="mb-5"> Comments</h3>
              <ul class="comment-list">
				<%  
				int id = Integer.parseInt(request.getParameter("id"));
          		if(request.getAttribute("listComment") != null) {
				
				ArrayList<Comment> listComment = (ArrayList<Comment>)request.getAttribute("listComment");
				if(listComment.size() > 0) {
					for(Comment objComment :listComment) {
						if(id == objComment.getNews().getId()){
          	
          	%>
                <li class="comment">
                  <div class="vcard bio">
                    <img src="<%=request.getContextPath()%>/templates/public/images/loc.png" alt="Image placeholder">
                  </div>
                  <div class="comment-body">
                    <h3><%=objComment.getName() %></h3>
                    <div class="meta"><%=java.time.LocalDateTime.now() %></div>
                    <p><%=objComment.getMessage() %></p>
                  </div>
                </li>
                <% } } } }%>
              </ul>
              <!-- END comment-list -->
              
              <div class="comment-form-wrap pt-5">
              
                
                <form action="javascript:void(0)" class="p-5 bg-light" method="GET">
                  <div class="form-group">
                    <label for="name">Name </label>
                    <input type="text" class="form-control" id="name" name = "name" required="required">
                  </div>
                  <div class="form-group">
                    <label for="message">Message</label>
                    <textarea name="message" id="message" cols="30" rows="10" class="form-control" required="required"></textarea>
                  </div>
                  <div class="form-group">
                    <input type="submit" onclick="return getComment()" value="Post Comment" class="btn py-3 px-4 btn-primary">
                  </div>
			
                </form>
               
              </div>
            </div>

          </div> <!-- .col-md-8 -->
          <div class="col-lg-4 sidebar ftco-animate">
            
            <div class="sidebar-box ftco-animate">
            	<h3 class="heading-sidebar">Categories</h3>
              <ul class="categories">
              	<%	
              		
              	 	New objNewCat =	(New)request.getAttribute("objNewCat");
                   	CategoryFatherDAO catFatherDAO = new CategoryFatherDAO();
              		CategoryDAO catDAO = new CategoryDAO();
              		
              		ArrayList<CategoryFather> listCatFather = catFatherDAO.getItems();
					if(listCatFather.size() > 0) {
						for (CategoryFather objCatFather: listCatFather) {
					
								
              	%>
              	<li>
              	<div class="btn-group dropleft">
  						
  						<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   						<%=objCatFather.getName() %>
  						</button>
  						
  					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
  						<%  
  						ArrayList<Category> listCat	= catDAO.getItemsByFather(objCatFather.getId());
  						for (Category objCat: listCat) {%>
    					<a <%if (objNewCat.getCat().getId() == objCat.getId()){ %>
                
                		style="background-color: red" <%  } %> 
               			 href="<%=request.getContextPath()%>/public/cat/<%=StringUtil.makeSlug(objCat.getName()) %>-<%=objCat.getId()%>"><%=objCat.getName() %> </a>
						<div class="dropdown-divider"></div>
						<% } %>
  						</div>
					</div>
						
						<% } }  %>
					</li>
                
              </ul>
            </div>
			
            <div class="sidebar-box ftco-animate">
              <h3 class="heading-sidebar">Related News</h3>
              <%  if(request.getAttribute("listRelatedNews") != null) {
				
				ArrayList<New> listRelatedNews = (ArrayList<New>)request.getAttribute("listRelatedNews");
				if(listRelatedNews.size() > 0) {
					for(New objNew: listRelatedNews) { %>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" style="background-image: url(<%=request.getContextPath() %>/uploads/<%=objNew.getPicture()%>);"></a> 
                <div class="text">													
                  <h3 class="heading"><a href="<%=request.getContextPath()%>/public/detail/<%=StringUtil.makeSlug(objNew.getName()) %>-<%=objNew.getId()%>"><%=objNew.getName() %></a></h3>
                  <div class="meta">
                    <div><a href="#"><span class="icon-calendar"></span> <%=objNew.getDateCreate() %></a></div>
                    <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                    <div><a href="#"><span class="icon-chat"></span> <%=objNew.getCounter() %></a></div>
                  </div>
                </div>
              </div>
              <% } } } %>
            </div>
          </div>

        </div>
      </div>
    </section> <!-- .section -->
<script type="text/javascript">
 		function getComment() {
		var name = $("#name").val();
		var message = $("#message").val();
		var id = <%=request.getParameter("id")%>;
		
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/comment/add",
			type: 'GET',
			cache: false,
			data: {
				'aid': id, 
				'aname': name, 
				'amessage': message
				},
			success: function(data){
				
				$(".comment-list").html(data);
			},
			error: function (){
				alert('Có lỗi xãy ra!');
			}
		});
		return false;
	}
</script>

     <%@ include file="/templates/public/inc/footer.jsp" %>