<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>updateResourcePrivilege Page</title>
  </head>
  
  <body>
		<table border="1">
			<tr>
				<td>RoleName</td>
				<td>${r.name }</td>
			</tr>
			<tr>
				<td>description</td>
				<td>${r.description }</td>
			</tr>
			<tr>
				<td>privilege</td>
				<td>
					<c:forEach var="p" items="${r.privileges }">
						${p.name } &nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Update privilege</td>
				<td>
					<form action="${pageContext.request.contextPath }/servlet/RoleServlet?method=updateP" method="post">
						<input type="hidden" name="id" value="${r.id }">
						<c:forEach var="p" items="${list }">
							<input type="checkbox" name="privilegeID" value="${p.id }"> ${p.name }
						</c:forEach>
						<input type="submit" value="authorize">
					</form>
				</td>
			</tr>
		</table>
  </body>
</html>
