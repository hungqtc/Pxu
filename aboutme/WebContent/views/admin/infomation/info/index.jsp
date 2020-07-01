
<%@page import="model.bean.Info"%>
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
				<h2>Quản lý Thông Tin</h2>
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
							
							<%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa thông tin thành công"));
									break;
									}
								}
							%>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên</th>
										<th>Địa chỉ</th>
										<th>Số điện thoại</th>
										<th>Email</th>
										<th>Nội dung</th>
										<th width="160px">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%  
										if(request.getAttribute("objInfo") != null) {
										Info objInfo= (Info)request.getAttribute("objInfo");
											
										
										String urlEdit = request.getContextPath()+"/admin/infomation/info/edit?id=" +objInfo.getId();
									%>
									<tr>
										<td class="center"><%=objInfo.getId() %></td>
										<td class="center"><%=objInfo.getName() %></td>
										<td class="center"><%=objInfo.getAdress() %></td>
										<td class="center"><%=objInfo.getPhoneNumber() %></td>
										<td class="center"><%=objInfo.getEmail() %></td>
										<td class="center"><%=objInfo.getContent()%></td>
										<td class="center">
										<a href="<%=urlEdit %>" title="" class="btn btn-primary center"><i class="fa fa-edit "></i> Sửa</a>
										
										</td>
									</tr>
								<% 
										} 
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