<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%@include file="_SessionCheck.jsp"%>

<%
String action = request.getParameter("action");
int categoryId = 0;
String strCid = request.getParameter("categoryid");
if(strCid != null && !strCid.trim().equals(""))
categoryId = Integer.parseInt(strCid);

if(action != null && action.equals("add")) {
	String name = request.getParameter("productname");
	String descr = request.getParameter("descr");
	double normalprice = Double.parseDouble(request.getParameter("normalprice"));
	double memberprice = Double.parseDouble(request.getParameter("memberprice"));
	
	
	Category c = Category.loadById(categoryId);
	if(!c.isLeaf()) {
		out.print("it's not a leaf category");
		return;
	}
	
	Product p = new Product();
	p.setId(-1);
	p.setName(name);
	p.setDescr(descr);
	p.setNormalprice(normalprice);
	p.setNormalprice(normalprice);
	p.setMemberprice(memberprice);
	p.setPdate(new Timestamp(System.currentTimeMillis()));
	p.setCategoryid(categoryId);
	
	ProductMgr.getInstance().addProduct(p);
	
	out.println("Congratulations!!");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'userdelete.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script>
		cnt = 1;
		arrLeaf = new Array();
		function checkData() {
			if(arrLeaf[document.form.categoryid.selectedIndex+1]!='leaf') {
				alert("That's not a leaf root!");
				return false;
			}
			//alert('Yes,leafNode!');
			return true;
		}
	</script>
  </head>
  
  <body>
  	<center>add product</center>
    <form action="productadd.jsp" method="post" name="form" onsubmit="return checkData()">
    	<input type="hidden" name="action" value="add" />
    	<table>
    		<tr>
    			<td>productName</td>
    			<td><input type="text" name="productname"/></td>
    		</tr>
    		
    		<tr>
    			<td>productDescription</td>
    			<td><textarea name="descr" rows="8" cols="40"></textarea></td>
    		</tr>
    		
    		<tr>
    			<td>normalPrice</td>
    			<td><input type="text" name="normalprice"/></td>
    		</tr>
    		
    		<tr>
    			<td>memberPrice</td>
    			<td><input type="text" name="memberprice"/></td>
    		</tr>
    		
    		<tr>
    			<td>category</td>
    			<td>
					<select name="categoryid">
						<%
						List<Category> categories = Category.getCategories();
						for(Iterator<Category> it=categories.iterator();it.hasNext();) {
							Category c = it.next();
							String pre = "";
							for(int i=1;i<c.getGrade();i++) 
								pre += "--";
						%>
						<option value="<%= c.getId()%>" <%= c.getId()==categoryId?"selected":""%>><%= pre + c.getName()%></option>
						
						<script>
							arrLeaf[cnt]='<%= c.isLeaf()?"leaf":"notleaf"%>';
							cnt++;
						</script>
						
						<%
						}
						%>
						
					</select>
				</td>
    		</tr>
    		
    		<tr>
    			<td colspan="2">
    			<input type="submit" value="Submit"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>







