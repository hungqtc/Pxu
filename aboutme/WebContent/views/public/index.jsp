<%@page import="utils.StringUtil"%>
<%@page import="utils.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="model.bean.Experience"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.Info"%>
<%@page import="model.bean.New"%>
<%@page import="model.bean.Project"%>
<%@page import="model.bean.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ include file="/templates/public/inc/header.jsp" %>
	  
	  <section id="home-section" class="hero">
		  <div class="home-slider  owl-carousel">
	      <div class="slider-item ">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row d-md-flex no-gutters slider-text align-items-end justify-content-end" data-scrollax-parent="true">
	          	<div class="one-third order-md-last img" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/hung.jpg);">
	          		<div class="overlay"></div>
	          	</div>
		          <div class="one-forth d-flex  align-items-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
		          	<a href="https://vimeo.com/45830194" class="icon-video popup-vimeo d-flex justify-content-center align-items-center">
	    						<span class="ion-ios-play play"></span>
	    					</a>
		          	<div class="text">
		          		<span class="subheading">Hello</span>
			            <h1 class="mb-4 mt-3">I'm <span>Hung</span></h1>
			            <h2 class="mb-4">A Web Developer</h2>
			            <p><a href="#" class="btn-custom">Hire me</a></p>
		            </div>
		          </div>
	        	</div>
	        </div>
	      </div>

	      <div class="slider-item">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row d-flex no-gutters slider-text align-items-end justify-content-end" data-scrollax-parent="true">
	          	<div class="one-third order-md-last img" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/bg_2.jpg);">
	          		<div class="overlay"></div>
	          	</div>
		          <div class="one-forth d-flex align-items-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
		          	<a href="https://vimeo.com/45830194" class="icon-video popup-vimeo d-flex justify-content-center align-items-center">
	    						<span class="ion-ios-play play"></span>
	    					</a>
		          	<div class="text">
			            <h1 class="mb-4 mt-3">I'm a <span>Web Developer</span> from Viet Nam</h1>
			            <p><a href="#" class="btn-custom">Hire me</a></p>
		            </div>
		          </div>
	        	</div>
	        </div>   
	      </div>
	    </div>
    </section>

    <section class="ftco-about ftco-counter img ftco-section" id="about-section">
    	<div class="container">
    		<div class="row d-flex">
    			<div class="col-md-6 col-lg-5 d-flex">
    				<div class="img-about img d-flex align-items-stretch">
    					<div class="overlay"></div>
	    				<div class="img d-flex align-self-stretch align-items-center" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/about-1.jpg);">
	    				</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-7 pl-lg-5 py-5">
    				<div class="row justify-content-start pb-3">
		          <div class="col-md-12 heading-section ftco-animate">
		          	<span class="subheading">Welcome</span>
		            <h2 class="mb-4" style="font-size: 34px; text-transform: capitalize;">About Me</h2>
		            <p>I am studying JAVA at VinaEnter center.I want to be Web Developer in the future. Love music....</p>
		          </div>
		        </div>
		        
	          <div class="counter-wrap ftco-animate d-flex mt-md-3">
              <div class="text p-4 pr-5 bg-primary">
              	<p class="mb-0">
              		<% 
              			
              			if(request.getAttribute("countProject") != null) {
              				
              		%>
	                <span class="number" data-number="<%=request.getAttribute("countProject")%>">0</span>
	                <span>Finished Projects</span>
	                <% } %>
                </p>
              </div>
	          </div>
	        </div>
        </div>
    	</div>
    </section>
		
		<section class="ftco-section bg-light" id="skills-section">
			<div class="container">
				<div class="row justify-content-center pb-5">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">Skills</span>
            <h2 class="mb-4">My Skills</h2>
            <p>No pain - No gain</p>
          </div>
        </div>
				<div class="row">
				<% 
							int i = 0;
							if(request.getAttribute("listSkill") != null) {
								ArrayList<Skill> listSkill	= (ArrayList<Skill>)request.getAttribute("listSkill");
								if(listSkill.size() > 0) {
									for (Skill objSkill: listSkill) { 
									i++;
								
								%>
					<div class="col-md-6 animate-box">
						<div class="progress-wrap ftco-animate">
							
							<h3><%=objSkill.getName() %></h3>
							<div class="progress">
							 	<div class="progress-bar color-<%=i %>" role="progressbar" aria-valuenow="<%=objSkill.getValue() %>"
							  	aria-valuemin="0" aria-valuemax="100" style="width:<%=objSkill.getValue() %>%">
							    <span><%=objSkill.getValue() %>%</span>
							  	</div>
							</div>
							
						</div>
					</div>
					
					<% } } } %>
					
				</div>
				
			</div>
		</section>

		<section class="ftco-section ftco-hireme">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-lg-9 d-flex align-items-center ftco-animate">
						<h2>I'm <span>Available</span> For Freelancing</h2>
					</div>
					<div class="col-md-4 col-lg-3 d-flex align-items-center ftco-animate">
						<p class="mb-0"><a href="#" class="btn btn-white py-4 px-5">Hire me</a></p>
					</div>
				</div>
			</div>
		</section>
 
	
    <section class="ftco-section ftco-project" id="projects-section">
    	<div class="container">
    		<div class="row justify-content-center pb-5">
          <div class="col-md-12 heading-section text-center ftco-animate">
            <h2 class="mb-4">My Projects</h2>
          </div>
        </div>
    		<div class="row">
    			<% if(request.getAttribute("listProject") != null) {
					
					ArrayList<Project> listProject = (ArrayList<Project>)request.getAttribute("listProject");
					if(listProject.size() > 0) {
						for(Project objProject:listProject) {
					%>
						
    			<div class="col-md-6">
    				<div class="project img ftco-animate img-2 d-flex justify-content-center align-items-center" 
    				style="background-image: url(<%=request.getContextPath() %>/uploads/<%=objProject.getPicture()%>);">
    					<div class="overlay"></div>
	    				<div class="text text-center p-4">
	    					<h3><a href="#"></a><%=objProject.getPreview() %></h3>
	    				</div>
    				</div>
    			</div>
    			<% } } } %>
    		</div>
    	</div>
    </section>

<section class="colorlib-experience" data-section="experience" id="experience-section">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<span class="heading-meta">Experience</span>
							<h2 class="colorlib-heading animate-box">Work Experience</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
				         <div class="timeline-centered">
				         	 <% 
				         	 int iconColor = 0;
				         	 
				         	if(request.getAttribute("listExperience") != null) {
								
								ArrayList<Experience> listExperience = (ArrayList<Experience>)request.getAttribute("listExperience");
								if(listExperience.size() > 0) {
									for(Experience objExperience: listExperience) {
				         	 			iconColor++;
				         	 			Date date = objExperience.getTime();
				         	 %>
					         <article class="timeline-entry animate-box" data-animate-effect="fadeInLeft">
					            <div class="timeline-entry-inner">

					               <div class="timeline-icon color-<%=iconColor%>">
					                  <i class="icon-pen2"></i>
					               </div>

					               <div class="timeline-label">
					               		 
					                  <h2><span><%=DateUtil.convert2(date) %></span></h2>
					                  <p><%=objExperience.getName() %></p>
					               </div>
					            </div>
					           
					         </article>
							 <% } } } %>
					      				   			         					        
					        
					      </div>
					   </div>
				   </div>
				</div>
			</section>
    <section class="ftco-section bg-light" id="blog-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <span class="subheading">Blog</span>
            <h2 class="mb-4">My Blog</h2>
          </div>
        </div>
        <div class="row d-flex">
        	<%
        	if(request.getAttribute("listNewsTop") != null) {
				
				ArrayList<New> listNewsTop = (ArrayList<New>)request.getAttribute("listNewsTop");
				if(listNewsTop.size() > 0) {
					for(New objNew:listNewsTop) {
        	
        	%>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="<%=request.getContextPath() %>/public/detail/<%=StringUtil.makeSlug(objNew.getName()) %>-<%=objNew.getId() %>" class="block-20" style="background-image: url('<%=request.getContextPath() %>/uploads/<%=objNew.getPicture()%>');">
              </a>
              <div class="text mt-3 float-right d-block">
              	<div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2"><%=objNew.getDateCreate() %></span>
	                	<a href="#" class="mr-2">Admin</a>
	                	<a href="#" class="meta-chat"><span class="icon-chat"></span><%=objNew.getCounter() %></a>
	                </p>
                </div>
                <h3 class="heading"><a href="<%=request.getContextPath() %>/public/detail/<%=StringUtil.makeSlug(objNew.getName()) %>-<%=objNew.getId() %>"><%=objNew.getName() %></a></h3>
                <p><%=objNew.getPreview() %></p>
              </div>
            </div>
          </div>
          <% } } } %>
        </div>
      </div>
    </section>

    <section class="ftco-section contact-section ftco-no-pb" id="contact-section">
      <div class="container">
      	<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <span class="subheading">Contact</span>
            <h2 class="mb-4">Contact Me</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
          </div>
        </div>

        <div class="row no-gutters block-9">
          <div class="col-md-6 order-md-last d-flex">
            <form id="formcontact" action="<%=request.getContextPath() %>/public/contact" method = "post" class="bg-light p-4 p-md-5 contact-form">
              <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;						
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm liên hệ thành công"));
									break;
									}
								}
       
							%>
              <div class="form-group">
                <input type="text" id="namecontact" name="name" class="form-control" placeholder="Your Name" required="required">
              </div>
              <div class="form-group">
                <input type="text" id="emailcontact" name="email" class="form-control" placeholder="Your Email" required="required">
              </div>
              <div class="form-group">
                <textarea name="message" id="messcontact" cols="30" rows="7" class="form-control" placeholder="Message" required="required"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" value="Send Message" class="btn btn-primary py-3 px-5">
              </div>
            </form>
          
          </div>

          <div class="col-md-6 d-flex">
          	<div class="img" style="background-image: url(<%=request.getContextPath() %>/templates/public/images/about.jpg);"></div>
          </div>
        </div>
      </div>
    </section>
    
	<script>
     
</script>
      <%@ include file="/templates/public/inc/footer.jsp" %>
      