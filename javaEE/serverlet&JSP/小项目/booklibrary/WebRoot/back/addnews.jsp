<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>

</head>
<body>
	<div align="center">
		<form id="form" enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/NewsServlet?method=addNews" method="post">
			<fieldset>
				<legend>NewsInfo</legend>
			<table border="1">
				<tr>
					<td>title</td>
					<td><input type="text" name="title" ></td>
				</tr>
				<tr>
					<td>content</td>
					
					<td>
					<textarea rows="50" cols="100" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td>cover</td>
					<td><input type="file" name="cover"></td>
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