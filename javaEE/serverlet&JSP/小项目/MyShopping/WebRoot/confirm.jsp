<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.CartItem"%>
<%@page import="com.bjsxt.shopping.Cart"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
User u = (User)session.getAttribute("user");
boolean login = (u == null);
if(login) {
%>
	login now, or it'll be more expensive!<br />
	<a href="login.jsp">Login</a>
	<br /><br /><br />
	ignore it, I'm local tyrant---
	<a href="comfirmusenormal.jsp">Just go on.</a>
<%
}
%>

<div align="center">
	Hello~<%= login?"":u.getUsername()%><br/>
	 please confirm your order and address.<br/>
<table border='1'>
  		<tr>
  			<td>ProductId</td>
  			<td>ProductName</td>
  			<td>Price(<%= login?"normalPrice":"memberPrice"%>)</td>
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
  			<td><%= item.getCount()%></td>
  		</tr>
  		<% 	} %>
  	</table>
  		TotalPrice:<%= cart.getTotalPrice()%> <br /><br />
  		
  		Your address<br/>
  		<form action="order.jsp" method="post">
  		<textarea rows="4" cols="10" name="addr"><%= login?"":u.getAddr()%></textarea>
  		<br />
  		<input type="submit" value="order now!">
  		</form>
  		
  		
</div>