
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ws.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	request.setCharacterEncoding("UTF-8");
	int pid; 
	int rootID;
	try {
		pid = Integer.parseInt(request.getParameter("pid"));
		rootID = Integer.parseInt(request.getParameter("rootID"));
	} catch(NumberFormatException e) {
		out.println("NumberFormatException");
		e.printStackTrace();
		return;
	}
	Connection conn = DB.getConn();
	String sql = "insert into daomu values (null, ?, ?, ?, now(), ?)";
	PreparedStatement pstmt = DB.prepareStmt(conn, sql);
	pstmt.setInt(1, pid);
	pstmt.setInt(2, rootID);
	pstmt.setString(3, request.getParameter("cont"));
	pstmt.setInt(4, 1);
	
	pstmt.executeUpdate();
	Statement stmt = DB.createStatement(conn);
	sql = "update daomu set isleaf = 0 where id="+pid;
	stmt.executeUpdate(sql);
	
	DB.close(stmt);
	DB.close(pstmt);
	DB.close(conn);
	//response.sendRedirect("article.jsp");
%>

<span id="time" style="background:red">5</span>秒后自动跳转，否则点击以下链接
<script language="JavaScript1.2" type="text/javascript">
<!--
//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
	if(delay <= 0) 
		window.top.location.href = url;
	else {
		delay--;
		document.getElementById("time").innerHTML = delay;
		setTimeout("delayURL('" + url + "')", 1000);
	}
}

//-->

</script>

<!-- Place this in the 'body' section -->
<br />
<a href="article.jsp">back to home page</a>
<script>delayURL("article.jsp")</script>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'replyDetail.jsp' starting page</title>
    
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
  	<br />
    This is my JSP page. 
  </body>
</html>
