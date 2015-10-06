<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.bjsxt.shopping.util.DB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String strId = request.getParameter("id");
	if(name != null) {
		Connection conn = DB.getConn();
		String sql = "Select * from ruser where username like '"+name+"'";
	System.out.println(sql);
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			if(rs.next()) {
				out.println("<p style='color:red'>Sorry, the user name has been registered</p>");
			}
			else {
				out.println("<p style='color:green'>Congratuations! The username can be used</p>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return;
	}
	if(strId != null) {
		int id = Integer.parseInt(strId);
		int cnt=1;
		StringBuffer sb = new StringBuffer();
		
		Connection conn = DB.getConn();
		String sql = "Select * from category where pid="+id;
	System.out.println(sql);
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			while(rs.next()) {
				sb.append("document.form2.category2.options["+cnt+"].value='"+rs.getInt("id")+"';\n");
				sb.append("document.form2.category2.options["+cnt+"].text='"+rs.getString("name")+"';\n");
				cnt++;
			}
			out.println("document.form2.category2.length = "+cnt+";");
			out.println("document.form2.category2.selectedIndex = 0;");
			out.println("document.form2.category2.options[0].value='-1';\n"
						+"document.form2.category2.options[0].text='second category'");
			out.println(sb);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return;
	}
%>
