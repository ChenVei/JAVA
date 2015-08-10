<%@page import="com.bjsxt.shopping.SalesItem"%>
<%@page import="com.bjsxt.shopping.OrderMgr"%>
<%@page import="com.bjsxt.shopping.SalesOrder"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
int id = Integer.parseInt(request.getParameter("id"));
SalesOrder so = OrderMgr.getInstance().loadById(id);
List<SalesItem> items = OrderMgr.getInstance().getItems(so);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'userlist.jsp' starting page</title>
  </head>
  
  <body>
  <div align="center">
  UserName:<%= so.getUser().getUsername()%>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>productName</td>
			<td>unitprice</td>
			<td>pcount</td>
			<td>orderid</td>
		</tr>
		
			<%
				for(Iterator<SalesItem> it = items.iterator(); it.hasNext();) {
					SalesItem si = it.next();
			%>
			<tr>
			<td><%= si.getId()%></td>
			<td><%= si.getProduct().getName()%></td>
			<td><%= si.getUnitprice()%></td>
			<td><%= si.getCount()%></td>
			<td><%= si.getOrder().getId()%></td>
			</tr>
			<% } %>
	</table>
	</div>
  </body>
</html>









