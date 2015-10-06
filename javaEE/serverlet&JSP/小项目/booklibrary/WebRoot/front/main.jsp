<%@page import="cn.domain.Book"%>
<%@page import="cn.domain.Category"%>
<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	
	BusinessServiceImpl bs = new BusinessServiceImpl();
	List<Category> categories = bs.getAllCategories();
	List<Book> books = bs.getBooks();
	request.setAttribute("categories", categories);
	request.setAttribute("books", books);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0026)http://hbdx.chineseall.cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>书香湖大-我们读书吧！</title>

<link href="http://hbdx.chineseall.cn/orgcommon/common/layout.css"
	rel="stylesheet">
<script type="text/javascript" src="front/main/tab.js"></script>
<script type="text/javascript" src="front/main/jquery.min.js"></script>
<style type="text/css">
div.bookBox01 .bookdiv02 {
	height: auto;
	overflow: auto;
	_zoom: 1;
}

div.bookBox01 .bookdiv02 h2 {
	margin: 0 0 10px;
}

div.flashJsImg ul li {
	float: left;
	margin-right: 14px;
	position: relative;
	z-index: 100;
}

.xScrollStick {
	position: absolute;
	padding: 5px;
	width: 160px;
	height: 190px;
}

.d1 {
	left: 5px;
	top: 270px;
	z-index: 8000;
}

.d2 {
	right: 5px;
	top: 270px;
	z-index: 8000;
}

.d3 {
	left: 5px;
	top: 50px;
	z-index: 8000;
}

.d4 {
	right: 5px;
	top: 50px;
	z-index: 8000;
}

.indexUserList_dl dd {
	background: none repeat scroll 0 0 #ff530d;
	color: #f8f9f0;
	display: none;
	font-size: 14px;
	height: 60px;
	left: -5px;
	padding: 5px 5px 5px 75px;
	position: absolute;
	top: -5px;
	width: 60px;
}

a:hover,.textList li em a:hover,.rbox4 li a:hover,.hdList li a:hover,.huodong_list_b a:hover,.shaixuan dd li a:hover,.sideMenu li.on a:hover,.sideMenu li.on a em:hover,.boxListLi5 h2 a:hover,.boxListLi6 h3 a:hover,.indexUser .canjiaArea .btn a:hover
	{
	color: #6174ae;
}
</style>
<script type="text/javascript">
	var BROWSERNAME = "";
	switch (navigator.appName.toLowerCase()) {
	case "netscape":
		BROWSERNAME = "ns";
		break;
	case "microsoft internet explorer":
	default:
		BROWSERNAME = "ie";
		break;
	}
	//**óʼ¼****** 
	switch (BROWSERNAME) {
	case "ns":
		window.addEventListener("load", _xScrollStick_init, false);
		break;
	case "ie":
	default:
		window.attachEvent("onload", _xScrollStick_init);
	}
	//**ʼ****** 
	function _xScrollStick_init() {
		var allTheScrollSticks = document.getElementsByTagName("div");
		for (var i = 0; i < allTheScrollSticks.length; i++) {
			if (allTheScrollSticks[i].className
					.match(/^((xScrollStick)|(.+ +xScrollStick)|(xScrollStick +.+)|(.+ +xScrollStick +.+))$/))
				_xScrollStick_event_doInit(allTheScrollSticks[i]);
		}
		window_event_scroll();
	}
	//**¼Ӧ****** 
	function _xScrollStick_event_doInit(element) {
		//ʼ 
		element.offX = element.offsetLeft;
		element.offY = element.offsetTop;

		//÷ 
		element.Stick = _xScrollStick_method_Stick;

		//¼ 
		switch (BROWSERNAME) {
		case "ns":
			window.addEventListener("scroll", window_event_scroll, false);
			break;
		case "ie":
		default:
			window.attachEvent("onscroll", window_event_scroll);
		}

		//ȡ 
		// 
		document.body.parentNode.onscroll = window_event_scroll;
	}
	function window_event_scroll() {
		var allTheScrollSticks = document.getElementsByTagName("div");
		for (var i = 0; i < allTheScrollSticks.length; i++) {
			if (allTheScrollSticks[i].className
					.match(/^((xScrollStick)|(.+ +xScrollStick)|(xScrollStick +.+)|(.+ +xScrollStick +.+))$/))
				try {
					allTheScrollSticks[i].Stick();
				} catch (e) {
				}
		}
	}
	//******** 
	function _xScrollStick_method_Stick() {
		var x = this.offX, y = this.offY, po = this;
		this.style.position = "absolute";
		x += document.body.parentNode.scrollLeft;
		y += document.body.parentNode.scrollTop;
		this.style.left = x + "px";
		this.style.top = y + "px";
	}
	function hiddenAdv(obj) {
		obj.parentNode.style.display = 'none';
	}
</script>

<script type="text/javascript">
	function scrollImg() {
		var posX, posY;
		if (window.innerHeight) {
			posX = window.pageXOffset;
			posY = window.pageYOffset;
		} else if (document.documentElement
				&& document.documentElement.scrollTop) {
			posX = document.documentElement.scrollLeft;
			posY = document.documentElement.scrollTop;
		} else if (document.body) {
			posX = document.body.scrollLeft;
			posY = document.body.scrollTop;
		}
		var ad = document.getElementById("rightOrgAdverti");
		ad.style.top = (posY + 200) + "px";
		ad.style.right = (posX + 30) + "px";
		setTimeout("scrollImg()", 100);
	}
</script>
<style type="text/css"></style>
</head>

<body onload="sendPageHeight()">












	<style>
body {
	background: url(/orgcommon/common/img/body.jpg) center top no-repeat;
}
</style>



	<style type="text/css">
#myroomtag {
	width: 200px;
	height: 116px;
	position: absolute;
	top: 30px;
	right: 2px;
	display: none;
	z-index: 1000;
}

#myroomtag .bg {
	border: #000000 1px solid;
	height: 114px;
	background: #000000;
	opacity: 0.5;
	filter: Alpha(Opacity = 50);
	position: relative;
	z-index: 100;
}

#myroomtag .tag {
	position: absolute;
	top: 10px;
	left: 0;
	line-height: 24px;
	z-index: 101;
}

#myroomtag .tag a {
	margin-left: 26px;
}

#myroomtag .tag a:hover {
	color: red;
}

.baruser {
	float: right;
	position: relative;
	z-index: 3100;
	padding-right: 10px;
}

.baruser .name {
	color: #ff6600;
}

.baruser .myroom {
	margin-right: 5px;
	padding-right: 8px;
	cursor: pointer;
	background: url(/common/style/agency/common/icon_jt.png) no-repeat right
		5px;
}

#suborgtag {
	width: 200px;
	height: 116px;
	position: absolute;
	top: 30px;
	right: 2px;
	display: none;
	z-index: 1000;
}

#suborgtag .bg {
	border: #000000 1px solid;
	height: 114px;
	background: #000000;
	opacity: 0.5;
	filter: Alpha(Opacity = 50);
	position: relative;
	z-index: 100;
}

#suborgtag .tag {
	position: absolute;
	top: 10px;
	left: 0;
	line-height: 24px;
	z-index: 101;
}

#suborgtag .tag a {
	margin-left: 26px;
}

#suborgtag .tag a:hover {
	color: red;
}

.baruser .suborg {
	margin-right: 5px;
	padding-right: 8px;
	cursor: pointer;
	background: url(/common/style/agency/common/icon_jt.png) no-repeat right
		5px;
}
</style>
	<link href="front/main/util.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="front/main/head.js" defer=""></script>
		<script type="text/javascript" src="front/main/util.js"></script>

		<div class="header">

			<div class="header-bg1">
				<div class="headTop" style="overflow:visible;">
					<div class="headMenu" style="float:left;">






						<a >我们读书吧</a>


					</div>

					<div id="loginlink" class="baruser">
						HI， <a style="cursor: pointer;" onclick="loginBox();">请登录</a><a
							href="http://hbdx.chineseall.cn/sso/reg.jsps?orgCode=1652">注册</a>
					</div>
				</div>
			</div>

			<script language="javascript">
				$
						.ajax({
							url : '/sso/loginUserInfo.jsps?t=' + new Date(),
							type : 'GET',
							dataType : 'text',
							timeout : 1000,
							error : function() {
							},
							success : function(data) {
								if (data.length > 0) {
									var json = eval('(' + data + ')');
									if (json.id > 0) {
										$("#login_div").hide();
										$("#displayname")
												.html(json.displayName);
										if (json.displayName.length == 0) {
											$("#displayname").html(
													json.userName);
										}
										//$("#myroom").html("<a href='/user/userIndex.jsps'>我的书房</a>");
										$("#letternum").html("书信");
										if (json.letterNum > 0) {
											$("#letternum").html(
													"书信(" + json.letterNum
															+ ")");
										}
										if (json.orgCode == null) {
											$("#myorg").remove();
										} else {
											if (json.domain) {
												$("#myorg")[0].href = "http://"
														+ json.domain
														+ "/org/show/index";
											} else {
												$("#myorg")[0].href = "/org/show/"
														+ json.orgCode;
											}
										}
										if (json.type != 2) {
											$("#orgmanage").remove();
										}
										if (json.domain.length > 0) {
											$("div#loginlink a").each(
													function() {
														//var hh='http://'+json.domain+$(this).attr("href");
														//$(this).attr("href",hh);
													});
										}
									} else {
										$("#loginlink")
												.html(
														"HI， <a style='cursor: pointer;' onclick='loginBox();' >请登录</a><a href='/sso/reg.jsps?orgCode=1652'>注册</a>");
									}
								} else {
									$("#loginlink")
											.html(
													"HI， <a style='cursor: pointer;' onclick='loginBox();' >请登录</a><a href='/sso/reg.jsps?orgCode=1652'>注册</a>");
								}
							}
						});
			</script>
			<div class="headMain">

				<h1 style="font-size:35px;color: #0000FF;">书香湖大-我们读书吧</h1>


				<div class="headSearch">
					<input class="ipt" type="text" id="searchKey"
						onmouseout="if(this.value=='')this.value=this.defaultValue"
						onmouseover="if(this.value==this.defaultValue)this.value=''"
						value="书名、作者名"> <input class="btn" type="button" onclick="jump()" value="">
				</div>
<script>
	function jump() {
		var name = document.getElementById('searchKey').value;
		window.location.href='servlet/UIServlet?method=getSpecfic&name='+name;
	}
</script>
			</div>

			<div class="header-img"></div>
			<div class="header-bg2">
				<div class="headNav" id="channels">


					<ul>

<!-- **********************Title****************************** -->						
						<li class="aIndex">
							<a href="front/main.jsp">首页</a></li>
						<li>
							<A>全部图书：</A>
						</li>

						<c:forEach var="c" items="${categories }">
							<li><a
								href="servlet/UIServlet?cid=${c.id }" target="_blank">${c.name }
								</a>
							</li>
						</c:forEach>
<!-- **************************************************** -->	
					</ul>

				</div>
				<script type="text/javascript">
					$("#channels").children().last().attr('class', 'nob');
				</script>

				<div class="headBottom"></div>
			</div>
		</div>




		<div class="banner950" id="topAdverti"></div>



		<div class="banner950"></div>

		<div class="layout mtb10">
			<div class="w950 left">

				<c:forEach var="c" items="${categories }">
				<div class="bb1 lbox3 mt10">
					<div class="tit1">
						<h2>${c.name }</h2>
						<span><a
							href="servlet/UIServlet?method=getAll&cid=${c.id }"
							target="_blank">查看更多图书»</a></span>
						<ul class="bookTab2">
							<li id="ltab3_btn0" class="hot_a">1</li>
							<li id="ltab3_btn1">2</li>
							<li id="ltab3_btn2">3</li>
						</ul>
					</div>
					<div class="con">
						<div class="lbox2_list bj85" id="ltab3_div0">
							<!--*********************************************************************-->
							<c:forEach var="b" items="${c.books }" end="5">
															<div class="bookJs">
								<a href="front/detail.jsp?id=${b.id }"
									target="_blank"><img src="img/bookcover/${b.id }.jpg"
									alt="${b.name }"></a>
								<h3>
									<a href="front/detail.jsp?id=${b.id }"
										target="_blank"> ${b.name } </a>
								</h3>
								<span>${b.author }著/中国人民大学出版社</span>
								<p>
									出版时间：${b.pdate }<br>
										${b.description }
									
								</p>

								<div class="xingxing">
									<strong>评价：</strong><span class="s4">评星</span><br>
								</div>
								<p></p>
							</div>
							</c:forEach>
							<!--*********************************************************************-->
						</div>
					</div>
				</div>
				</c:forEach>

			</div>
		</div>
		<div class="banner950"></div>
		<div class="indexMenuList mtb10">
			<ul id="orgStat">
				<li class="b1">访问人次:<em>26592</em></li>
				<li class="b2">个人书房:<em>851</em></li>
				<li class="b3">下属组织:<em>0</em></li>
				<li class="b4">机构活动:<em>0</em></li>
				<li class="b5">电子图书:<em>106244</em></li>
			</ul>
		</div>
		<script type="text/javascript">
			$
					.ajax({
						url : '/org/updateVisitCount.jsps?orgCode=1652&t='
								+ new Date(),
						type : 'GET',
						dataType : 'text',
						timeout : 1000,
						error : function() {
						},
						success : function(data) {
						}
					});

			function sendPageHeight() {
				try {
					if (window.parent) {
						window.parent
								.setiFrameHeight(document.body.scrollHeight);
					}
				} catch (e) {
					window.console && window.console.info(e);
				}
			}
		</script>






		<!--#include file="/public/footer.html"-->

		<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
					: " http://");
			document
					.write(unescape("%3Cscript src='"
							+ _bdhmProtocol
							+ "hm.baidu.com/h.js%3F961aa2cba564c3f71bfbb0a4cf919ac9' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script src="front/main/h.js" type="text/javascript"></script>

		<div class="_bd_ext_tip _bd_ext_search_mode"
			style="visibility: hidden; left: 228px; top: 1950px;">
			<span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span
				class="_bd_ext_copy">复制</span>
		</div>
</body>
</html>