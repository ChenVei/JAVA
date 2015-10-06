<%@page import="com.bjsxt.shopping.OrderMgr"%>
<%@page import="com.bjsxt.shopping.SalesOrder"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%! private static final int PAGE_SIZE = 4; %>
<%
int PageNo = 1;
String str = request.getParameter("pageno");
if(str != null)
	PageNo = Integer.parseInt(str);

List<SalesOrder> orders = new ArrayList<SalesOrder>();
int pageCount = (OrderMgr.getInstance().getOrders(orders, PageNo, PAGE_SIZE) + PAGE_SIZE - 1) / PAGE_SIZE;
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
			<td>id</td>
			<td>userid</td>
			<td>username</td>
			<td>addr</td>
			<td>odate</td>
			<td>status</td>
		</tr>
		
		<%	
				for(Iterator<SalesOrder> it = orders.iterator(); it.hasNext();) {
					SalesOrder so = it.next();
			%>
			<tr>
			<td><%= so.getId()%></td>
			<td><%= so.getUser().getId()%></td>
			<td><%= so.getUser().getUsername()%></td>
			<td><%= so.getAddr()%></td>
			<td><%= so.getoDate()%></td>
			<td><%= so.getStatus()%></td>
			<td><A href="orderdetailshow.jsp?id=<%= so.getId()%>" target="detail">detail</A></td>
			<td><A href="ordermodify.jsp?id=<%= so.getId()%>" target="detail">modify</A></td>
			</tr>
		<% } %>
	</table>
		<div align="center">
			page <%= PageNo%>
			<a href="orderlist.jsp?pageno=<%=PageNo-1 < 1? 1:PageNo-1%>">previousPage</a>
			<a href="orderlist.jsp?pageno=<%=PageNo < pageCount?PageNo+1:pageCount%>">NextPage</a>
			totalPages:<%= pageCount%>
		</div>
  </body>
  
</html>









