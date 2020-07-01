<%@page import="utils.DateUtil"%>
<%@page import="model.bean.Experience"%>
<%@page import="model.bean.New"%>
<%@page import="model.bean.Category"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý kinh nghiệm</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm kinh nghiệm thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa kinh nghiệm thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa kinh nghiệm thành công"));
									break;
									case 5: out.print(CodeMessageUtil.displayMessage(out, "ID không tồn tại"));
									break;
									}
								}
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
                                    <a href="<%=request.getContextPath() %>/admin/infomation/experience/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên </th>
                                        <th>Thời gian </th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% 
										if(request.getAttribute("listExperience") != null) {
										
											ArrayList<Experience> listExperience = (ArrayList<Experience>)request.getAttribute("listExperience");
											if(listExperience.size() > 0) {
												for(Experience objExperience:listExperience) {
													String urlDel = request.getContextPath()+"/admin/infomation/experience/del?id=" +objExperience.getId();
													String urlEdit = request.getContextPath()+"/admin/infomation/experience/edit?id=" +objExperience.getId();
									%>
                                    <tr>
                                        <td><%=objExperience.getId() %></td>
                                        <td class="center"><%=objExperience.getName() %></td>
                                         <td class="center"><%=DateUtil.convert2(objExperience.getTime()) %></td>
                                        <td class="center">
                                            <a href="<%=urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=urlDel %>" title="" onclick="return confirm('Bạn có chắc muốn xóa?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
									<% } } } %>
                                </tbody>
                            </table>
                           <%--  
                            <% 
                            	int numberOfPages = (int)request.getAttribute("numberOfPages");
                           		int currentPage = (int)request.getAttribute("currentPage"); 
                           		ArrayList<Song> listSong = (ArrayList<Song>)request.getAttribute("listSong");
                           		if(listSong != null && listSong.size() > 0) {
                            %> --%>
                            <div class="row">
                                
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <%-- <ul class="pagination">
                                            <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Trang trước</a></li>
                                           	<%
                                           		String active = "";
                                           		for (int i = 1; i <= numberOfPages; i++) { 
                                           			if(currentPage == i) {
                                           				active = "active";
                                           			} else {
                                           				active = "";
                                           			}
                                           	%>
                                            <li class="paginate_button <%=active %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/song/index?page=<%=i%>"><%=i %></a></li>
                                            <% } %>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
                                        </ul> --%>
                                    </div>
                                </div>
                            </div>
                           <%--  <% } %> --%>
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
<%@ include file="/templates/admin/inc/footer.jsp" %>