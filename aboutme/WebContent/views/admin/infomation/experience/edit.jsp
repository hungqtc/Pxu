<%@page import="java.util.Calendar"%>
<%@page import="model.bean.Experience"%>
<%@page import="java.util.Date"%>
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
                <h2>Sửa Kinh Nghiệm</h2>
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
								
								String[] dateOldExperience = null;
								if(request.getAttribute("objOldExperience") != null) {
									Experience objOldExperience = (Experience)request.getAttribute("objOldExperience");
									oldName = objOldExperience.getName();
									id = objOldExperience.getId();
									
								}
								if(request.getAttribute("dateOldExperience") != null) {
									dateOldExperience = (String[])request.getAttribute("dateOldExperience");
								}
							%>
							
                                <form role="form" method="post" action="<%=request.getContextPath()%>/admin/infomation/experience/edit?id=<%=id %>" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên </label>
                                        <input type="text" id="name" value="<%=oldName %>" name="name" class="form-control" />
                                    </div>
                                   	 <label for="date">Thời gian</label><br/>
                                        
                                       
																	
                                        <p style="float:left;margin-right:30px">
                                        Ngày<br/>
                                        
                                        <select name="day" class="form-control" required="required" style="width:70px;float:left">
                                       	<%
                                       		int date = Integer.parseInt(dateOldExperience[0]);
                                       		int month = Integer.parseInt(dateOldExperience[1]);
                                       		int year = Integer.parseInt(dateOldExperience[2]);
                                       		String selected = "";
                                       	%>
                                       	<%
                                       				for(int i=1;i<=31;i++){
                                       					if(i == date) {
                                       						selected = "selected";
                                       						i = date;
                                       					} else {
                                       						selected = "";
                                       					}
                                       	%>	
	                                        <option value="<%=i%>" <%=selected %>><%=i%></option>
	                                    <%
                                       		} 
	                                    %>
                                        </select>
                                   		</p>
                                   		
                                   
                                   		<p style="float:left;margin-right:30px">
                                   		 Tháng <select  name="month" class="form-control" required="required" style="width:70px">
                                       	<%
                                       				for(int i=1;i<=12;i++){
                                       					if(i == month) {
                                       						selected = "selected";
                                       						i = month;
                                       					} else {
                                       						selected = "";
                                       					}
                                       	%>	
                                       	 	
	                                        <option value="<%=i%>" <%=selected %>><%=i%> </option>
	                                    <%
                                       		}
	                                    %>
                                        </select>
                                        </p>
                                      
                                      
                                      
                                        <p style="float:left">
                                         Năm <select name="year" class="form-control" required="required" style="width:100px">
                                       	<%
                                       				for(int i=1998;i<=2030;i++){
                                       					if(i == year) {
                                       						selected = "selected";
                                       						i = year;
                                       					} else {
                                       						selected = "";
                                       					}
                                       	%>
	                                        <option value="<%=i%>" <%=selected %>><%=i%></option>
	                                    <%
                                       		}
	                                    %>
                                        </select>
                                        </p>
                                        
                                    <div class=clear> </div>
                                    
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