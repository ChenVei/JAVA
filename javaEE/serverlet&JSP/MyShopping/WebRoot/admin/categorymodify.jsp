<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	String action = request.getParameter("action");
	Category c = null;
	
	if(action != null && action.equals("modify")) {
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		
		c = new Category();
		c.setId(id);
		c.setName(name);
		c.setDescr(descr);
		
		c.modify();
		out.println("Modify Successfully!!!");
		return;
	}
	
	c = Category.loadById(id);
	
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
<center>Modify ID:<%= c.getId()%>'s category</center>
    <form action="categorymodify.jsp" method="post">
    	<input type="hidden" name="action" value="modify" />
    	<input type="hidden" name="id" value="<%= id%>" />
    	<table>
    		<tr>
    			<td>categoryName</td>
    			<td><input type="text" name="name" value="<%=c.getName()%>"/></td>
    		</tr>
    		<tr>
    			<td>categoryDescription</td>
    			<td><textarea name="descr" rows="8" cols="40"><%=c.getDescr()%></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			<input type="submit" value="Submit"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
