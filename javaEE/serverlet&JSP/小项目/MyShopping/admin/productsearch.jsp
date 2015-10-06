<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
List<Category> categories = Category.getCategories();

//forward
String action = request.getParameter("action");
	if(action != null) {
	if(action.equals("simple2") ) {
		%>
		
		<jsp:forward page="searchresultSimple.jsp"></jsp:forward>
		<%
	}
	else if(action.equals("complex")) 
		%>
		<jsp:forward page="searchresult.jsp"></jsp:forward>
		<%
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'productsearch.jsp' starting page</title>
	<script>
		function checkDate() {
			var o = document.forms["complex"];
			with(o) {
				if(lownormal.value==null || lownormal.value=="") {
					lownormal.value = -1;
				}
				if(highnormal.value==null || highnormal.value=="") {
					highnormal.value = -1;
				}
				if(lowmember.value==null || lowmember.value=="") {
					lowmember.value = -1;
				}
				if(highmember.value==null || highmember.value=="") {
					highmember.value = -1;
				}
			}
		}
	</script>
  </head>
  
  <body>
  	<div align="center">Simple Search</div>
  	<form action="searchresult.jsp" method="post">
  		<input type="hidden" name="action" value="simple">
  		Category:<select>
  					<option value="0">all categories</option>
  					<%
  					for(Iterator<Category> it = categories.iterator(); it.hasNext();) {
  						Category c = it.next();
  						String str = "";
  						int cnt = c.getGrade();
  						for(int i=1;i<cnt;i++)
  							str += "--";
					%>
					<option value="<%= c.getId()%>"><%= str+c.getName()%></option>
  					<%
  					}
  					%>
  				</select>
  		Keyword:<input type="text" name="keyword"></input>
  		<input type="submit" value="Go" />
  	</form>
  	
  	<div align="center">Simple Search2</div>
  	<form action="productsearch.jsp" method="post">
  		<input type="hidden" name="action" value="simple2">
  		Category:
  		
		<%
		for(Iterator<Category> it = categories.iterator(); it.hasNext();) {
			Category c = it.next();
			String str = "";
			int cnt = c.getGrade();
			for(int i=1;i<cnt;i++)
				str += "--";
		%>
		<br/>
		<%
			if(c.isLeaf()) {
		%>
		<input type="checkbox" name="categoryid" value="<%= c.getId()%>"/>
			<% } %>
		<%= str+c.getName()%>
		<% } %>
  		
  		<br/>			
  		Keyword:<input type="text" name="keyword"></input>
  		<input type="submit" value="Go" />
  	</form>
  	
  	<div align="center">Complex Search</div>
  	<form action="productsearch.jsp" method="post" name="complex" onsubmit="checkDate()">
  		<input type="hidden" name="action" value="complex" /><br/>
  		Category:<select name="categoryId">
  					<option value="0">all categories</option>
  					<%
  					for(Iterator<Category> it = categories.iterator(); it.hasNext();) {
  						Category c = it.next();
  						String str = "";
  						int cnt = c.getGrade();
  						for(int i=1;i<cnt;i++)
  							str += "--";
					%>
					<option value="<%= c.getId()%>"><%= str+c.getName()%></option>
  					<%
  					}
  					%>
  				</select><br/>
  		Keyword:<input type="text" name="keyword"></input><br/>
  		NormalPrice:<input type="text" name="lownormal"/> to <input type="text" name="highnormal"/><br/>
  		MemberPrice:<input type="text" name="lowmember"/> to <input type="text" name="highmember"/><br/>
  		Pdate:<input type="text" name="start"/> to <input type="text" name="end"/>
  		<input type="submit" value="Go" />
  	</form>
  </body>
</html>
