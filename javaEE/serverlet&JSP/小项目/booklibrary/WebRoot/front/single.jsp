<%@page import="cn.dao.impl.BookDaoImpl"%>
<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@page import="cn.domain.Book"%>
<%@page import="cn.domain.PageBean"%>
<%@page import="cn.domain.QueryInfo"%>
<%@page import="cn.domain.Category"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	BusinessServiceImpl bs = new BusinessServiceImpl();
	List<Category> list = bs.getAllCategories();
	request.setAttribute("list", list);
	
	QueryInfo qi = new QueryInfo();
	qi.setCurrentpage(1);
	qi.setPagesize(8);
	PageBean<Book> pb = bs.queryBook(qi);
	List<Book> books = pb.getList();
	
	String id = request.getParameter("id");
	BookDaoImpl bdi = new BookDaoImpl();
	Book b = bdi.find(Integer.parseInt(id));
	request.setAttribute("b", b);

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/front/";

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<base href="<%=basePath%>">
<title>Single</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<!-- start plugins -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href="http://fonts.useso.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet" type="text/css">
    <style type="text/css">
.body-wrapper .para{font-size:14px;word-wrap:break-word;color:#333;margin-bottom:15px;text-indent:2em;line-height:24px;zoom:1}.body-wrapper sup{position:relative;top:-.5em;line-height:0;font-size:75%;vertical-align:baseline;cursor:default}
        .style1
        {
            font-size: 14px;
            color: #000000;
        }
        </style>
</head>
<body>
<div class="container">
	<div class="container_wrap">
		<div class="header_top">
		    <div class="col-sm-3 logo"><a href="${pageContext.request.contextPath}/front/index.jsp"><img src="images/logo.jpg" alt="" /></a></div>
			    <div class="col-sm-6 nav">
			  <ul>
				<!-- *********************Categories************************************* -->
						<c:forEach var="c" items="${list }">
							<li><span class="simptip-position-bottom simptip-movable"
								data-tooltip="${c.name }"><a href=../servlet/UIServlet?method=getAll&cid=${c.id }" target="_blank">
								</a> </span></li>
						</c:forEach>
						<!-- *********************Categories************************************* -->
				 
               </ul>
			</div>
			<div class="col-sm-3 header_right">
			   <ul class="header_right_box">
	
				<c:choose>
						   <c:when test="${user != null }">  
						       <c:out value="欢迎您，${user.username }"></c:out>
						       <a href="../servlet/UserServlet?method=quit">注销</a>
						   </c:when>
						   <c:otherwise> 
						    <span class="simptip-position-bottom simptip-movable"
							data-tooltip="登录/注册"><a href=login.html>
								<li class="last"><i class="edit"></i></li>
							</a></span>
							<div class="clearfix"></div>
						   </c:otherwise>
						</c:choose>
			   </ul>
			</div>
			<div class="clearfix"> </div>
	      </div>
	   <div class="content">
      	   <div class="movie_top">
      	         <div class="col-md-9 movie_box">
                        <div class="grid images_3_of_2">
                        	<div class="movie_image">
                                <span class="movie_rating">5.0</span>
                                <img src="../img/bookcover/${b.id }.jpg" class="img-responsive" alt="${b.name }">
                            </div>
                            <div class="movie_rate">
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="para">
                            书 名：${b.name }<br>
                            作 者：${b.author }<br>
                            类 型：<c:forEach var="c" items="${b.categories }">${ c.name} | </c:forEach> <br>
                            出版时间：${b.pdate }<br>
                            出版社：${b.publisher }<br>
                            漫画简介：<br>
&nbsp;&nbsp;&nbsp;
                          ${b.description }</div>
                           
		                <div class="single">
		                <h1>新书速递</h1>
		                <ul class="single_list">
					        <li>
					            <div class="preview">
                                <a href="single.html"><img src="images/追风筝的人.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
					                <div class="para">
                                        书 名：追风筝的人<br>
                                        作 者：卡勒德·胡赛尼（Khaled Hosseini） 
                                        <br>
                                        类 别：长篇小说<br>
                                        出版时间：2003年<br>
                                        内容简介：<br>
&nbsp;&nbsp; 《追风筝的人》是阿富汗斯坦作家哈利德·侯赛尼（Khaled Hosseini）的第一部小说，于2003年出版，是美国2005年的排名第三的最畅销书。<br>
&nbsp;&nbsp; 全书围绕风筝与阿富汗两个少年之间展开，一个富家少年与家中仆人关于风筝的故事，关于人性的背叛与救赎。</div>
					                <p>&nbsp;</p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					         
					         
					     	
					        <li>
					            <a href="single.html"></a><div class="preview"><a href="single.html"></a><a href="#"><img src="images/狼图腾.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
                                     书 名：狼图腾<br>
                                     作 者：姜戎
                                     <br>
                                     类 别：长篇小说 <br>
                                     出版时间：2004年4月<br>
                                     内容简介：<br>
&nbsp;&nbsp; 《狼图腾》是一部以狼为叙述主体的小说，讲述了上个世纪六七十年代一位知青在内蒙古草原插队时与草原狼、游牧民族相依相存的故事。<br>
					            </div>
					            <div class="clearfix"></div>
					        </li>
			  			</ul>
                      </div>
                      </div>
                       
                      <div class="clearfix"> </div>
                  </div>
           </div>
    </div>
</div>
<div class="container"> 
 <footer id="footer">
 	<div id="footer-3d">
		<div class="gp-container">
			<span class="first-widget-bend"> </span>
		</div>		
	</div>
    <div id="footer-widgets" class="gp-footer-larger-first-col">
		<div class="gp-container">
            <div class="footer-widget footer-1">
            	<div class="wpb_wrapper">
					<img src="images/f_logo.png" alt="">
				</div> 
	          <br>
	          <p>经过我们不懈努力终于做出了这个网站</p>
			  <p class="text">仍有许多功能不完善，希望大家多多包涵</p>
			 </div>
			 <div class="footer_box">
			  <div class="col_1_of_3 span_1_of_3">
					<h3>实用分类</h3>
					<ul class="first">
						<li><a href="#">历史记录</a></li>
						<li><a href="#">快速查询</a></li>
						<li><a href="#">好书推荐</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>书本信息</h3>
					<ul class="first">
						<li><a href="#">新书速递</a></li>
						<li><a href="#">畅销热书</a></li>
						<li><a href="#">书本纠错</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>关注我们</h3>
					<ul class="first">
						<li><a href="#">微博</a></li>
						<li><a href="#">微信</a></li>
						<li><a href="#">qq空间</a></li>
					</ul>
					<div class="copy">
				      <p>欢迎联系湖北大学的我们</p>
			        </div>
		     </div>
		    <div class="clearfix"> </div>
	        </div>
	        <div class="clearfix"> </div>
		</div>
	</div>
  </footer>
</div>		

<div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 175px; top: 912px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>