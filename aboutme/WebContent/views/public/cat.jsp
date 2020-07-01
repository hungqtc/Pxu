<%@page import="model.dao.CategoryFatherDAO"%>
<%@page import="model.bean.CategoryFather"%>
<%@page import="utils.StringUtil"%>
<%@page import="model.bean.New"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp"%>

<section class="hero-wrap hero-wrap-2"
	style="background-image: url('<%=request.getContextPath() %>/templates/public/images/bg_4.jpg');"
	data-stellar-background-ratio="0.5">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-end justify-content-center">
			<div class="col-md-9 ftco-animate pb-5 text-center">
				<h1 class="mb-3 bread">Our Stories</h1>
				<p class="breadcrumbs">
					<span class="mr-2"><a
						href="<%=request.getContextPath()%>/public/index">Home <i
							class="ion-ios-arrow-forward"></i></a></span> <span class="mr-2"><a
						href="<%=request.getContextPath()%>/public/blog">Blog <i
							class="ion-ios-arrow-forward"></i></a></span>
				</p>
			</div>
		</div>
	</div>
</section>


<section class="ftco-section">
	<div class="container">
		
		<div class="row">
			<div class="col-lg-8 ftco-animate">
			
				<% 
		
						Category category  = (Category) request.getAttribute("category");
						if (category != null ) {
				%>
				<h2 style="color: #003322"><%=category.getName() %></h2>
				<%  } %>	
				<div class="row">
				<% 
					ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNew");
					if (listNew != null && listNew.size() > 0) {
		    			
		    			for(New news: listNew) {
		    			
				
				%>
				
				<div class="col-sm-4">
					<br> 
					<a href="<%=request.getContextPath()%>/public/detail/<%=StringUtil.makeSlug(news.getName()) %>-<%=news.getId()%>"> <img src="<%=request.getContextPath()%>/uploads/<%=news.getPicture()%>" class="img-responsive"
						style="width: 100%; height: 180px" alt=""><br>
						<h3><%=news.getName() %></h3>
						<br>
					<br>
					</a>
					
				</div>
				<% } }  %>
				</div>
				<div>
				
					
						<nav class="blog-pagination justify-content-center d-flex">
						<ul class="pagination">
							<!-- <li class="page-item">
								<a href="#" class="page-link" aria-label="Previous">
									<span aria-hidden="true">
										<span class="lnr lnr-chevron-left"></span>
									</span>
								</a>
							</li> -->
							<%
					
			    		int numberOfPages = (Integer)request.getAttribute("numberOfPages");
						int currentPage = (Integer)request.getAttribute("currentPage"); 
						ArrayList<New> listNewById = (ArrayList<New>)request.getAttribute("listNew");
			   			if(listNewById != null && listNewById.size() > 0) {
			   			for (int i = 1; i <= numberOfPages; i++) {
						
					%>
					
							<li class="page-item">
							<%if (currentPage == i) { %>
							<span><%=i %></span>
							<%} else { %>					
							<a href="<%=request.getContextPath()%>/public/cat/<%=StringUtil.makeSlug(category.getName()) %>-<%=category.getId()%>&page=<%=i%>"><%=i %></a>
							<% } } %>
							</li>
							
						</ul>
					</nav>
					
					<% }  %>
					<!-- <li class="page-item">
								<a href="#" class="page-link" aria-label="Next">
									<span aria-hidden="true">
										<span class="lnr lnr-chevron-right">&raquo;</span>
									</span>
								</a>
							</li> -->
				</div>
				
				
			
			</div>
			<!-- .col-md-8 -->
			<div class="col-lg-4 sidebar ftco-animate">

				<div class="sidebar-box ftco-animate">
					<h3 class="heading-sidebar">Categories</h3>
					<ul class="categories">
						<%
              	
              		CategoryDAO catDAO = new CategoryDAO();
					CategoryFatherDAO catFatherDAO = new CategoryFatherDAO();
					
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
    					<a class= "dropdown-item" 
							href="<%=request.getContextPath()%>/public/cat/<%=StringUtil.makeSlug(objCat.getName()) %>-<%=objCat.getId()%>"><%=objCat.getName() %>
						</a>
						<div class="dropdown-divider"></div>
						<% } %>
  						</div>
					</div>
						
						<% } }  %>
					</li>
					</ul>
				</div>


			</div>

		</div>

		</p>
	</div>
</section>
<!-- .section -->

<%@ include file="/templates/public/inc/footer.jsp"%>