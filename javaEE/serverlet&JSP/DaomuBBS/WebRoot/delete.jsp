
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ws.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%!
	void del(Connection conn, int id, boolean isLeaf) {
		Statement stmt ;
		ResultSet rs;
		if(!isLeaf) {
			String sql = "select * from daomu where pid="+id;
			stmt = DB.createStatement(conn);
			rs = DB.getResult(stmt, sql);
			try {
				while(rs.next()) {
					del(conn, rs.getInt("id"), rs.getInt("isLeaf")==1?true:false);
				}	
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				DB.close(rs, stmt);
			}
		}
		DB.executeUpdate(conn, "delete from daomu where id="+id);
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	int id=-1,pid=-1;
	boolean isLeaf=true;
	try {
	id = Integer.parseInt(request.getParameter("id"));
	isLeaf = Boolean.parseBoolean(request.getParameter("isLeaf"));
	pid = Integer.parseInt(request.getParameter("pid"));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	Connection conn = DB.getConn();
	conn.setAutoCommit(false);
	
	del(conn, id, isLeaf);
	
	Statement stmt = DB.createStatement(conn);
	String sql = "select count(*) from daomu where pid="+pid;
	ResultSet rs = DB.getResult(stmt, sql);
	rs.next();
	int count = rs.getInt(1);
	if(count <= 0) {
		sql = "update daomu set isleaf = 1 where id="+pid;
		DB.executeUpdate(conn, sql);
	}
		
	conn.commit();
	conn.setAutoCommit(true);
	DB.close(rs, stmt);
	DB.close(conn);
	response.sendRedirect("article.jsp");
%>

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
