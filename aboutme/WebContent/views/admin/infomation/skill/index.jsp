
<%@page import="model.bean.Skill"%>
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
				<h2>Quản lý Kỹ Năng</h2>
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
									<a href="<%=request.getContextPath() %>/admin/infomation/skill/add" class="btn btn-success btn-md">Thêm</a>
								</div>

							</div>
							<%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm kỹ năng thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa kỹ năng thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa kỹ năng thành công"));
									break;
									}
								}
							%>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên kỹ năng</th>
										<th>Giá trị(%)</th>
										<th width="160px">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%  
										if(request.getAttribute("listSkill") != null) {
										ArrayList<Skill> listSkill	= (ArrayList<Skill>)request.getAttribute("listSkill");
											if(listSkill.size() > 0) {
												for (Skill objSkill: listSkill) {
													String urlDel = request.getContextPath()+"/admin/infomation/skill/del?id=" +objSkill.getId();
													String urlEdit = request.getContextPath()+"/admin/infomation/skill/edit?id=" +objSkill.getId();
									%>
									<tr>
										<td><%=objSkill.getId() %></td>
										<td class="center"><%=objSkill.getName() %></td>
										<td class="center"><%=objSkill.getValue()%></td>
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