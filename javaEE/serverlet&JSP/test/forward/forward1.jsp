<html>
<head>
	<title>forward1</title>
</head>
<body bgcolor="red">
	forward
<jsp:forward page="forforward1.jsp">
	<jsp:param name="name" value="m" />
	<jsp:param name="oldName" value='<%=request.getParameter("name")%>' />
	<jsp:param name="roles" value="manager" />
</jsp:forward>

</body>
</html>