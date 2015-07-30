<%@page import="java.sql.Timestamp"%>
<%@page import="com.bjsxt.shopping.SalesOrder"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.CartItem"%>
<%@page import="com.bjsxt.shopping.Cart"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:useBean id="cart" class="com.bjsxt.shopping.Cart" scope="session"></jsp:useBean>

<%
User u = (User)session.getAttribute("user");
String addr = request.getParameter("addr");
SalesOrder so = new SalesOrder();
if(u == null) {
	u = new User();
	u.setId(-1);
}
so.setUser(u);
so.setCart(cart);
so.setAddr(addr);
so.setoDate(new Timestamp(System.currentTimeMillis()));
so.setStatus(0);
so.save();
session.removeAttribute("cart");
%>

<div align="center">
Thank you for presenting our website.<br/>
<a href="index.jsp">Click here to go back.</a>
</div>