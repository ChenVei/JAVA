<%@page import="com.bjsxt.shopping.Cart"%>
<%@page import="com.bjsxt.shopping.CartItem"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

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
  	
  	<form action="cartupdate.jsp" method="post">
  	<table border='1'>
  		<tr>
  			<td>ProductId</td>
  			<td>ProductName</td>
  			<td>Price</td>
  			<td>Count</td>
  		</tr>
  		<%
  		Cart cart = (Cart)session.getAttribute("cart");
  		List<CartItem> items = cart.getItems();
  		for(int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
  		%>
  		<tr>
  			<td><%= item.getProductId()%></td>
  			<td><%= ProductMgr.getInstance().loadById(item.getProductId()).getName()%></td>
  			<td><%= item.getPrice()%></td>
  			<td><input type="text" name="p<%= item.getProductId()%>" value="<%= item.getCount()%>"/></td>
  		</tr>
  		<% 	} %>
  	</table>
  		TotalPrice:<%= cart.getTotalPrice()%> <br />
  		<input type="submit" value="update now!!" />
  		<input type="button" value="confirm" onclick="window.location.href='confirm.jsp'"/>
	</form>
 	 </div>
  </body>
</html>









