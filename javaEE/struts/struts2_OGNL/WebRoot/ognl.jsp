<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ognl.jsp' starting page</title>

  </head>
  
  <body>
	<ol>
		<li>访问值栈中的action的普通属性: username = <s:property value="username"/> </li>
		<li>访问值栈中对象的普通属性(get set方法)：<s:property value="user.age"/> | <s:property value="user['age']"/> | <s:property value="user[\"age\"]"/> | wrong: <%--<s:property value="user[age]"/>--%></li>
		<li>访问值栈中对象的普通属性(get set方法): <s:property value="cat.friend.name"/></li>
		<li>访问值栈中对象的普通方法：<s:property value="password.length()"/></li>
		<li>访问值栈中对象的普通方法：<s:property value="cat.miaomiao()" /></li>
		<li>访问值栈中action的普通方法：<s:property value="m()" /></li>
		<hr />
		<li>访问静态方法：<s:property value="@struts2.ognl.S@s()"/></li>
		<li>访问静态属性：<s:property value="@struts2.ognl.S@STR"/></li>
		<li>访问Math类的静态方法：<s:property value="@@max(2,3)" /></li>
		<hr />
		<li>访问普通类的构造方法：<s:property value="new struts2.ognl.User(18)"/></li>
		<hr />
		<li>访问List:<s:property value="users"/></li>
		<li>访问List中某个元素:<s:property value="users[1]"/></li>
		<li>访问List中元素某个属性的集合:<s:property value="users.{age}"/></li>
		<li>访问List中元素某个属性的集合中的特定值:<s:property value="users.{age}[0]"/> | <s:property value="users[0].age"/></li>
		<li>访问Set:<s:property value="dogs"/></li>
		<li>访问Set中某个元素:<s:property value="dogs[1]"/></li>
		<li>访问Map:<s:property value="dogMap"/></li>
		<li>访问Map中某个元素:<s:property value="dogMap.dog101"/> | <s:property value="dogMap['dog101']"/> | <s:property value="dogMap[\"dog101\"]"/></li>
		<li>访问Map中所有的key:<s:property value="dogMap.keys"/></li>
		<li>访问Map中所有的value:<s:property value="dogMap.values"/></li>
		<li>访问容器的大小：<s:property value="dogMap.size()"/> | <s:property value="users.size"/> </li>
		<hr />
		<li>投影(过滤)：<s:property value="users.{?#this.age==1}[0]"/></li>
		<li>投影：<s:property value="users.{^#this.age>1}.{age}"/></li>
		<li>投影：<s:property value="users.{$#this.age>1}[0].age"/></li>
		<li>投影：<s:property value="users.{$#this.age>1}.{age} == null"/></li>
		<hr />
		<li>[]:<s:property value="[0]"/>|<s:property value="[0].username"/></li> <!-- From stack top to bottom -->
	</ol>
	
  </body>
  <s:debug></s:debug>
</html>
