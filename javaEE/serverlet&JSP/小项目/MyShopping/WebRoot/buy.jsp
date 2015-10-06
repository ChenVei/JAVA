<%@page import="com.bjsxt.shopping.Cart"%>
<%@page import="com.bjsxt.shopping.CartItem"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%--
Cart cart = (Cart)session.getAttribute("cart");
if(cart == null) {
	cart = new Cart();
	session.setAttribute("cart", cart);
}
--%>
<jsp:useBean id="cart" class="com.bjsxt.shopping.Cart" scope="session"></jsp:useBean> 

<%
int id = Integer.parseInt(request.getParameter("id"));
Product p = ProductMgr.getInstance().loadById(id);

CartItem item = new CartItem();
item.setCount(1);
item.setPrice(p.getMemberprice());
item.setProductId(p.getId());

cart.add(item);

response.sendRedirect("cart.jsp");
%>





