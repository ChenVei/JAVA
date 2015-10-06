<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<%
int id = Integer.parseInt(request.getParameter("id"));
Product p = ProductMgr.getInstance().loadById(id);
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
  <div align="center">
  	<img src="./images/000000000102467271_1_200x200.jpg"></br>
  	id:<%= p.getId()%></br>
  	name:<%= p.getName()%></br>
  	descr:<%= p.getDescr() %></br>
	normalprice:<%= p.getNormalprice() %></br>
	memberprice:<%= p.getMemberprice()%></br>
	pdate:<%= p.getPdate()%></br>
	categoryname:<%= p.getCategory().getName()%></br>
	<a href="buy.jsp?id=<%= p.getId()%>">Buy now!!</a>
  </div>
  </body>
</html>









