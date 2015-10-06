<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
List<Product> products = new ArrayList<Product>();
String action = request.getParameter("action");
if(action != null && action.trim().equals("complex")) {
	int id = Integer.parseInt(request.getParameter("categoryId"));
	String keyWord = request.getParameter("keyword");
	double lowNormalPrice = Double.parseDouble(request.getParameter("lownormal"));
	double highNormalPrice = Double.parseDouble(request.getParameter("highnormal"));
	double lowMemberPrice = Double.parseDouble(request.getParameter("lowmember"));
	double highMemberPrice = Double.parseDouble(request.getParameter("highmember"));
	
	int pageNo = 1;
	String str = request.getParameter("pageno");
	if(str != null)
		pageNo = Integer.parseInt(str);
	final int pageSize = 3;
	
	int[] idArray = null;
	if(id == 0) {
		idArray = ProductMgr.getInstance().getCategoryIdArray();
	} else {
		idArray[0] = id;
	}
	
for(int i:idArray) {
	System.out.println(i);
}
	String start = request.getParameter("start");
	String end = request.getParameter("end");
	Timestamp startDate = null;
	Timestamp endDate = null;
	
	if (start==null || start=="") {
		start = null;
	} else {
		startDate = Timestamp.valueOf(start);
	}
		
	if (end==null || end=="") {
		end = null;
	} else {
		endDate = Timestamp.valueOf(end);
	}
	
	int pages = ProductMgr.getInstance().findProducts(products, idArray, keyWord, lowNormalPrice, highNormalPrice, lowMemberPrice, highMemberPrice, startDate, endDate, pageNo, pageSize);
	out.println("nums:" + products.size());
	

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'searchresult.jsp' starting page</title>
    
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
			<td>CATEGORYID</td>
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
			<td><%= p.getCategoryid()%></td>
			<td>
				<a href="productdelete.jsp?id=<%=p.getId()%>" target="detail">Del It!</a>
				&nbsp;&nbsp;
				<a href="productmodify.jsp?id=<%=p.getId()%>" target="detail">Modify It!</a>
			</td>
			</tr>
		<% } %>
	</table>
	<div align="Center">
	<a href="searchresult.jsp?action=complex&categoryId=<%= id%>&keyword=<%= keyWord%>&lownormal=<%= lowNormalPrice%>&highnormal=<%= highNormalPrice%>&lowmember=<%= lowMemberPrice%>&highmember=<%= highMemberPrice%>&pageno=<%= pageNo+1>pages?pages:pageNo+1%>">NextPage</a>
	&nbsp;
	<a href="searchresult.jsp?action=complex&categoryId=<%= id%>&keyword=<%= keyWord%>&lownormal=<%= lowNormalPrice%>&highnormal=<%= highNormalPrice%>&lowmember=<%= lowMemberPrice%>&highmember=<%= highMemberPrice%>&pageno=<%= pageNo-1<=0?1:pageNo-1%>">PreviousPage</a>
	</div>
	<div align="Center">totalPages:<%= pages%>&nbsp;&nbsp;presentPage:<%= pageNo%></div>
  </body>
</html>

<% } %>