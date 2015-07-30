<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
List<Category> categories = Category.getCategories();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>PID</td>
			<td>IsLeaf</td>
			<td>GRADE</td>
			<td>Add ChildNode</td>
			<td>Del Node</td>
			<td>Modify</td>
			<td>Add prduct</td>
		</tr>
		
			<%
				for(Iterator<Category> it = categories.iterator(); it.hasNext();) {
					Category c = it.next();
					String preStr = "";
					for(int i=1;i<c.getGrade();i++) {
						preStr +="----";
					}
			%>
			<tr>
			<td><%= c.getId() %></td>
			<td><%= preStr + c.getName() %></td>
			<td><%= c.getPid() %></td>
			<td><%= c.isLeaf() %></td>
			<td><%= c.getGrade() %></td>
			<td>
				<a href="categoryadd.jsp?pid=<%= c.getId()%>">Add</a>
			</td>
			<td>
				<a href="categorydel.jsp?id=<%= c.getId()%>&pid=<%= c.getPid()%>">delete</a>			
			</td>
			<td>
				<a href="categorymodify.jsp?id=<%= c.getId()%>">modify</a>			
			</td>
			<%
				if(c.isLeaf()) {
			%>
			<td>
				<a href="productadd.jsp?categoryid=<%= c.getId()%>&">add</a>			
			</td>
				<% }%>
			</tr>
			<% } %>
		
	</table>
  </body>
</html>









