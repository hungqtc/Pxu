<%@page import="model.bean.Skill"%>
<%@page import="model.bean.Category"%>
<%@page import="utils.CodeMessageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa Kỹ Năng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                            <%
								if(request.getParameter("msg") != null) {
									int code = Integer.parseInt(request.getParameter("msg")) ;
									switch(code) {
									case 0:	out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
									break;
									
									}
								}
							%>
							<%	
								int id = 0;
								String oldName = "";
								int oldValue = 0;
								if(request.getAttribute("objOldSkill") != null) {
									Skill objOldSkill = (Skill)request.getAttribute("objOldSkill");
									id = objOldSkill.getId();
									oldName = objOldSkill.getName();
									oldValue = objOldSkill.getValue();
								}
							%>
							
                                <form role="form" method="post" action="<%=request.getContextPath()%>/admin/infomation/skill/edit?id=<%=id %>" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên danh mục</label>
                                        <input type="text" id="name" value="<%=oldName %>" name="name" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Giá trị(%)</label>
                                        <input type="text" id="value" value="<%=oldValue %>" name="value" class="form-control" />
                                    </div>
                                    
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
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
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>