<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CategoryList</title>
</head>
<body>
	<div align="center" >
		<table border="1">
			<tr>
				<th>ID</th>
				<th>名字</th>
				<th>操作</th>
			</tr>
			<c:forEach var="c" items="${requestScope.list }">
				<tr>
					<td>${c.id }</td>
					<td>${c.name }</td>
					<td><a href="${pageContext.request.contextPath}/servlet/CategoryServlet?method=delCategory&id=${c.id}">del</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>