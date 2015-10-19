<%@page import="cn.domain.Category"%>
<%@page import="cn.dao.impl.CategoryDaoImpl"%>
<%@page import="cn.domain.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String id = request.getParameter("cid");
request.setAttribute("cid", id);

CategoryDaoImpl cdi = new CategoryDaoImpl();
if(id != null) { 
Category c = cdi.getCategory(id);
request.setAttribute("c", c);
}

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/front/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<base href="<%=basePath%>">
<title>${c.name }</title>
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
								data-tooltip="${c.name }"><a href="${pageContext.request.contextPath}/servlet/UIServlet?method=getAll&cid=${c.id }" target="_blank">
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
	   	   <h2 class="m_3">${c.name }</h2>
      	       <div class="movie_top">
      	         <div class="col-md-9 movie_box">
                        
                      <c:forEach var="b" items="${pb.list }">
                      <div class="movie movie-test movie-test-dark movie-test-left">
                          <div class="movie__images">
                              <a href="${pageContext.request.contextPath}/front/single.jsp?id=${b.id }" target="_blank" class="movie-beta__link">
                                  <img alt="${b.name }" src="${pageContext.request.contextPath}/img/bookcover/${b.id }.jpg" width="306" height="350" class="img-responsive">
                              </a>
                          </div>
                          <div class="movie__info">
                              <a href="${pageContext.request.contextPath}/front/single.jsp?id=${b.id }" target="_blank" class="movie__title"> ${b.name }</a>
                              <br><br>
                              
                          	    作者: ${b.author }
                          	    
                          	  <br>
                              <br>
                              <p class="movie__option">
                              	类别：<c:forEach var="c" items="${b.categories }" >
                             		 <a href="../servlet/UIServlet?method=getAll&cid=${c.id }" target="_blank">${c.name }</a> |  
                              	</c:forEach>
                              </p><br>
                              <p class="movie__option">
                              	出版社： ${b.publisher }
                              </p><br>
                              <ul class="list_6">
                                  <li><i class="icon1"> </i><p><%=(int)(Math.random()*10000) %></p></li>
                                  <li><i class="icon3"> </i><p><%=(int)(Math.random()*1000) %></p></li>
                                  <br>
                                  <li>评价 : &nbsp;&nbsp;<p><img src="images/rating1.png" alt=""></p></li>
                                  <div class="clearfix"> </div>
                              </ul>
                          </div>
                          <div class="clearfix"> </div>
                      </div>
                      </c:forEach>
                         

                      </div>
                  
                      <br>
                      
                      <div class="clearfix"> </div>
</div>
		<!-- *************************pageSeparate********************* -->
		<div id="pagination" style="display: block;">
							<div class="pagination">
								<span class="current prev"><a href="javascript:void(0)"
									onclick="gotopage(${pb.previouspage})">上一页</a></span>
								<%
									PageBean pb = (PageBean)request.getAttribute("pb");
								pb.getTotalpage();
								%>
								<!-- ***************頁碼********************** -->
								<c:forEach var="i" items="${pb.pagebar }">
									<c:if test="${i==pb.currentpage }">
										<span class="current">${i }</span>
									</c:if>
									<c:if test="${i!=pb.currentpage }">
										<a href="javascript:void(0)" onclick="gotopage(${i})">${i }</a>
									</c:if>
								</c:forEach>
								<!-- ************************************* -->
								<a href="javascript:void(0)" onclick="gotopage(${pb.nextpage})"
									class="next">下一页</a>
							</div>
						</div>
</div>
</div>
<script type="text/javascript">
function gotopage(currentpage) {
	if (currentpage > ${pb.totalrecord} || currentpage < 1) {
		alert('wrong input...');
	} else { 
		window.location.href = '${pageContext.request.contextPath}/servlet/UIServlet?method=${method}<%=id==null?"":"&cid="+id%>&currentpage='+ currentpage + '&name=${name}';
		}
	}
</script>
<div class="container"> 
 <footer id="footer">
 	<div id="footer-3d">
		<div class="gp-container">
			<span class="first-widget-bend"></span>
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

</div><div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 711px; top: 297px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>