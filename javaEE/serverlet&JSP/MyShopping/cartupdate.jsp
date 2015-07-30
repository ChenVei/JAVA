<%@page import="com.bjsxt.shopping.CartItem"%>
<%@page import="com.bjsxt.shopping.Cart"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:useBean id="cart" class="com.bjsxt.shopping.Cart" scope="session"></jsp:useBean>
<%
List<CartItem> items = cart.getItems();
for(int i = 0; i < items.size(); i++) {
	CartItem item = items.get(i);
	String strCnt = request.getParameter("p"+item.getProductId());
	if(strCnt != null && !strCnt.trim().equals("")) {
		item.setCount(Integer.parseInt(strCnt));
	}
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'cartupdate.jsp' starting page</title>

  </head>
  
  <body>
    OK. <br>
  </body>
</html>


<script language="JavaScript1.2" type="text/javascript">
<!--
//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("t").innerHTML;
	if(delay <= 0) 
		window.top.location.href = url;
	else {
		delay--;
		document.getElementById("t").innerHTML = delay;
		setTimeout("delayURL('" + url + "')", 1000);
	}
}

//-->

</script>

<br />
<a href="cart.jsp"><span id="t">2</span>s left back to home page</a>
<script>delayURL("cart.jsp")</script>

<% 
/* response.sendRedirect("cart.jsp"); */
%>