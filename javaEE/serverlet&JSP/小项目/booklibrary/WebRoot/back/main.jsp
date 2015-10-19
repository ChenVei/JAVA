<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/back/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理工作平台</title>
<base href="<%=basePath%>">
</head>
<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" />
	<frame src="center.html" name="mainFrame" id="mainFrame" />
	<frame src="down.html" name="bottomFrame" scrolling="no"
		noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>