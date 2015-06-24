<html>
<head>
	<title>Declarations</title>
</head>
	<%
		String bgc = request.getParameter("bgcolor");
		boolean yes = false;
		if (bgc != null) {
			yes = true;
		}
		else bgc = "white";
	%>
<body bgcolor="<%= bgc %>">
	
	<h1>Jsp Declarations</h1>
	<%! int cnt1 = 0; %><!--全局变量  -->
	<% int cnt2 = 0; %><!--局部变量  -->
	<h2>Access to page since reboot:</h2>
	<%= ++cnt1 %>
	<br />
	<%= ++cnt2 %>
	<%
		if (yes) {
			out.println("You supplied an explicit bgcolor:" + bgc);
		}
		else
			out.println("Default Color:White");
	%>
	<ul>
		<li>current time:<%= new java.util.Date() %></li>
		<li>hostName:<%= request.getRemoteHost() %></li>
		<li>session ID:<%= session.getId()%></li>
		<li><%= request.getParameter("testParam") %></li>
	</ul>
</body>
</html>