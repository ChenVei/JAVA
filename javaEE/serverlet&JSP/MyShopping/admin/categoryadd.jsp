<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
int pid = 0;
String strPid = request.getParameter("pid");

if(strPid != null && !strPid.trim().equals("")) {
	pid = Integer.parseInt(strPid);
}
String action = request.getParameter("action");
if(action != null && action.equals("add")) {
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	if(pid == 0)
		Category.addTopCategory(name, descr);
	else 
		Category.addChildCategory(pid, name, descr);
	
	out.println("Congratulations!!");
}
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
  	<center>add root category</center>
    <form action="categoryadd.jsp" method="post">
    	<input type="hidden" name="action" value="add" />
    	<input type="hidden" name="pid" value="<%= pid%>" />
    	<table>
    		<tr>
    			<td>categoryName</td>
    			<td><input type="text" name="name"/></td>
    		</tr>
    		<tr>
    			<td>categoryDescription</td>
    			<td><textarea name="descr" rows="8" cols="40"></textarea></td>
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







