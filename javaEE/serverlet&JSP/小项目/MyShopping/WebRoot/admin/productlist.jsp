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
if(PageNo<1)
	PageNo=1;
List<Product> products = new ArrayList<Product>();
int pageCount = (ProductMgr.getInstance().getProducts(products, PageNo, PAGE_SIZE) + PAGE_SIZE - 1) / PAGE_SIZE;
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
			<td>DESCR</td>
			<td>NORMALPRICE</td>
			<td>MEMBERPRICE</td>
			<td>PDATE</td>
			<td>CATEGORYname</td>
			<td>OPERATION</td>
		</tr>
		
		<%	
				for(Iterator<Product> it = products.iterator(); it.hasNext();) {
					Product p = it.next();
			%>
			<tr>
			<td><%= p.getId()%></td>
			<td><%= p.getName()%></td>
			<td><%= p.getDescr() %></td>
			<td><%= p.getNormalprice() %></td>
			<td><%= p.getMemberprice()%></td>
			<td><%= p.getPdate()%></td>
			<td><%= p.getCategory().getName()%></td>
			<td>
				<a href="productdelete.jsp?id=<%=p.getId()%>" target="detail">Delete</a>
				&nbsp;&nbsp;
				<a href="productmodify.jsp?id=<%=p.getId()%>" target="detail">Modify</a>
				&nbsp;&nbsp;
				<a href="updateimage.jsp?id=<%=p.getId()%>" target="detail">UpdateImage</a>
			</td>
			</tr>
		<% } %>
	</table>
		<div align="center">
			page <%= PageNo%>
			<a href="productlist.jsp?pageno=<%=PageNo-1%>">previousPage</a>
			<a href="productlist.jsp?pageno=<%=PageNo < pageCount?PageNo+1:pageCount%>">NextPage</a>
			totalPages:<%= pageCount%>
		</div>
  </body>
</html>









