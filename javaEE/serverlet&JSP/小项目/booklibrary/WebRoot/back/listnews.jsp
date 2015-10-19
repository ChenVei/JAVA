<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@page import="cn.domain.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
BusinessServiceImpl bs = new BusinessServiceImpl();
List<News> list = bs.getAllNews();
request.setAttribute("list", list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<style type="text/css"></style></head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tbody><tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tbody><tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tbody><tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14"></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 用户信息列表</span></td>
              </tr>
            </tbody></table></td>
            <td><div align="right"><span class="STYLE1"> &nbsp;</span></div></td>
          </tr>
        </tbody></table></td>
      </tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tbody><tr>
        
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">新闻id</span></div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">新闻标题</span></div></td>
        <td width="16%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">新闻时间</span></div></td>
    	<td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      
      
      
        <c:forEach var="n" items="${list }">
      <tr>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${n.id }</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><a href="front/news.jsp?id=${n.id }">${n.title }</a></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${n.pdate }</div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE21"><a href="servlet/NewsServlet?method=delete&id=${n.id }">delete</a></span></div></td>
      </tr>
        </c:forEach>
    </tbody></table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tbody><tr>
            
            
          </tr>
        </tbody></table></td>
      </tr>
    </tbody></table></td>
  </tr>
</tbody></table>


<div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 152px; top: 24px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>