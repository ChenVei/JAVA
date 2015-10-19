<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
<script type="text/javascript">
	function check() {
		if (${u.admin==true }) {
			document.getElementById("a1").checked = true;
		} else {
			document.getElementById("a2").checked = true;
		}
	}
</script>
</head>
<body onload="check()">
	<div align="center">
		<form id="form"
			action="servlet/UserServlet?method=update&id=${u.id }"
			 method="post">
			<input type="hidden" name="id" value="${u.id }">
			<fieldset>
				<legend>UserInfo</legend>
				<table border="1">
					<tr>
						<td>username</td>
						<td><input type="text" name="username" readonly="readonly" value="${u.username }"></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input type="text" name="password"
							value="${u.password }"></td>
					</tr>
					<tr>
						<td>email</td>
						<td><input type="text" name="email" readonly="readonly" value="${u.email }"></td>
					</tr>
					<tr>
						<td>admin</td>
						<td>
							<input id="a1" type="radio" name=admin value="true" >admin<br>
							<input id="a2" type="radio" name="admin" value="false">guest
						 </td>
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