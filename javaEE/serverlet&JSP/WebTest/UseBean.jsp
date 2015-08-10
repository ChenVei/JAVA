<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %> <%--errorPage="error.jsp" --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'UseBean.jsp' starting page</title>
  </head>
  <body>
  	<jsp:useBean id="person" class="bean.Person" scope="page"></jsp:useBean>  <!--bean must be keeped in package..-->
  	<jsp:setProperty property="*" name="person"/>
	<div align="Center">
    	<form action="UseBean.html" method="post">
	    	<fieldset style="width:300">
	    		<legend>
	    			Fill the personal info
	    		</legend>
	    		<table align="center">
	    			<tr>
	    				<td class="tt">name:</td>
	    				<td><jsp:getProperty property="name" name="person"/></td>
	    			</tr>
	    			<tr>
	    				<td class="tt">age:</td>
	    				<td><jsp:getProperty property="age" name="person"/></td>
	    			</tr>
	    			<tr>
	    				<td class="tt">sex:</td>
	    				<td><jsp:getProperty property="sex" name="person"/>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td></td>
	    				<td><input type="submit" value="Return"/></td>
	    			</tr>
	    		</table>
	    	</fieldset>
    	</form>
    </div>
    <%if("jump".equals(request.getParameter("action"))) {%> <%--seal the getRequestDispacher method, just on server --%>
    <jsp:forward page="UseBean.html">
    	<jsp:param value="v1" name="p1"/>
    	<jsp:param value="v2" name="p2"/>
    </jsp:forward>
    <%} %>
  </body>
</html>
