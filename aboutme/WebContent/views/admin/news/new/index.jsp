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
                <h2>Quản lý tin tức</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 1:	out.print(CodeMessageUtil.displayMessage(out, "Thêm tin tức thành công"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Sửa tin tức thành công"));
									break;
									case 3:	out.print(CodeMessageUtil.displayMessage(out, "Xóa tin tức thành công"));
									break;
									case 5: out.print(CodeMessageUtil.displayMessage(out, "ID không tồn tại"));
									break;
									case 9: out.print(CodeMessageUtil.displayMessage(out, "Không tìm thấy tin tức"));
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
                                    <a href="<%=request.getContextPath() %>/admin/news/new/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="get" action="<%=request.getContextPath()%>/admin/news/new/index">
                                    <input type="search"  name="sname" value="<% if(request.getParameter("sname") != null) out.print(request.getParameter("sname")); %>" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 250px;" />
                                        <select name="scat" class="btn btn-warning btn-sm" style="float:right;margin-right: 5px;">																																																																																																																	cat"  class="btn" style="float:right; margin-right: 10px;">
                                        	<option value="0"> -- Chọn danh mục --</option>
                                        	
                                        	
                                        	<%
                                        		int scat = 0;
                                        		if(request.getAttribute("scat") != null) {
                                        			scat = (Integer) request.getAttribute("scat");
                                        		}
                                        	
                                        		if(request.getAttribute("listCat")!= null) {
                                        			ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
                                        			if(listCat.size() > 0) {
                                        				for(Category objCat: listCat)	{
                                        			
                                        	%>
                                         	<option <% if(scat == objCat.getId()) out.print("selected = 'selected'"); %> value="<%=objCat.getId()%>"> <%=objCat.getName() %></option>
                                         	
                                         	
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
                                        <th>Tên tin </th>
                                        <th>Danh mục</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% 
										if(request.getAttribute("listNew") != null) {
										
											ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNew");
											if(listNew.size() > 0) {
												for(New objNew:listNew) {
													String urlDel = request.getContextPath()+"/admin/news/new/del?id=" +objNew.getId();
													String urlEdit = request.getContextPath()+"/admin/news/new/edit?id=" +objNew.getId();
									%>
                                    <tr>
                                        <td><%=objNew.getId() %></td>
                                        <td class="center"><%=objNew.getName() %></td>
                                        <td class="center"><%=objNew.getCat().getName() %></td>
                                        <td class="center"><%=objNew.getCounter() %></td>
                                        <td class="center">
                                        <%
                                        	if(!"".equals(objNew.getPicture())) { 
                                        %>
											<img width="200px" height="200px" src="<%=request.getContextPath() %>/uploads/<%=objNew.getPicture() %>" alt="<%=objNew.getName()%>"/>
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
                                        String stringSearch = "";
                           			 	String sname = (String)request.getAttribute("sname");
                           			 	boolean checkSearch = (boolean) request.getAttribute("checkSearch");
                                        if(request.getAttribute("checkSearch") != null && checkSearch == true) {
	                                     stringSearch = "&sname="+sname+"&scat="+scat;   
                                        }
                                        
                               %>
                               
                               
                            
                            <% 
                            	int numberOfPages = (int)request.getAttribute("numberOfPages");
                           		int currentPage = (int)request.getAttribute("currentPage"); 
                           		ArrayList<New> listNew = (ArrayList<New>)request.getAttribute("listNew");
                           		if(listNew != null && listNew.size() > 0) {
                            %>
                            <div class="row">
                                <div class="col-sm-6">
                                   
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                        
                                        <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/news/new/index?page=<%=currentPage-1%><%=stringSearch%>">Trang trước</a></li>
                                        	<%
                                           		String active = "";
                                           		for (int i = 1; i <= numberOfPages; i++) { 
                                           			if(currentPage == i) {
                                           				active = "active";
                                           			} else {
                                           				active = "";
                                           			}
                                           	%>
                                           	
                                            <li class="paginate_button <%=active %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/news/new/index?page=<%=i%><%=stringSearch%>"><%=i %></a></li>
                                            
                                            <% } }%>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/news/new/index?page=<%=currentPage+1%><%=stringSearch%>">Trang tiếp</a></li>
                                            
                                        </ul>
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