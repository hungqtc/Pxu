<%@page import="model.bean.Comment"%>
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
                <h2>Quản lý bình luận</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									case 2:	out.print(CodeMessageUtil.displayMessage(out, "Xóa bình luận thành công"));
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
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên tin </th>
                                        <th>Người bình luận</th>
                                        <th>Nội dung</th>
	                                    <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                     				<%	
                                		if(request.getAttribute("listComment") != null) {
                                		ArrayList<Comment> listComment = (ArrayList<Comment>)request.getAttribute("listComment");
                                		if(listComment.size() > 0) {
                                			for( Comment objComment: listComment) {
                                	%>
                                    <tr>
                                        <td><%=objComment.getId() %></td>
                                        <td class="center"><%=objComment.getNews().getName() %></td>
                                        <td class="center"><%=objComment.getName() %></td>
                                        <td class="center"><%=objComment.getMessage() %></td>
                                        <td class="center">
                                            <a href="<%=request.getContextPath() %>/admin/news/comment/del?id=<%=objComment.getId() %>" title="" onclick="return confirm('Bạn có chắc muốn xóa?')" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
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