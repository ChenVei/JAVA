<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
  Hello:${user.username }
  <a href="${pageContext.request.contextPath}/servlet/UserServlet?method=logout">logout</a>
	<a href="/PowerManage/manager/servlet1">add Category</a>
	<a href="/PowerManage/manager/servlet2">deleteCategory</a>
	<a href="/PowerManage/manager/servlet3">modifyCategory</a>
	<a href="/PowerManage/manager/servlet4">findCategory</a>
  </body>
</html>
