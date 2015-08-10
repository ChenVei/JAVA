<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Category_input.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="admin/Category-update" method="post">
  	<input type="hidden" name="category.id" value="<s:property value="category.id"/>"/>
  	name:<input name="category.name" value="<s:property value="category.name"/>"/>
  	description:<textarea name="category.description"><s:property value="category.description"/></textarea>
  	<input type="submit" value="update" /> 
  </form>
  </body>
</html>
