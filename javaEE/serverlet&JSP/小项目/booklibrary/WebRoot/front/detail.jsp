<%@page import="cn.domain.Category"%>
<%@page import="cn.service.impl.BusinessServiceImpl"%>
<%@page import="cn.domain.Book"%>
<%@page import="cn.dao.impl.BookDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String id = request.getParameter("id");
BookDaoImpl bdi = new BookDaoImpl();
Book b = bdi.find(Integer.parseInt(id));
request.setAttribute("b", b);

BusinessServiceImpl bs = new BusinessServiceImpl();
List<Category> categories = bs.getAllCategories();
request.setAttribute("categories", categories);
request.setAttribute("c", categories);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://hbdx.chineseall.cn/book/10060034047 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${b.name }</title>
	<meta name="keywords" content="art,web">
		<meta name="description" content="artWelcome">

			<meta name="author" content="artwc@foxmail.com">
				<link rel="icon" href="http://hbdx.chineseall.cn/book/favicon.ico">
					<link rel="Shortcut Icon"
						href="http://hbdx.chineseall.cn/book/favicon.ico">
						<link rel="Bookmark"
							href="http://hbdx.chineseall.cn/book/favicon.ico">
							<link type="text/css" rel="stylesheet"
								href="front/detail_files/pagination.css">
								<link href="front/detail_files/book.css" rel="stylesheet"
									type="text/css">
									<link href="front/detail_files/util.css" rel="stylesheet"
										type="text/css">
										<link href="front/detail_files/layout.css" rel="stylesheet"
											type="text/css">
											<script type="text/javascript"
												src="front/detail_files/jquery.min.js"></script>
											<script type="text/javascript"
												src="front/detail_files/jquery.pagination.js"></script>
											<style type="text/css">
form.contboxUppop {
	width: 360px;
}

form.contboxUppop .left {
	height: 130px;
	width: 240px;
}

form.contboxUppop .right {
	height: 130px;
	width: 110px;
}

form.contboxUppop .right input {
	
}

form.contboxUppop .left .tit {
	color: black;
	font-size: 14px;
	font-weight: bold;
	padding-bottom: 10px;
}

form.contboxUppop .left .img {
	margin: 0 10px 0 0;
}

form.contboxUppop .left .img img {
	height: 113px;
	width: 80px;
}

form.contboxUppop .input textarea {
	font-size: 12px;
	height: 36px;
	margin-right: 10px;
	vertical-align: middle;
	width: 240px;
}

.POPinfo img {
	float: left;
	margin-right: 30px;
}

.POPinfo .cont {
	margin-bottom: 30px;
}

.POPinfo .title {
	padding-top: 30px;
	font-size: 14px;
	color: orange;
	margin-bottom: 10px;
}

.POPbutton {
	width: 80px;
	height: 26px;
	background: #fcd1a4 url(butok.jpg) no-repeat;
	line-height: 24px;
	border: 0;
}

.myTags {
	height: 3em;
}

.myTags span {
	margin: 2px;
	background: #ffc;
	font-size: 12px;
	padding: 2px;
	border-width: 0 1px 1px 0;
	border-style: solid;
	border-color: #999;
	cursor: pointer;
	color: #000;
}

.page {
	clear: none;
}
</style>
											<script type="text/javascript"
												src="front/detail_files/book.js"></script>
											<script type="text/javascript"
												src="front/detail_files/util.js"></script>
											<link
												href="http://hbdx.chineseall.cn/orgcommon/common/layout.css"
												rel="stylesheet">
												</style>
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
	<link href="front/detail_files/util.css" rel="stylesheet"
		type="text/css">
		<script type="text/javascript" src="front/detail_files/head.js"
			defer=""></script>
		<script type="text/javascript" src="front/detail_files/util.js"></script>

		<div class="header">

			<div class="header-bg1">
				<div class="headTop" style="overflow:visible;">
					<div class="headMenu" style="float:left;"></div>

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
						<li class="aIndex"><a href="front/main.jsp">首页</a></li>
						<li><A>全部图书：</A></li>

						<c:forEach var="c" items="${categories }">
							<li><a href="front/list.jsp?cid=${c.id }" target="_blank">${c.name }
							</a></li>
						</c:forEach>
						<!-- **************************************************** -->
					</ul>



				</div>
				<script type="text/javascript">
					$("#channels").children().last().attr('class', 'nob');
				</script>
				<div class="headBottom">

					<dl style="width: 590px;"></dl>

				</div>
			</div>
		</div>


		<form id="sf"
			action="http://hbdx.chineseall.cn/search/searchBook.jsps"
			method="get" target="_blank" style="display: none;">
			<input type="hidden" id="bookId" value="10060034047"> <input
				type="hidden" id="bookName" value="detail"> <input
					type="hidden" name="field"> <input type="hidden" name="key">
		</form>
		<div class="blank10"></div>
		<div class="area">
			<div class="dgBook">
				<div class="dgBook_fm">
					<div class="dgBook_fm_img" id="dgBook_fm_img">
						<a> <img src="img/bookcover/${b.id }.jpg" alt="${b.name }"></a>
					</div>
					<ul>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<br />
						<br />
						<br />
						<li>作者：${b.name }</li>
						<br />
						<br />
						<li></li>
						<li></li>
						<li>出版社：新世界出版社</li>
						<br />
						<br />
						<li>出版日期：${b.pdate }</li>
					</ul>
					<div class="dgBook_fm_dl">
						<h1>detail</h1>
						<ul>
							<li></li>
							<li style="display:none">副本：<label id="lastBorrowCount">5</label>个
								<span class="u"> <a id="borrow"
									href="http://hbdx.chineseall.cn/book/borrowBook.jsps?bookId=10060034047"
									target="_blank">借阅</a>
							</span>
							</li>
							<li><br></li>

						</ul>
						<input type="hidden" id="stars" value="3"> <input
							type="hidden" id="stars5" value="2"> <input type="hidden"
								id="stars4" value="1"> <input type="hidden" id="stars3"
									value="0"> <input type="hidden" id="stars2" value="0">
											<input type="hidden" id="stars1" value="0"> <input
												type="hidden" id="avgRating" value="4.7">
					</div>
					<div class="blank20"></div>
					<input id="myScore" type="hidden" value="0">
				</div>
				<div class="tit">
					<h2>内容简介</h2>
				</div>
				<div class="dgBook_txt">${b.description }</div>


				<div class="tit">
					<h2>&nbsp;</h2>
				</div>
				<div class="tit">
					<h2>书评</h2>
				</div>
				<div class="dgBook_sp">
					<div class="dgBook_sp_tit">
						<ul id="commentTab">
							<li id="all" class="hot">所有书评</li>
							<li id="mySelf" class="">我的书评</li>
							<li id="friend" class="">书友的书评</li>
						</ul>
						<span class="sp_t"><div id="commentsCountA"></div></span> <input
							id="bookCommentOrder" type="hidden" value=""> <input
							id="bookCommentScope" type="hidden" value="all">
					</div>
					<div class="dgBook_sp_con" id="bookCommentsDiv">
						<dd>还没有人对此书进行评论……</dd>
					</div>
					<div class="PageGoTo" id="bookCommentsPager">
						<div id="pagination" style="clear:both;padding-top:10px"></div>
					</div>
					<div class="dgBook_sp_bottom">
						<form id="form_comment" name="formname" method="post"
							action="http://hbdx.chineseall.cn/book/10060034047#">
							<div class="dgBook_sp_bottom_t">
								<span>必填，最多可输入1000字。发言请遵守相关法律法规。</span> 发表评论
							</div>
							<div class="dgBook_sp_bottom_c">
								<textarea name="bookComment.content" id="comment_content"
									cols="" rows=""
									onmouseover="if(this.value==this.defaultValue)this.value='';"
									onmouseout="if(this.value=='')this.value=this.defaultValue">我来说两句...</textarea>
							</div>
							<div class="dgBook_sp_bottom_b" style="padding: ">
								<input name="" type="reset" class="btn2" value="取 消"> <input
									id="createBookCommentButton" name="" type="button" class="btn1"
									value="提 交">
							</div>
						</form>
					</div>
				</div>



			</div>
		</div>
		<div class="blank10"></div>
		<script type="text/javascript" src="front/detail_files/book(1).js"></script>
		<script type="text/javascript"
			src="front/detail_files/recommendBook.js"></script>
		<script type="text/javascript" src="front/detail_files/tab.js"></script>
		<script type="text/javascript">
			$(document).ready(init)
			function collection(bookId) {
				collectionBook(bookId, function(data) {
					if (data.success) {
						messageBox('收藏成功', 'success');
						$("#collectionBook").html('已收藏');
						$("#collectionCount").html(bookCollectionCount + 1);
						//$("#hCollectionCount").val(bookCollectionCount + 1);
					} else {
						messageBox(data.msg, 'failure');
					}
				})
			}
			function search(f, v) {
				$('input[name="field"]').val(f);
				$('input[name="key"]').val(v);
				$('#sf').submit();
				;
			}
			function settingTags(bookName, bookId, userId) {
				if (getCookieValue('chineseall.login')) {
					editBookTag($('#bookName').val(), $('#bookId').val(), null,
							function(data) {
								if (data && data.success) {
									var tags = data.data;
									if (tags && tags.length > 0) {
										var h = '<span>' + tags[0].tag
												+ '</span>';
										for (var i = 1; i < tags.length; i++) {
											h += '&nbsp;<span>' + tags[i].tag
													+ '</span>';
										}
										$('#userTags').html(h);
										$('#updateTag').html('修改');
									} else {
										$('#userTags').html('您还没有设置标签');
										$('#updateTag').html('添加标签');
									}
								} else {
									messageBox(data ? data.msg : '设置失败',
											'failure', execFunc)
								}
							});
				} else {
					loginBox();
				}
			}

			function orderBookComments() {
				if ($('#commentOrderA').html() == '按好评数排序') {
					$('#commentOrderA').html('按评论时间排序');
					$('#bookCommentOrder').val('usefulCount')
				} else {
					$('#commentOrderA').html('按好评数排序');
					$('#bookCommentOrder').val('submitTime')
				}
				toPage(0);
			}
			function selectCommentTab(scope) {
				if (!scope) {
					scope = 'all';
				}
				if (scope != 'all' && !getCookieValue('chineseall.login')) {
					loginBox();
					return;
				}
				$('#bookCommentScope').val(scope);
				$('#commentTab li.hot').attr('class', '');
				$('#' + scope).attr('class', 'hot');
				toPage(0);
			}

			setTimeout(function() {
				selectCommentTab(false)
			}, 2000);
		</script>
		<script type="text/javascript" src="front/detail_files/raty.js"></script>




		<!--#include file="/public/footer.html"-->

		<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
					: " http://");
			document
					.write(unescape("%3Cscript src='"
							+ _bdhmProtocol
							+ "hm.baidu.com/h.js%3F961aa2cba564c3f71bfbb0a4cf919ac9' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script src="front/detail_files/h.js" type="text/javascript"></script>


		<div id="recommendbg"
			style="display: none; position: absolute; z-index: 10; left: 0px; top: 0px; opacity: 0.6; height: 1585px; width: 100%; background: gray;"></div>
		<div class="_bd_ext_tip" style="visibility: hidden;">
			<span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span
				class="_bd_ext_copy">复制</span>
		</div>
</body>
</html>