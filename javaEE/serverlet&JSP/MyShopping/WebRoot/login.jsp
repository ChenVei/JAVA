<%@page import="com.bjsxt.shopping.PasswordNotCorrectException"%>
<%@page import="com.bjsxt.shopping.UserNotFoundException"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String action = request.getParameter("action");
	if(action != null && action.trim().equals("login")) {
		User u = null;
		try {
			u = User.validate(username, password);
		} catch(UserNotFoundException e) {
			out.println("User not found!");
			return;
		} catch(PasswordNotCorrectException e) {
			out.println("Password not correct!");
			return;
		}
		session.setAttribute("user", u);
		response.sendRedirect("selfservice.jsp");
		return;
	}
	else {
		password = username = "";
	}
%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <form action="login.jsp" method="get">
    	<input type="hidden" name="action" value="login">
    	<table>
    		<tr>
    			<td colspan="2">User Login</td>
    		</tr>
    		<tr>
    			<td>username:</td>
    			<td><input type="text" size="10" name="username" value="<%= username%>"/></td>
    		</tr>
    		<tr>
    			<td>password:</td>
    			<td><input type="password" size="10" name="password" value="<%= password%>" /></td>
    		</tr>
    		<tr>
    			<td></td>
    			<td>
    				<input type="submit" size="5" name="submit" value="submit"/>
    				<input type="reset" size="5" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
