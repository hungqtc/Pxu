<%@page import="model.bean.CategoryFather"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CategoryFatherDAO"%>
<%@page import="model.dao.CategoryDAO"%>
<%@page import="utils.CodeMessageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Thêm danh mục</h2>
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
									if (request.getParameter("msg") != null) {
										int code = Integer.parseInt(request.getParameter("msg"));
										switch (code) {
											case 0 :
												out.print(CodeMessageUtil.displayMessage(out, "Có lỗi trong quá trình xử lí"));
												break;

										}
									}
								%>
								<form role="form" method="post"
									action="<%=request.getContextPath()%>/admin/news/cat/add"
									id="form">
									<div class="form-group">
										<label for="name">Tên danh mục</label> 
										<input type="text"
											id="name" value="" name="name" class="form-control" required="required"/>
									</div>
									<div>
										<select id = "type" name="type" onchange="getType()">
											<option value="0">--Làm danh mục cha mới--</option>
											<option value="1">--Thuộc danh mục cha có sẵn--</option>
										</select>
									</div>
									<div style="clear: both"></div>
									

									<div id = "categories">
										
									</div>



									<button type="submit" name="submit"
										class="btn btn-success btn-md">Thêm</button>
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
    				required: "(Tên danh mục không được trống)",
    			}
    		}
    	});
    			
    });
</script>
<script>
	function getType() {
		var type = document.getElementById("type").value;
		
		$.ajax({
			url: "<%=request.getContextPath()%>/ajax/cat/add",
			type: 'GET',
			cache: false,
			data: {
				'atype': type 
				},
			success: function(data){
				
				$("#categories").html(data);
			},
			error: function (){
				alert('Có lỗi xãy ra!');
			}
		});
		return false;
	}

	
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>