<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
List<Product> products = new ArrayList<Product>();
String action = request.getParameter("action");
int[] idArray = null;
String paraIdArray = "";  //checkbox categories

if(action != null && action.trim().equals("simple2")) {
	String[] strIdArray = request.getParameterValues("categoryid");
	if(strIdArray != null) {
		idArray = new int[strIdArray.length];
		for(int i=0;i<idArray.length;i++) {
			idArray[i] = Integer.parseInt(strIdArray[i]);
			paraIdArray += "&categoryid="+idArray[i];
		}
	}
	
	String keyWord = request.getParameter("keyword");
	double lowNormalPrice = -1;
	double highNormalPrice = -1;
	double lowMemberPrice = -1;
	double highMemberPrice = -1;
	Timestamp startDate = null;
	Timestamp endDate = null;
	
	int pageNo = 1;
	String str = request.getParameter("pageno");
	if(str != null)
		pageNo = Integer.parseInt(str);
	final int pageSize = 3;
	
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
	<a href="searchresultSimple.jsp?action=simple2&keyword=<%= keyWord%>&pageno=<%= pageNo+1>pages?pages:pageNo+1%><%= paraIdArray%>">NextPage</a>
	&nbsp;
	<a href="searchresultSimple.jsp?action=simple2&keyword=<%= keyWord%>&pageno=<%= pageNo-1<=0?1:pageNo-1%><%= paraIdArray%>">PreviousPage</a>
	</div>
	<div align="Center">totalPages:<%= pages%>&nbsp;&nbsp;presentPage:<%= pageNo%></div>
  </body>
</html>

<% } %>