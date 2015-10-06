<%
String str = (String)session.getAttribute("adminLogined");
if(str == null || !str.equals("true")) response.sendRedirect("login.jsp");
%>