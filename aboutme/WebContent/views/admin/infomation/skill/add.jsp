﻿<%@page import="utils.CodeMessageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm Kỹ Năng</h2>
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
                                <form role="form" method="post" action="<%=request.getContextPath()%>/admin/infomation/skill/add" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên kỹ năng</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" required="required" />
                                    </div>
                                    <div class="form-group">
                                        <label for="value">Giá trị(%)</label>
                                        <input type="text" id="value" value="" name="value" class="form-control" required="required"/>
                                    </div>
                                    
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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
    $().ready(function() {
    	//validate form when submit
    	var validater = $("#form").validate({
    		errorPlacement: function(error, element){
    			$(element).closest("form").find("label[for='" + element.attr("id") + "']").append(error);
    		},
    		errorElement: "span",
    		messages: {
    			name:  {
    				required: "(Tên kỹ năng không được trống)",
    			},
    			value:  {
    				required: "(Giá trị không được trống)",
    			}
    		}
    	});
    			
    });
</script>
<script>
    document.getElementById("skill").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>