<html>
<head>
	<title>PageBean</title>
</head>
<body>
	<jsp:useBean id="c" scope="page" class="bean.CounterBean" />
	count:<jsp:getProperty name="c" property="count" /> 
</body>
</html>