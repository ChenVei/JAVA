<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>back</title>
	<meta http-equiv="pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <frameset rows="22%,*">
  		<frame name="top" src="${pageContext.request.contextPath }/security/head.jsp">
  		<frameset cols="15%,*">
  			<frame name="left" src="${pageContext.request.contextPath }/security/left.jsp">
  			<frame name="main" src="#">
  		</frameset>
  </frameset>
</html>
