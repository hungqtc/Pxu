<%@page import="model.bean.Category"%>
<%@page import="utils.CodeMessageUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Song"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý bài hát</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm bài hát thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa bài hát thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa bài hát thành công"));
									break;
									case 5: out.print(CodeMessageUtil.displayMessage(out, "ID không tồn tại"));
									break;
									case 9: out.print(CodeMessageUtil.displayMessage(out, "Không tìm thấy bài hát"));
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
                                    <a href="<%=request.getContextPath() %>/admin/song/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="get" action="<%=request.getContextPath()%>/admin/song/index">
                                    <input type="search"  name="sname" value="<% if(request.getParameter("sname") != null) out.print(request.getParameter("sname")); %>" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 250px;" />
                                        <select name="scat" class="btn btn-warning btn-sm" style="float:right;margin-right: 5px;">																																																																																																																	cat"  class="btn" style="float:right; margin-right: 10px;">
                                        	<option value="0"> -- Chọn danh mục --</option>
                                        	<%
                                        		if(request.getAttribute("listCat")!= null) {
                                        			ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
                                        			if(listCat.size() > 0) {
                                        				for(Category cat: listCat)	{
                                        			
                                        	%>
                                         	<option value="<%=cat.getId()%>"> <%=cat.getName() %></option>
                                         	
                                         	
                                         	<% } } } %>
                                        </select>
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right;margin-right: 5px;" />
                                        
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên bài hát</th>
                                        <th>Danh mục</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% 
										if(request.getAttribute("listSong") != null) {
										
											ArrayList<Song> listSong = (ArrayList<Song>)request.getAttribute("listSong");
											if(listSong.size() > 0) {
												for(Song objSong:listSong) {
													String urlDel = request.getContextPath()+"/admin/song/del?id=" +objSong.getId();
													String urlEdit = request.getContextPath()+"/admin/song/edit?id=" +objSong.getId();
									%>
                                    <tr>
                                        <td><%=objSong.getId() %></td>
                                        <td class="center"><%=objSong.getName() %></td>
                                        <td class="center"><%=objSong.getCat().getName()%></td>
                                        <td class="center"><%=objSong.getCounter() %></td>
                                        <td class="center">
                                        <%
                                        	if(!"".equals(objSong.getPicture())) { 
                                        %>
											<img width="200px" height="200px" src="<%=request.getContextPath() %>/uploads/<%=objSong.getPicture() %>" alt="<%=objSong.getName()%>"/>
                                       <% } else { %>
                                       		<p>No image</p>
                                       <% } %>
                                        </td>
                                        <td class="center">
                                            <a href="<%=urlEdit %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=urlDel %>" title="" onclick="return confirm('Bạn có chắc muốn xóa?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
									<% } } } %>
                                </tbody>
                            </table>
                            
                            <% 
                            	int numberOfPages = (int)request.getAttribute("numberOfPages");
                           		int currentPage = (int)request.getAttribute("currentPage"); 
                           		ArrayList<Song> listSong = (ArrayList<Song>)request.getAttribute("listSong");
                           		if(listSong != null && listSong.size() > 0) {
                            %>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 5 của 24 truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
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
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <% } %>
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