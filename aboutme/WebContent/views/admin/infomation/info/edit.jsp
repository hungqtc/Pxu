<%@page import="model.bean.Info"%>
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
                <h2>Sửa Thông Tin</h2>
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
								String oldEmail = "";
								String oldAdress = "";
								String oldPhoneNumber = "";
								String oldContent = "";
								
								if(request.getAttribute("objOldInfo") != null) {
									Info objOldInfo = (Info)request.getAttribute("objOldInfo");
									id = objOldInfo.getId();
									oldName = objOldInfo.getName();
									oldEmail = objOldInfo.getEmail();
									oldAdress = objOldInfo.getAdress();
									oldPhoneNumber = objOldInfo.getPhoneNumber();
									oldContent = objOldInfo.getContent();
								}
							%>
							
                                <form role="form" method="post" action="<%=request.getContextPath()%>/admin/infomation/info/edit?id=<%=id %>" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên </label>
                                        <input type="text" id="name" value="<%=oldName %>" name="name" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="adress">Địa chỉ</label>
                                        <input type="text" id="adress" value="<%=oldAdress %>" name="adress" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" id="email" value="<%=oldEmail %>" name="email" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="phonenumber">Số điện thoại</label>
                                        <input type="text" id="phonenumber" value="<%=oldPhoneNumber %>" name="phonenumber" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="content">Nội dung</label>
                                        <input type="text" id="content" value="<%=oldContent %>" name="content" class="form-control" />
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