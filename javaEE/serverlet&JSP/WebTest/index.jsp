<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> //ignore the Whitespaces before...
<%
String path = request.getContextPath();  //output the project's name
System.out.println(path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="head.html"%>
    This is the forward page. <br>
    <%
    Date d = (Date)request.getAttribute("date");
    SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd/hh:mm aaa");
    if(d != null)
    	out.println(s.format(d));
    out.println(request.getParameter("des"));  //check whether the parameter can be transmitted...
    %>
    <jsp:include page="/head.html"></jsp:include>
    I'm jsp include...
    <jsp:include page="/foot.html"></jsp:include>
<%@ include file="foot.html"%>