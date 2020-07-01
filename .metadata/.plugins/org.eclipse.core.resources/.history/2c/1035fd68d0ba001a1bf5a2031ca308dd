<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglibs.jsp" %>
<div class="clearfix main_content floatleft">
				
					<div class="clearfix slider">
						<ul class="pgwSlider">
						<c:forEach items="${landhot }" var="landHot">
							<li><img src="images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars"/></li>
							<li>
								<img src="images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
							</li>
							</c:forEach>
						</ul>
					</div>
					
					<div class="clearfix content">
						<div class="content_title"><h2>Bài viết mới</h2></div>
						<c:forEach items="${listCland }" var="cland">
						<div class="clearfix single_content">
							<div class="clearfix post_date floatleft">
								<div class="date">
									
									<p>${cland.dateCreate}</p>
								</div>
							</div>
							<div class="clearfix post_detail">
								<h2><a href="">${cland.landName} </a></h2>
								<div class="clearfix post-meta">
									<p><span><i class="fa fa-clock-o"></i> ${cland.address }</span> <span><i class="fa fa-folder"></i> Diện tích: ${cland.area }</span></p>
								</div>
								<div class="clearfix post_excerpt">
									<img src="${pageContext.request.contextPath }/uploads/${cland.picture}" alt=""/>
									<p>${cland.description.substring(0, 150) } </p>
								</div>
								<a href="${pageContext.request.contextPath }/cland/detail/${SlugUtil.makeSlug(cland.name)}-${cland.id}">Đọc thêm</a>
							</div>
						</div>
						</c:forEach>
						
					</div>
					<c:if test="${not empty totalPage }">
					<div class="pagination">
						<nav>
							<ul>
							<li><a href=""> << </a></li>
							<c:choose>
								<c:when test="${totalPage<=1 }">
								<li><a href="${pageContext.request.contextPath }/home/page/1">1</a></li>
								</c:when>
				
								<c:otherwise>
								<c:forEach begin="1" end="${totalPage }" var="i">
								<li <c:if test="${i==page }">class='active'</c:if>><a href="${pageContext.request.contextPath }/home/${i}">${i }</a></li>
								</c:forEach>
								</c:otherwise>
								</c:choose>
								<li><a href=""> >> </a></li>
							</ul>
						</nav>
					</div>
					</c:if>
				</div>