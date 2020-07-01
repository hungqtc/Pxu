<%@page import="model.bean.Info"%>
<%@page import="model.dao.InfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer class="ftco-footer ftco-section">
      <div class="container">
        <div class="row mb-5">
        		<%  
        			InfoDAO infoDAO = new InfoDAO();
					Info objInfo = infoDAO.getItem();
					%>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Lets talk about</h2>
              <p><%=objInfo.getContent() %></p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Links</h2>
              <ul class="list-unstyled">
                <li><a href="#home-section"><span class="icon-long-arrow-right mr-2"></span>Home</a></li>
                <li><a href="#about-section"><span class="icon-long-arrow-right mr-2"></span>About</a></li>
                <li><a href="#blog-section"><span class="icon-long-arrow-right mr-2"></span>Blog</a></li>
                <li><a href="#projects-section"><span class="icon-long-arrow-right mr-2"></span>Projects</a></li>
                <li><a href="#contact-section"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Services</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Design</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Development</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Business Strategy</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Data Analysis</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Graphic Design</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	              
	                <li><span class="icon icon-map-marker"></span><span class="text"><%=objInfo.getAdress() %></span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text"><%=objInfo.getPhoneNumber() %></span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text"><%=objInfo.getEmail() %></span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This website is made by Ken <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  
  <script src="<%=request.getContextPath() %>/templates/public/js/popper.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.easing.1.3.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.waypoints.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.stellar.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/owl.carousel.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.magnific-popup.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/aos.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.animateNumber.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/scrollax.min.js"></script>
  
  <script src="<%=request.getContextPath() %>/templates/public/js/main.js"></script>
  
  </body>
</html>