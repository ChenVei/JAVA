<jsp:useBean id="s" scope="session" class="bean.CounterBean" />
<%--
	CounterBean s = (CounterBean)session.getAtribute("s");
	if(s == null) {
		s = new CounterBean(); 
		session.setAttribute("s", s);
	}
--%>
<%= "count:" + s.getCount()%>