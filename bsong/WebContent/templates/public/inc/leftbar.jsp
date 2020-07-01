<%@page import="model.dao.SongDAO"%>
<%@page import="model.bean.Song"%>
<%@page import="model.dao.CategoryDAO"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="searchform">
	<form id="formsearch" name="formsearch" method="post" action="#">
		<span> <input name="editbox_search" class="editbox_search"
			id="editbox_search" maxlength="80" value="Tìm kiếm bài hát"
			type="text" />
		</span> <input name="button_search"
			src="<%=request.getContextPath()%>/templates/public/images/search.jpg"
			class="button_search" type="image" />
	</form>
</div>
<div class="clr"></div>
<div class="gadget">
	<h2 class="star">Danh mục bài hát</h2>
	<div class="clr"></div>
	<ul class="sb_menu">
		<%
			CategoryDAO catDAO = new CategoryDAO();
			ArrayList<Category> listCat = catDAO.getItems();
			if (listCat.size() > 0) {
				for (Category objCat : listCat) {
		%>
		<li><a
			href="<%=request.getContextPath()%>/public/cat?id=<%=objCat.getId()%>"><%=objCat.getName()%></a></li>

		<%
			}
			}
		%>
	</ul>
</div>

<div class="gadget">
	<h2 class="star">
		<span>Bài hát mới</span>
	</h2>
	<div class="clr"></div>
	<ul class="ex_menu">
		<%
			SongDAO songDAO = new SongDAO();
			ArrayList<Song> listnewSong = songDAO.getItems(6);
			if (listnewSong.size() > 0) {
				for (Song objSong : listnewSong) {
		%>
		<li><a
			href="<%=request.getContextPath()%>/public/detail?id=<%=objSong.getId()%>"><%=objSong.getName()%></a><br />
			<%
				if (objSong.getDescription().length() > 50)
							out.print(objSong.getDescription().substring(0, 50) + "....");
						else
							out.print(objSong.getDescription());
			%></li>

		<%
			}
			}
		%>
	</ul>
</div>