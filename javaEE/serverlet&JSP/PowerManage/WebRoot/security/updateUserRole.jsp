<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>updateUserRole Page</title>
  </head>
  
  <body>
		<table border="1">
			<tr>
				<td>UserName</td>
				<td>${r.username }</td>
			</tr>
			<tr>
				<td>description</td>
				<td>${r.description }</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>
					<c:forEach var="p" items="${r.roles }">
						${p.name } &nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Update role</td>
				<td>
					<form action="${pageContext.request.contextPath }/servlet/UserServlet?method=updateRole" method="post">
						<input type="hidden" name="userid" value="${r.id }">
						<c:forEach var="p" items="${list }">
							<input type="checkbox" name="rid" value="${p.id }"> ${p.name }
						</c:forEach>
						<input type="submit" value="authorize">
					</form>
				</td>
			</tr>
		</table>
  </body>
</html>
