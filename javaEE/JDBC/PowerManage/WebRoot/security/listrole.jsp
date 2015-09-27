<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role List</title>
<style type="text/css">
body {
text-align: center;
}
</style>
</head>
<body>
	<table width="60%">
		<tr>
			<td></td>
			<td></td>
			<td align="right">
				<a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=addUI">add Role</a>
			</td>
		</tr>
	</table  >
	
	<table frame="border" border="1" width="60%">
		<tr>
			<td>name</td>
			<td>description</td>
			<td>opeation</td>
		</tr>
		
		<c:forEach var="p" items="${requestScope.list }">
			<tr>
				<td>${p.name }</td>
				<td>${p.description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=updatePrivilege&id=${p.id}">authorizePrivilege</a>
					<a href="#">modify</a>
					<a href="#">del</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>