<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
<script type="text/javascript">
	function makepre() {
		var pres = document.getElementsByName("pre");
		var preference = "";
		for (var i = 0; i < pres.length; i++) {
			var input = pres[i];
			if (input.checked == true) {
				preference += input.value + ",";
			}
		}
		preference = preference.substring(0, preference.length-1);
		alert(preference);
		
		var form = document.getElementById("form");
		var input = document.createElement("input");
		input.type = "hidden";
		input.name = "preference";
		input.value = preference;
		
		form.appendChild(input);
		return true;
	}

</script>
</head>
<body style="text-align:center;">
	<div align="center">
	<form id="form" method="post" action="${pageContext.servletContext.contextPath }/servlet/AddCustomerServlet" onsubmit="return makepre()">
		<table border='1' >
			<tr>
				<td>name</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			
			<tr>
				<td>gender</td>
				<td>
					<c:forEach var="g" items="${genders }">
						<input type="radio" name="gender" value="${g }"> ${g }
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>birthday</td>
				<td>
					<input type="text" name="birthday" onclick="showCalendar(this.id)" id="birthday">
				</td>
			</tr>
			
			<tr>
				<td>cellphone</td>
				<td>
					<input type="text" name="cellphone">
				</td>
			</tr>
			
			<tr>
				<td>email</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			
			<tr>
				<td>preference</td>
				<td>
					<c:forEach var="p" items="${preferences }">
						<input type="checkbox" name="pre" value="${p }"> ${p }
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>type</td>
				<td>
					<c:forEach var="t" items="${types }">
						<input type="radio" name="type" value="${t }"> ${t }
					</c:forEach>
				</td>
			</tr>
			
			<tr>
				<td>description</td>
				<td>
					<textarea rows="30" cols="50" name="description"></textarea>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="reset" value="Reset" />
				</td>
				<td>
					<input type="submit" value="Submit" />
				</td>
			</tr>
			
		</table>
	</form>
	</div>
</body>
</html>