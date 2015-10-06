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
		<form action="${pageContext.request.contextPath}/servlet/CategoryServlet?method=addCategory" method="post">
			<fieldset>
			<legend>CategoryInfo:</legend>
			<table border="1">
				<tr>
					<td>名字</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
			</fieldset>
		</form>
	</div>
</body>
</html>