<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Hello Struts2</title>
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
    Hello Struts2<br>
    <form action="front/index!add" method="get">
    	<input type="text" name="age"/>
    	<input type="submit" />
    </form>
    <a href="front/index!add?Name=汪s&Age=19">go to myJSP (ActionAttribute)</a>
    <br/>
    <a href="user/user1!add?name=wss&age=18">go to myJSP (ModelDriven)</a>
  </body>
</html>
