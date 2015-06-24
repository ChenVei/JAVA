<html>
<head>
	<title>Division</title>
</head>
<body>
<%
	try {
		float x = Float.parseFloat(request.getParameter("v1"));
		float y = Float.parseFloat(request.getParameter("v2"));
		double r = x / y;
	}
%>
		<%= x + "/" + y + "=" r%>
<%
	catch(Exception e) {
		out.println("illegal parameter!")
	}
%>
</body>
</html>