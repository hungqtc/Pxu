<%@page import="model.dao.CatDAO"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Danh mục tin</h3>
<ul>
	<%	
		CatDAO catDAO = new CatDAO();
		ArrayList<Category> listCat = catDAO.getItems();

		for (Category objCat : listCat) {
	%>
	<li><a href="<%=request.getContextPath()%>/danh-muc?cid=<%=objCat.getId() %>" title=""><%=objCat.getName()%></a></li>

	<%
		}
	%>
</ul>