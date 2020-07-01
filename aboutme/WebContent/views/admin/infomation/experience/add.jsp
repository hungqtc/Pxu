
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm chặng đường đã đi</h2>
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
                                <form role="form" method="post" id="form" active="<%=request.getContextPath()%>/admin/infomation/experience/add">
                                    <div class="form-group">
                                        <label for="name">Tên</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" required="required"/>
                                    </div>
                                    
                                        <label for="date">Thời gian</label><br/>
                                        
                                        
                                        <p style="float:left;margin-right:30px">
                                        Ngày<br/>
                                        
                                        <select name="day" class="form-control" required="required" style="width:70px;float:left">
                                       	<%
                                       				for(int i=1;i<=31;i++){
                                       	%>
	                                        <option value="<%=i%>"><%=i%></option>
	                                    <%
                                       		}
	                                    %>
                                        </select>
                                   		</p>
                                   		
                                   
                                   		<p style="float:left;margin-right:30px">
                                   		 Tháng <select  name="month" class="form-control" required="required" style="width:70px">
                                       	<%
                                       				for(int i=1;i<=12;i++){
                                       	%>
	                                        <option value="<%=i%>"><%=i%></option>
	                                    <%
                                       		}
	                                    %>
                                        </select>
                                        </p>
                                      
                                      
                                      
                                        <p style="float:left">
                                         Năm <select name="year" class="form-control" required="required" style="width:100px">
                                       	<%
                                       				for(int i=1998;i<=2030;i++){
                                       	%>
	                                        <option value="<%=i%>"><%=i%></option>
	                                    <%
                                       		}
	                                    %>
                                        </select>
                                        </p>
                                        
                                        <div style="clear: both"></div>
                                    
                                   
                                     </div>
                                    <div class="form-group">
                                        <label for="content">Nội dung</label>
                                        <textarea id="content" class="form-control" rows="3" name="content" required="required"></textarea>
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md"  >Thêm</button>
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
		var validator = $("#form").validate({
			errorPlacement: function(error, element) {
				$(element).closest("form").find("label[for='"+element.attr("id") + "']").append(error);
			},
			errorElement: "span",
			message: {
				name:{
					required: "(Tên không được trống)",
				}
			}
		});
	});
</script>
<script>
	var editor = CKECITOR.replace('detail');
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>