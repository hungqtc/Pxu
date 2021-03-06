<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <img src="<%=request.getContextPath() %>/templates/admin/assets/img/find_user.png" class="user-image img-responsive" />
            </li>
            <li>
            	<a id="index" href="<%=request.getContextPath()%>/admin/index"><i class="fa fa-dashboard fa-3x"></i> Trang chủ</a>
        		
               </li>
            
            <li>
                <a id="category" href=""><i class="fa fa-list fa-3x"></i> Quản lý thông tin</a>
           		<ul>
                	<li>
                		<a id="info" href="<%=request.getContextPath()%>/admin/infomation/info/index"><i class="fa fa-list fa-3x"></i> Thông tin</a>
                	</li>
                	<li>
                		<a id="project" href="<%=request.getContextPath()%>/admin/infomation/project/index"><i class="fa fa-list fa-3x"></i> Dự án</a>
                	</li>
                	<li>
                		<a id="skill" href="<%=request.getContextPath()%>/admin/infomation/skill/index"><i class="fa fa-list fa-3x"></i> Kĩ năng</a>
                	</li>
                	<li>
                		<a id="experience" href="<%=request.getContextPath()%>/admin/infomation/experience/index"><i class="fa fa-list fa-3x"></i> Kinh nghiệm</a>
                	</li>
                </ul>
            </li>
            <li>
                <a id="news" href=""><i class="fa fa-music fa-3x"></i> Quản lý bài viết</a>
                <ul>
                	<li>
                		<a id="category" href="<%=request.getContextPath()%>/admin/news/cat/index"><i class="fa fa-list fa-3x"></i> Danh mục</a>
                	</li>
                	<li>
                		<a id="new" href="<%=request.getContextPath()%>/admin/news/new/index"><i class="fa fa-list fa-3x"></i> Tin tức</a>
                	</li>
                	<li>
                		<a id="comment" href="<%=request.getContextPath()%>/admin/news/comment/index"><i class="fa fa-list fa-3x"></i> Bình luận</a>
                	</li>
                </ul>
            </li>
            <li>
                <a id="user" href="<%=request.getContextPath()%>/admin/user/index"><i class="fa fa-user fa-3x"></i> Quản lý người dùng</a>
            </li>
            <li>
                <a id="contact" href="<%=request.getContextPath()%>/admin/contact"><i class="fa fa-envelope fa-3x"></i> Quản lý liên hệ</a>
            </li>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->