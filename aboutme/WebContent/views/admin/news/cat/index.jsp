
<%@page import="model.bean.Category"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Quản lý danh mục</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<div class="row">
								<div class="col-sm-6">
									<a href="<%=request.getContextPath() %>/admin/news/cat/add" class="btn btn-success btn-md">Thêm</a>
								</div>

							</div>
							<%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm danh mục thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa danh mục thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa danh mục thành công"));
									break;
									}
								}
							%>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên danh mục</th>

										<th width="160px">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%  
										if(request.getAttribute("listCat") != null) {
										ArrayList<Category> listCat	= (ArrayList<Category>)request.getAttribute("listCat");
											if(listCat.size() > 0) {
												for (Category objCat: listCat) {
													String urlDel = request.getContextPath()+"/admin/news/cat/del?id=" +objCat.getId();
													String urlEdit = request.getContextPath()+"/admin/news/cat/edit?id=" +objCat.getId();
									%>
									<tr>
										<td><%=objCat.getId() %></td>
										<td class="center"><%=objCat.getName() %></td>

										<td class="center">
										<a href="<%=urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
										<a href="<%=urlDel %>" title="" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
										</td>
									</tr>
								<% 
										} } }
								%> 
								</tbody>
							</table>

						</div>

					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>
	</div>
</div>
<script>
	document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>