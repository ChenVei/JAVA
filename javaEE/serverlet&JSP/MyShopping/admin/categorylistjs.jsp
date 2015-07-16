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
  
  <script language="javascript" src="TV20.js">

  </script>
  
    <title>My JSP 'userlist.jsp' starting page</title>
  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <script>	
  	addNode(-1,0,"categories","images/top.gif"); 
  	<%
		for(Iterator<Category> it = categories.iterator(); it.hasNext();) {
			Category c = it.next();
		int pid = c.getPid(), id = c.getId();
	%>
  addNode(<%=pid%>,<%=id%>,"<%=c.getName()%>","images/top.gif");
<% } %>
	showTV();
	</script>
  </body>
</html>









