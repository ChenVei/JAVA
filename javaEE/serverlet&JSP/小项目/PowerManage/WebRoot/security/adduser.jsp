<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Resource</title>
<style type="text/css">
body {
text-align: center;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/servlet/UserServlet?method=add" method="post">
		<table frame="border" border="1">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>description</td>
				<td><textarea rows="5" cols="50" name="description"></textarea></td>		
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" ></td>
			</tr>
		</table  >
	</form>
	
</body>
</html>