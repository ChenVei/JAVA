<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@page import="cn.domain.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
BusinessServiceImpl bs = new BusinessServiceImpl();
String id = request.getParameter("id");
News n = bs.findNews(Integer.parseInt(id));

request.setAttribute("n", n);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>新闻</title>

<script type="text/javascript" src="./news/jquery-1.4.min.js"></script>

<link href="./news/style.css" rel="stylesheet" type="text/css">

</head>

<body>

<div id="wrapper">

	<!--滚动看图-->
	<div id="picSlideWrap" class="clearfix">
		<h3 class="titleh3">${n.title }</h3>
		<h4 class="titleh4">发布时间：${n.pdate }  |  　<A href="../servlet/UIServlet?method=getAllNews">来源:中国新闻网</A></h4>
	
		<div class="imgnav" id="imgnav"> 
			<div id="img"> 
				
				<img src="../img/newscover/${n.id }.jpg" width="780" height="570" style="display: inline;">
				
				
			</div>
		
			<div id="content">
				<p>${n.content } </p>
				<p align="right">${n.pdate }新华网</p>
			</div>
		
			         
		
		</div>
	
	</div><!--end滚动看图-->

</div>

<script type="text/javascript">
$(document).ready(function(){                          

	var index=0;
	var length=$("#img img").length;
	var i=1;

	//关键函数：通过控制i ，来显示图片
	function showImg(i){
		$("#img img").eq(i).stop(true,true).fadeIn(800).siblings("img").hide();
		$("#cbtn li").eq(i).addClass("hov").siblings().removeClass("hov");
	}

	

	
		
	$("#img img").eq(0).show();
	$("#cbtn li").eq(0).addClass("hov");
	
	$("#cbtn tt").each(function(e){
		var str=(e+1)+"/"+length;
		$(this).html(str)
	})

	$(".picSildeRight,#next").click(function(){
		slideNext();
	});
	
	$(".picSildeLeft,#front").click(function(){
		slideFront();
	});
	
	$("#cbtn li").click(function(){
		index  =  $("#cbtn li").index(this);
		showImg(index);
	});	
	
	$("#next,#front").hover(function(){
		$(this).children("a").fadeIn();
	},function(){
		$(this).children("a").fadeOut();
	});
	
});
</script>
           


</body></html>