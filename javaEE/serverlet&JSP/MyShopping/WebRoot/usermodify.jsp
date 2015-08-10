<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	User u = (User)session.getAttribute("user");
	if(u == null) {
		out.println("You havn't logged on!!");
		return;
	}

	String action = request.getParameter("action");
	if(action != null && action.trim().equals("modify")) {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		u.setUsername(username);
		u.setPhone(phone);
		u.setAddr(addr);
		u.update();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>User Modify's page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form name="form" action="usermodify.jsp" method="post" onSubmit="return checkdata()">
		<input type="hidden" name="action" value="modify" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">User Modify</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type=text name="username" size="30" maxlength="10"
					onblur="checkUserName(this.value.toLowerCase())" value="<%= u.getUsername()%>">
					<div id="usernameErr"></div> <!--<span id="usernameErr"></span>-->
				</td>
			</tr>

			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" maxlength="12" value="<%= u.getPhone()%>">
			</tr>


			<tr>
				<td>地址</td>
				<td><textarea rows="12" cols="80" name="addr"><%= u.getAddr()%></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="提交"> <input
					type="reset" value="重置"></td>
			</tr>

		</table>
	</form>
  </body>
</html>
