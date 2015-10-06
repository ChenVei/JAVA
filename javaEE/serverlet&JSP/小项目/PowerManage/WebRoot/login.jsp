<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
	<div align="center">
		<form action="${pageContext.request.contextPath }/servlet/UserServlet?method=login" method="post">
			<table border="1">
				<tr>
					<td>name</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" style="text-align: center"></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>
