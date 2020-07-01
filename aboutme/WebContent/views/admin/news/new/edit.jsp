
<%@page import="model.bean.New"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Sửa tin tức</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		
		<%
							String name = "";
							String catId = "";
							String preview = "";
							String detail = "";
							String picture = "";
							New objOldNew = (New) request.getAttribute("objOldNew");
							if(objOldNew != null) {
								name = objOldNew.getName();
								catId = String.valueOf(objOldNew.getCat().getId());
								preview = objOldNew.getPreview();
								detail = objOldNew.getDetail();
								picture = objOldNew.getPicture();
							}
							%>
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" method="post" enctype="multipart/form-data"
									id="form">
									<div class="form-group">
										<label for="name">Tên tin tức</label> <input type="text"
											id="name" value="<%=name %>" name="name" class="form-control" required="required" />
									</div>
									<div class="form-group">
										<label for="category">Danh mục tin</label> 
										<select
											id="category" name="category" class="form-control" required="required">
											
											<%
												if (request.getAttribute("listCat") != null) {

													ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
													if (listCat.size() > 0) {
														for (Category objCat : listCat) {
											%>
										
											<option value="<%=objCat.getId()%>"><%=objCat.getName()%></option>
											<%
												}
													}
												}
											%>
										</select>
									</div>
									<div class="form-group">
										<label for="picture">Hình ảnh</label> <input type="file"
											name="picture" />
											<% if(!objOldNew.getPicture().isEmpty()) { %>
                                        </br>
                                       	<img width="200px" height="200px" alt="picture" src="<%=request.getContextPath()%>/uploads/<%=picture%>">
                                        <% } %>
									</div>
									<div class="form-group">
										<label for="preview">Mô tả</label>
										<textarea id="preview" class="form-control" rows="3"
											name="preview" required="required"><%=preview %></textarea>
									</div>
									<div class="form-group">
										<label for="detail">Chi tiết</label>
										<textarea id="detail" class="form-control" id="detail"
											rows="5" name="detail"><%=detail %></textarea>
									</div>
									<button type="submit" name="submit"
										class="btn btn-success btn-md">Sửa</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
		<!-- /. ROW  -->
	</div>
	<!-- /. PAGE INNER  -->
</div>

<script>
    var ckeditor = CKEDITOR.replace('detail');
    CKFinder.setupCKEditor(ckeditor, '${pageContext.request.contextPath}/libraries/ckfinder/');
    
</script>
<script>
    $().ready(function() {
    	//validate form when submit
    	var validater = $("#form").validate({
    		errorPlacement: function(error, element){
    			$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
    		},
    		errorElement: "span",
    		messages: {
    			name:  {
    				required: "(Tên bài hát không được trống)",
    			},
    			category:  {
					required: "(Chọn danh mục)",
				},
	    		preview:  {
					required: "(Mô tả không được trống)",
				}
    		}
    	});
    			
    });
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>