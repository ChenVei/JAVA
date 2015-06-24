<%@page errorPage="ErrPage.jsp" %>
<%
	String s = "123abc";
	int a = Integer.parseInt(s);
	out.println(a);
%>
