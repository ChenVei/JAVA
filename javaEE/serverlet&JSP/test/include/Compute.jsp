<%@ page language="java" %>

<%
	String s1 = request.getParameter("value1");
	String s2 = request.getParameter("value2");
%>

<% if(request.getParameter("compute").equals("division")) { %>
	<jsp:include page="division.jsp" flush="true">
		<jsp:param name="v1" value="<%=s1%>" />
		<jsp:param name="v2" value="<%=s2%>" />
	</jsp:include>
<% } else { %>
	<%@ include file="multiplication.jsp" %>
<% } %>