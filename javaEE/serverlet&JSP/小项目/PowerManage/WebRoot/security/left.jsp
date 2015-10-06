<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>										
	<a href="${pageContext.request.contextPath}/servlet/PrivilegeServlet?method=getAll" target="main">Privilege M</a>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/servlet/ResourceServlet?method=getAll" target="main">Resource M</a>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/servlet/RoleServlet?method=getAll" target="main">Role M</a>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/servlet/UserServlet?method=getAll" target="main">User M</a>
  </body>
</html>
