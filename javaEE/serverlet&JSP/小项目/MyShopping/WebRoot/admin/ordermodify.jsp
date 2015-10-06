<%@page import="com.bjsxt.shopping.OrderMgr"%>
<%@page import="com.bjsxt.shopping.SalesOrder"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
int id = Integer.parseInt(request.getParameter("id"));
SalesOrder so = OrderMgr.getInstance().loadById(id);
String action = request.getParameter("action");
if(action != null && action.equals("modify")) {
	int status = Integer.parseInt(request.getParameter("status"));
	so.setStatus(status);
	OrderMgr.getInstance().updateStatus(so);
	%>
	<script>
	window.parent.main.location.reload();
	</script>
	<%
	return;
}
%>
<div align="center">
User:<%= so.getUser().getUsername()%>
<form id="st" action="ordermodify.jsp">
	<input type="hidden" name="action" value="modify" />
	<input type="hidden" name="id" value="<%= id%>" />
	
	<select name="status" id="st">
	<option value="0">Unhandled</option>
	<option value="1">Handled</option>
	<option value="2">Discarded</option>
	</select>
	<input type="submit" value="yes!"/>
</form>
</div>

<script>
for(var option in document.getElementById("st").status.options) {
		if(option.value == <%= so.getId()%>) {
			document.getElementById("st").status.selectedIndex = option.value;
		}
	}
</script>