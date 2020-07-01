﻿<%@page import="utils.CodeMessageUtil"%>
<%@page import="model.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý người dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm người dùng thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa người dùng thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa người dùng thành công"));
									break;
									case 4: out.print(CodeMessageUtil.displayMessage(out, "Người dùng đã tồn tại"));
									break;
									case 5: out.print(CodeMessageUtil.displayMessage(out, "ID không tồn tại"));
									break;
									case 6: out.print(CodeMessageUtil.displayMessage(out, "Không có quyền thêm"));
									break;
									case 7: out.print(CodeMessageUtil.displayMessage(out, "Không có quyền xóa"));
									break;
									case 8: out.print(CodeMessageUtil.displayMessage(out, "Không có quyền sửa"));
									break;
									
									}
								}
      								User userLogin =  (User)session.getAttribute("userInfo");
							%>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath() %>/admin/user/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Họ tên</th>                 
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%	
                                		if(request.getAttribute("listUser") != null) {
                                		ArrayList<User> listUser = (ArrayList<User>)request.getAttribute("listUser");
                                		if(listUser.size() > 0) {
                                			for( User objUser: listUser) {
                                				String urlDel = request.getContextPath()+"/admin/user/del?id=" +objUser.getId();
												String urlEdit = request.getContextPath()+"/admin/user/edit?id=" +objUser.getId();
                                	%>
                                    <tr>
                                        <td><%=objUser.getId() %></td>
                                        <td class="center"><%=objUser.getUsername() %> </td>
                                        <td class="center"><%=objUser.getFullname() %></td>   
                                        
                                        <%if("admin".equals(userLogin.getUsername())) { %>                                     
                                        <td class="center">
                                            <a href="<%=urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=urlDel %>" title="" onclick="return confirm('Bạn có chắc muốn xóa?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                        <% } else { %>
                                         <td class="center">
                                         	<%if(userLogin.getId() == objUser.getId()) { %>
                                            <a href="<%=urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                        <% } %>
                                        </td>
                                        <% } %>
                                    </tr>	
                                    <% } } } %>				
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 5 của 24 truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Trang trước</a></li>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="">1</a></li>
											<li class="paginate_button" aria-controls="dataTables-example" tabindex="0"><a href="">2</a></li>
											<li class="paginate_button" aria-controls="dataTables-example" tabindex="0"><a href="">3</a></li>
											<li class="paginate_button" aria-controls="dataTables-example" tabindex="0"><a href="">4</a></li>
											<li class="paginate_button" aria-controls="dataTables-example" tabindex="0"><a href="">5</a></li>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>