<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/ShowCalendar.js"></script>
<script type="text/javascript">
	function makeCategories() {
		var cate = document.getElementsByName("category");
		var categories = "";
		for (var i = 0; i < cate.length; i++) {
			var input = cate[i];
			if (input.checked == true) {
				categories += input.value + ",";
			}
		}
		categories = categories.substring(0, categories.length-1);
		
		var form = document.getElementById("form");
		var input = document.createElement("input");
		input.type = "hidden";
		input.name = "cats";
		input.value = categories;
		
		form.appendChild(input);
		return true;
	}
</script>
</head>
<body>
	<div align="center">
		<form id="form" enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/BookServlet?method=addBook" onsubmit="return makeCategories()" method="post">
			<fieldset>
				<legend>BookInfo</legend>
			<table border="1">
				<tr>
					<td>name</td>
					<td><input type="text" name="name" ></td>
				</tr>
				<tr>
					<td>description</td>
					<td><input type="text" name="description" ></td>
				</tr>
				<tr>
					<td>author</td>
					<td><input type="text" name="author" ></td>
				</tr>
				<tr>
					<td>published</td>
					<td><input type="text" name="pdate" onclick="showCalendar(this.id)" id="pdate"></td>
				</tr>
				<tr>
					<td>publisher</td>
					<td><input type="text" name="publisher"></td>
				</tr>
				<tr>
					<td>categories</td>
					<td>
						<c:forEach var="c" items="${list }">
							<input type="checkbox" name="category" value="${c.id }"> ${c.name }
						</c:forEach>
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