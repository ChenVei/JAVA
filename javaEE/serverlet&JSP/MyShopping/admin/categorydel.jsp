<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	int pid = Integer.parseInt(request.getParameter("pid"));
	
	Category c = new Category();
	c.setId(id);
	c.setPid(pid);
	c.delete();
	
	out.println("DELTE SUCCESSFULLY!!");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'userdelete.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

  </body>
</html>
