<html>
<head>
	<title>RequestBean</title>
</head>
<body>
	<%@ page import="bean.*"%>
	 <jsp:useBean id="c" scope="request" class="bean.CounterBean" /> 

	<%--
		<%
			CounterBean c = (CounterBean)request.getAttribute("c");
			if (c == null) {
				c = new CounterBean();
				request.setAttribute("c", c);
			}
		%>
	--%>
	<% c.setCount(100); %>
	<%= "count:"+c.getCount()%>
	
	<%-- <jsp:forward page="RequestBean2.jsp" /> --%>
	<%response.sendRedirect("RequestBean2.jsp"); %>

</body>
</html>