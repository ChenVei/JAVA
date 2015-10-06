<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String action = request.getParameter("action");
String username = request.getParameter("username");
if(username == null) username = "";

if(action != null && action.trim().equals("login")) {
	
	String password = request.getParameter("password");
	if(username.trim().equals("admin") && password.trim().equals("admin")) {
		session.setAttribute("adminLogined", "true");
		response.sendRedirect("articleFlat.jsp");
		return;	
	} else out.println("Error with login!!");
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
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
    <form action="login.jsp" method="post">
    	<input type="hidden" name="action" value="login" />
    	username:
	    <input type="text" name="username" value="<%= username%>"/>
	    <br />
	    password:
	    <input type="password" name="password" />
	    <input type="submit" value="Ìá½»" />
    </form>
  </body>
</html>
