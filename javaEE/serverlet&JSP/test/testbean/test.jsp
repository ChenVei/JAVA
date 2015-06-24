<%@ page import="bean.*" %>

<%-- <% CounterBean c = new CounterBean(); %>  --%>

<jsp:useBean id="c" class="bean.CounterBean" />
<jsp:setProperty name="c" property="count" value="23" />
<jsp:getProperty name="c" property="count" />

<h1 style="color:Red">
	<%-- <%c.setCount(32);%>  --%>
	<%= c.getCount()%>
</h1>

