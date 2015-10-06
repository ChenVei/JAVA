<%@page import="cn.domain.PageBean"%>
<%@page import="cn.domain.Category"%>
<%@page import="cn.dao.impl.CategoryDaoImpl"%>
<%@page import="cn.dao.impl.BookDaoImpl"%>
<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	
	String id = request.getParameter("cid");
	request.setAttribute("cid", id);
	CategoryDaoImpl cdi = new CategoryDaoImpl();
	if(id != null) { 
	Category c = cdi.getCategory(id);
	request.setAttribute("c", c);
	}
	
	BusinessServiceImpl bs = new BusinessServiceImpl();
	List<Category> categories = bs.getAllCategories();
	request.setAttribute("categories", categories);
	request.setAttribute("cat", categories);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0045)http://hbdx.chineseall.cn/org/show/sort/I24/0 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>我们读书吧-读书吧管理系统</title>


<link href="http://hbdx.chineseall.cn/orgcommon/common/layout.css"
	rel="stylesheet">
<link href="http://hbdx.chineseall.cn/orgcommon/common/yuelanshi.css"
	rel="stylesheet">
<link href="http://hbdx.chineseall.cn/orgcommon/common/search.css"
	rel="stylesheet">
<script type="text/javascript" src="./list_files/tab.js"></script>
<script type="text/javascript" src="./list_files/jquery.min.js"></script>
<style type="text/css">
.pagination {
	text-align: right;
	padding: 5px;
	padding-top: 3px;
}

.pagination a,.pagination span {
	cursor: pointer;
	margin: 5px;
	color: #617f9e;
	font-size: 12px;
}

.pagination .current {
	color: black;
}
</style>
<style type="text/css"></style>
</head>
<body>







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
	<link href="./list_files/util.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="./list_files/head.js" defer=""></script>
	<script type="text/javascript" src="./list_files/util.js"></script>

	<div class="header">

		<div class="header-bg1">
			<div class="headTop" style="overflow:visible;">
				<div class="headMenu" style="float:left;">






					<a>我们读书吧</a>


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
									$("#displayname").html(json.displayName);
									if (json.displayName.length == 0) {
										$("#displayname").html(json.userName);
									}

									$("#letternum").html("书信");
									if (json.letterNum > 0) {
										$("#letternum").html(
												"书信(" + json.letterNum + ")");
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
										$("div#loginlink a").each(function() {
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
					value="书名、作者名"> <input class="btn" type="button"
					onclick="jump()" value="">
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
					<li class="aIndex"><a href="front/main.jsp">首页</a></li>
					<li><A>全部图书：</A></li>

					<c:forEach var="c" items="${categories }">
						<li><a href="servlet/UIServlet?method=getAll&cid=${c.id }"
							target="_blank">${c.name } </a></li>
					</c:forEach>
					<!-- **************************************************** -->
				</ul>

			</div>
			<script type="text/javascript">
				$("#channels").children().last().attr('class', 'nob');
			</script>
			<div class="headBottom">

				<dl style="width: 590px;">

				</dl>

				<ul style="width: 360px;">


				</ul>
			</div>
		</div>
	</div>
	<div class="yuelanshi">
		<div class="w950 left">
			<div class="bb1 yuelanshiList">
				<div class="path">
					<h2>${c.name }</h2>
				</div>
				<div class="con">
					<!-- ****************************************************************** -->
					<c:forEach var="b" items="${pb.list }">
						<div class="boxListLi5">
							<div class="img">
								<a target="_blank" href="front/detail.jsp?id=${b.id }"><img
									src="img/bookcover/${b.id }.jpg" alt="${b.name }"></a>
							</div>
							<h2>
								<a target="_blank" href="front/detail.jsp?id=${b.id }"
									title="${b.name }">${b.name }</a>
							</h2>
							<div class="other">
								<span>${b.author } / ${b.pdate }</span>

								<div class="xingxing">
									<span class="s">评星</span><em></em>
								</div>
							</div>
							<p>${b.description }</p>
						</div>
					</c:forEach>
					<!-- ****************************************************************** -->
					<c:if test="${pb.totalrecord==0 }">
						<div align="center">抱歉，没有找到"${name }"相关的结果</div>
						<br />
						<br />
					</c:if>
					<div id="page">
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
						<input type="hidden" name="currentPage" id="currentPage" value="0">
						<input type="hidden" name="orgCode" id="orgCode" value="1652">
						<input type="hidden" id="totalSize" value="4606">
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="./list_files/jquery.pagination.js" type="text/javascript"></script>
	<script type="text/javascript">
	function gotopage(currentpage) {
		if (currentpage > ${pb.totalrecord} || currentpage < 1) {
			alert('wrong input...');
		} else { 
			window.location.href = '${pageContext.request.contextPath}/servlet/UIServlet?method=${method}<%=id==null?"":"&cid="+id%>&currentpage='+ currentpage + '&name=${name}';
			}
		}
		//评论榜

		h = '';
		for (var i = 0; i < listCommentBook.length; i++) {
			if (i == 0) {
				h += '<li class="li1 bookJs">'
						+ '<a href="/book/'+listCommentBook[i].id+'"><img onerror="javascript:this.src=\'http://img.chineseall.cn/bookpic/default.jpg\'" src="http://img.chineseall.cn'+listCommentBook[i].url+'" /></a>'
						+ '<a href="/book/'+listCommentBook[i].id+'">'
						+ listCommentBook[i].name + '</a><span>'
						+ listCommentBook[i].publisher + '</span>' + '<p>'
						+ listCommentBook[i].intro + '</p></li>';
			} else {
				h += '<li>' + '<a href="/book/'+listCommentBook[i].id+'">'
						+ listCommentBook[i].name + '</a>' + '</li>';
			}
		}
		$('#top_div0').html(h);
		//阅读榜

		h = '';
		for (var i = 0; i < listReadBook.length; i++) {
			if (i == 0) {
				h += '<li class="li1 bookJs">'
						+ '<a href="/book/'+listReadBook[i].id+'"><img onerror="javascript:this.src=\'http://img.chineseall.cn/bookpic/default.jpg\'" src="http://img.chineseall.cn'+listReadBook[i].url+'" /></a>'
						+ '<a href="/book/'+listReadBook[i].id+'">'
						+ listReadBook[i].name + '</a><span>'
						+ listReadBook[i].publisher + '</span>' + '<p>'
						+ listReadBook[i].intro + '</p></li>';
			} else {
				h += '<li>' + '<a href="/book/'+listReadBook[i].id+'">'
						+ listReadBook[i].name + '</a>' + '</li>';
			}
		}
		$('#top_div1').html(h);
		//收藏榜

		h = '';
		for (var i = 0; i < listColBook.length; i++) {
			if (i == 0) {
				h += '<li class="li1 bookJs">'
						+ '<a href="/book/'+listColBook[i].id+'"><img onerror="javascript:this.src=\'http://img.chineseall.cn/bookpic/default.jpg\'" src="http://img.chineseall.cn'+listColBook[i].url+'" /></a>'
						+ '<a href="/book/'+listColBook[i].id+'">'
						+ listColBook[i].name + '</a><span>'
						+ listColBook[i].publisher + '</span>' + '<p>'
						+ listColBook[i].intro + '</p></li>';
			} else {
				h += '<li>' + '<a href="/book/'+listColBook[i].id+'">'
						+ listColBook[i].name + '</a>' + '</li>';
			}
		}
		$('#top_div2').html(h);
		function selectSort(sortCode) {
			window.location = '/org/show/sort/' + sortCode + '/0';
		}
		function go(page_index) {
			var url = window.location.pathname;
			if (url.indexOf("selfsort") > 0) {
				url = '/org/show/selfsort//' + page_index;
			} else if (url.indexOf("sort") > 0) {
				url = '/org/show/sort/I24/' + page_index;
			} else if (url.indexOf("letter") > 0) {
				url = '/org/show/letter//' + page_index;
			} else if (url.indexOf("search") > 0) {
				url = '/org/show/1652/search/';
				if ('小说' == '阅览室') {
					url += 'all';
				} else {
					url += $('#searchKey').val();
				}
				url += '/' + page_index;
			}
			window.location = (url);
		}
		$(document)
				.ready(
						function() {
							var totalSize = Number($('#totalSize').val());
							if (totalSize) {
								$("#pagination").css('display', 'block');
								$("#pagination").pagination(
										totalSize,
										{
											items_per_page : 30,
											current_page : Number($(
													'#currentPage').val()),
											prev_text : '上一页',
											next_text : '下一页',
											callback : go
										});
							}
							var totalPage = totalSize % 30;
							if (totalPage == 0) {
								totalPage = (totalSize / 30) - 1;
							} else {
								totalPage = totalSize / 30;
							}
							totalPage = Math.floor(totalPage);

							$(".pagination")
									.prepend(
											"<a href='javascript:void(0)' onclick='go(0);'>首页</a>");
							$(".pagination").append(
									"<a href='javascript:void(0)' onclick='go("
											+ totalPage + ");'>尾页</a>");
						})
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
	<script src="./list_files/h.js" type="text/javascript"></script>

	<div class="_bd_ext_tip _bd_ext_search_mode"
		style="visibility: hidden; left: 373px; top: 514px;">
		<span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span
			class="_bd_ext_copy">复制</span>
	</div>
</body>
</html>