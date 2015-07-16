<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.ws.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ws.Article"%>
<%@ page pageEncoding="UTF-8" %>
<%
	int id = -1;
	
	try {
		id = Integer.parseInt(request.getParameter("id"));
	}
	catch(NumberFormatException e) {
		out.println("NumberFormatException!! ");
		e.printStackTrace();
		return;
	}
	
	Connection conn = DB.getConn();
	Statement stmt = DB.createStatement(conn);
	String sql = "select * from daomu where rootID = " + id + " order by pdate desc";
	ResultSet rs = DB.getResult(stmt, sql);
	
	List<Article> articles = new ArrayList<Article>();
	
	while(rs.next()) {
		Article a = new Article(rs);
	if(a == null) {
 %>
This article not exists!!
<%
	return;
	}
	articles.add(a);
	 }
	
 %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://bbs.51cto.com/thread-1160254-1.html -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>新人的困惑 - Java论坛 -  51CTO技术论坛_中国领先的IT技术社区 </title>
		<meta name="keywords" content="IT论坛">
<meta name="MSSmartTagsPreventParsing" content="True">
<meta http-equiv="MSThemeCompatible" content="Yes">
		<link href="./img2/global.css" rel="stylesheet" type="text/css">
		<link href="./img2/viewthread.css" rel="stylesheet" type="text/css">
		<link href="./img2/map_menu.css" rel="stylesheet" type="text/css">
		<link href="./img2/add.css" rel="stylesheet" type="text/css">
		<link href="./img2/nav.css" rel="stylesheet" type="text/css">

		<link href="./img2/art_master_top.css" rel="stylesheet" type="text/css">
<style type="text/css">
#home_top .top_nav .right .login2 {padding:0;}
</style>

<style type="text/css">
.defaultpost { height: auto !important; height:260px; min-height:337px !important; }
.signatures { height: expression(signature(this)); max-height: 100px; }
</style>




<style type="text/css">
DIV.jing {
    background: url(images/stamp/jing.png) no-repeat !important;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, src="images/stamp/jing.png"); background:none;
	shou
    float: left;
    height: 107px;
    position: absolute;
    width: 107px;
    z-index: 10;
    left:1120px;
    top:246px;
}
.edit_shou ,.jian{
    float: left;
    height: 78px;
    position: absolute;
    left:1100px;
    top:346px;
    width: 133px;
    z-index: 10;
}
.edit_shou{    background: url(images/stamp/shou.png) no-repeat!important;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, src="images/stamp/shou.png"); background:none;
}
.jian {
	background: url(images/stamp/jian.png) no-repeat !important;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true, src="images/stamp/jian.png"); 
	background:none;
}

.postbtn{ height:30px; display:block;}
</style>


<script src="./img2/jquery-1.4.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery.noConflict();
</script>
		
		
		<script type="text/javascript">
			var discuz_uid = 0;var IMGDIR = 'images/default';var attackevasive = '0';var gid = 0;var STYLEID = '9';
			gid = parseInt('317');var fid = parseInt('133');var tid = parseInt('1160254');
		</script>
		<script src="./img2/common.min.js" type="text/javascript"></script>





<style>
.t_l, .t_c, .t_r, .m_l, .m_r, .b_l, .b_c, .b_r {
    background: none repeat scroll 0 0 #000000;
    opacity: 0.2;
    overflow: hidden;
	filter:alpha(opacity=20);
	-moz-opacity:0.2;
	-khtml-opacity: 0.2;
}

.flbc {
    background: url("/images/forum/cls.gif") no-repeat scroll 0 0 transparent;
    float: left;
    height: 20px;
    overflow: hidden;
    text-indent: -9999px;
    width: 20px;
}

.autosave {

	overflow:hidden;
}

body {
	font-size:12px;
}
.fl {
	float:left;
}
.fr {
	float:right;
}
.formbox {
	width:600px; padding:10px; text-align:left;
}
.formbox a {
	color:#333;
	text-decoration:none;
}
.formbox h1 {
	height: 20px;
	line-height: 20px;
	cursor:move;
}
.formbox h1 em {
	font-size: 14px;
	font-weight: 700;
	font-style:normal;
	color: #336699;
	float:left;
}
.formbox h1 span {
	float:right;
}

.flbc:hover {
	background-position: 0 -20px;
}
.re_box {
	line-height:25px;
	padding-bottom:10px;
}
.formbox .quote_box {
	background: url(/images/forum/qa.gif) no-repeat left top;
	color: #666666;
	margin: 10px 0;
	overflow: hidden;
	padding:0 0 10px 16px;
}
.formbox .quote_box blockquote {
	background: url(/images/forum/qz.gif) no-repeat scroll 100% 100% transparent;
	display: inline;
	margin: 0;
	padding-right: 16px;
}
.formbox .blockcode {
	background: none repeat scroll 0 0 #F7F7F7;
	color: #666666;
	margin: 10px 0;
	overflow: hidden;
	padding: 5px 10px;
}
.formbox .blockcode code {
	font-family: Monaco, Consolas, "Lucida Console", "Courier New", serif;
	font-size: 12px;
	line-height: 1.8em;
}
* html .blockcode code {
	font-family: "Courier New", serif;
}

.tedt {
	border-color: #999999 #CCCCCC #CCCCCC #999999;
	border-style: solid;
	border-width: 1px;
	width: 98%;
	margin:0 auto;
}
.tedt .pt {
	background:#FFF;
	border: medium none;
	padding: 0 !important;
	width: 100%;
}
.tedt .bar {
	background:#F2F2F2;
	border-bottom:1px solid #CDCDCD;
	height: 25px;
	line-height: 25px;
	padding: 0 10px 0 0;
	clear:both;
}
.tedt {
	width: 600px;
}
.btns {
	background:#F2F2F2;
	border-top: 1px solid #CCCCCC;
	height: 26px;
	padding: 8px 10px;
	text-align:left;
}
.pn {
	background:  #E5EDF2;
	border-color: #C2D5E3 #336699 #336699 #C2D5E3;
	border-style: solid;
	border-width: 1px;
	color: #336699;
	cursor: pointer;
	font-size: 14px;
	font-weight: 700;
	height: 26px;
	line-height: 26px;
	margin-right: 3px;
	vertical-align: middle;
}
.ie6 .pn {
	line-height: 20px;
}

/**相关帖子的样式 */
.relate_subject{ border:1px solid #94cfdd; background:#eef7fc; padding:9px 10px 10px; width:700px; margin:10px auto; height:auto; overflow:hidden;}
.relate_subject h3{ font-size:13px; color:#333; font-weight:bold; height:25px; line-height:25px; text-align:left;}
.rel_bor{border-right:1px dashed #b5bcc0;}
.relate_subject ul{ height:auto; overflow:hidden;}
.relate_subject ul li{ font-size:12px; padding:0 20px; width:300px; background:url(/images/forum/idot.jpg) no-repeat 5px center; line-height:22px; height:22px; overflow:hidden;}
.relate_subject ul li a{ color:#000; line-height:22px; }

/*文字广告*/
.top-ad-bar{text-align:center;margin:0px auto 2px auto;clear:both;background:url(http://home.51cto.com/public/images/notice/sogou_se_tgbar_bg_final1.gif) repeat-x;width:950px;color:#000;font-size:13px;height:36px;z-index:21474836471;}
.top-ad-bar-txt{ float:left;cursor:pointer;width:920px;text-align:center;height:32px; line-height:32px;txt-align:center;border-left:solid #efbf00 1px;}
.top-ad-bar-txt a:link,.top-ad-bar-txt a:visited{color:#000;}
.top-ad-bar-txt a:hover{ color:#cc0000;}
.top-ad-bar-close{float:right;width:15px;cursor:pointer;height:28px;padding:4px 5px; border-right:solid #efbf00 1px;}


.Postban a{ color:#1470a1;}
.Postban {
    color: #000000;
    line-height: 164px;
    text-align: center;
}
.hftxtarea, .Postban {
    background: none repeat scroll 0 0 #FFFFFF;
    border: 1px solid #DDDDDD;
    height: 164px;
    width: 499px;
}

/*end jacena*/


.ipadFload{ position:fixed; width:136px; height:194px; background:url(http://bbs.51cto.com/images/IPad-bg.png) left top no-repeat #fff; font-family:"微软雅黑"; padding-left:18px;}
.ipadClose{ text-align:right; font-size:14px; line-height:20px;}
.ipadImg{ padding-top:38px;}
.ipadImg img{ width:105px; height:105px;}
.iPadair2{ font-size:12px;}
.iPadair2 a{ color:#659b01; text-decoration:none; background:url(http://bbs.51cto.com/images/51CTO-IPAD-BOTTOM.png) right center no-repeat; display:block; line-height:30px;}

</style>


<div class="clear"></div>
	
		

            
<div class="subnav_t">
    <p class="flod_btn" id="showTag"></p>
</div>
<div class="clear hr10"></div>
		
		
		

		
<%--***帖子********************************************************************************************* --%>
								<%for(Iterator<Article> it=articles.iterator();it.hasNext();) {
									Article a = it.next();
								
								 %>		
		<div class="tz_main">
		
		
			<form method="post" name="modactions">
		<input type="hidden" name="formhash" value="748e852b">						<table id="pid5926000" summary="pid5926000" width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody><tr>
					
					<td class="postauthor bd4b" valign="top">
	
	
												<div class="popupmenu_popup userinfopanel" id="userinfo5926000_menu" style="display: none;">
							<dl>
							<dt>积分</dt><dd>7&nbsp;</dd>
															<dd>当前离线
														</dd>
													<dt>注册时间</dt><dd>2015-5-17&nbsp;</dd>
							<dt>最后登录</dt><dd>2015-6-27&nbsp;</dd>
							</dl>
														<p><a href="http://bbs.51cto.com/space-uid-10238909.html" target="_blank">论坛详细资料</a></p>
																				</div>
							
						<!--标签信息-->
	
	
												<div class="author01 bd4b"> 查看:<span>25</span><em>|</em>回复：<span>0</span></div>
												<cite>
							<a href="http://home.51cto.com/index.php?s=/space/10238909" target="_blank" id="userinfo5926000" class="dropmenu" onmouseover="showMenu(this.id)">lq080531</a>&nbsp;<img src="./img2/arrow.gif" class="ml5" align="absmiddle">
						</cite>
													<div class="avatar"><img src="./img2/avatar.php"></div>												<p class="post_zw">新新人类 <img src="./img2/star_level1.gif" alt="Rank: 1"></p>
						
						<dl class="profile">
						<!-- edit at 20120601 by jacena-->
						<dt>帖子</dt><dd><a href="http://home.51cto.com/apps/bbs/index.php?s=/Index/index/uid/10238909" style="color:#336699;text-decoration: underline;" target="_blank">2</a>&nbsp;</dd>
						<dt>精华</dt><dd><a href="http://bbs.51cto.com/digest.php?authorid=10238909" target="_blank" style="color:#336699;text-decoration: underline;">0</a>&nbsp;</dd>
						<dt>无忧币</dt><dd style="color:#666666"><a style="color:#336699;text-decoration: underline;" href="http://home.51cto.com/index.php?s=/Account/credit" target="_blank" rel="17">17 </a></dd>
						</dl>						<!-- end edit -->
						<p imedal="10238909" class="medalsbox"></p>
						<!--勋章结构需要调整-->
					
					
					<ul>
													<li class="space"><a href="http://pay.51cto.com/space.php?uid=10238909" target="_blank">个人空间</a></li>
												<li class="pm"><a href="http://home.51cto.com/index.php?s=/Notify/write/uid/10238909" target="_blank">发短消息</a></li>
						<li class="buddy"><a href="http://home.51cto.com/index.php?s=/space/10238909" target="_blank" id="ajax_buddy_0">家园好友</a></li>

						<li class="blog">
							<a target="_blank" href="http://blog.51cto.com/blog.php?uid=10238909">他的博客</a>
						</li>
						<li class="online"><a target="_blank" href="http://down.51cto.com/10238909">他的资源</a></li>
						<li style="background:url(http://home.51cto.com/thumb.php?w=15&amp;h=15&amp;t=f&amp;url=http://home.51cto.com/data/uploads/20130625/15/51c94d8136342.gif) no-repeat left center;width:100px"><a target="_blank" href="http://edu.51cto.com/user/user_id-10238909.html?edu_recommend_adid=103">他的课程中心</a></li>
					</ul>
					</td>
					<td align="center" valign="top" class="tz_right bd4">
												<div class="postinfo01 bd4">
		
<!-- 帖子主题 -->						<h2 style="float: left;font-size:16px;vertical-align:middle">&nbsp;&nbsp;<strong><a title="<%= a.getCont() %>" href="./img2/detail.htm"><%= a.getCont() %></a></strong>&nbsp;&nbsp;<a style="text-decoration: none;font-size:12px;color:grey" href="javascript:setcopy('http://bbs.51cto.com/thread-1160254-1.html','复制帖子链接到剪贴板');">[复制链接]</a></h2>
			
		
							<p class="fr">
							<!-- 	<a class="sc_ico" onmouseover="this.className='sc_ico02'"   onmouseout="this.className='sc_ico'" href="javascript:favorBox('open');" title="一键收藏，随时查看，分享好友！">收藏</a> -->
							
							
								
						
						</p></div>
												
												
						<div class="clear"></div>
						<div class="postinfo02">
							<p class="postinfo02a">发表于&nbsp;2015-6-27 14:20&nbsp;<span>|</span>&nbsp;来自&nbsp;
														<a href="http://bbs.51cto.com/" target="_blank" title="">51CTO网页</a>
														</p>
							<p class="postinfo02b">
																						<a href="http://bbs.51cto.com/viewthread.php?tid=1160254&page=1&authorid=10238909" rel="nofollow">[只看他]</a>
							楼主							</strong>
							</p>
						</div>
						<p class="postinfo03">
						
																				
						</p>
						<span id="postnum5926000"></span>
						<div class="postmessage defaultpost">
							
							<div id="ad_thread3_0"></div><div id="ad_thread4_0"></div>
<!-- 回复帖子 -->					<%= a.getCont() %>
							</div>

								
								

								
																	<script src="./img2/tag.php" type="text/javascript"></script>
	

								
																	<div id="post_rate_div_5926000"></div>
								<br><br><br>

						  <!-- add by jacena ujian-->


<!--add by jacena 相关帖子  --><!-- end jacena --></div></td>
					<td>

					
					
					</td>
				</tr>
			</tbody></table>
			</form> <!--提交-->
		</div>
		
		<% } %>
<%--************************************************************************************************ --%>
	
		<div class="hr10"></div>
		<div class="w960"></div>
		<div class="clear hr10"></div>

		<div class="hfbox" style="position:relative">
			<script src="./img2/post.js" type="text/javascript"></script>
			<script type="text/javascript">
			var postminchars = parseInt('10');
			var postmaxchars = parseInt('85000');
			var disablepostctrl = parseInt('0');
			var charset = 'utf-8';
			function validate(theform) {
				//判断@的个数，不能超过15个
				var wtext = theform.message.value;
				var wnum = wtext.length;
				var atnum = 0;
				for(var i=wnum-1;i>=0;i--){
					if(wtext[i] == '@'){
						atnum++;
					}
				}
				if(atnum > 15){
					alert("您好，一个帖子最多能@15个人，请编辑后再发表！");
					theform.message.focus();
					return false;
				}
				if(theform.message.value == '') {
					alert("请完成内容栏。");
					theform.message.focus();
					return false;
				} else if(mb_strlen(theform.subject.value) > 240) {
					alert("您的标题超过 240 个字符(80 个汉字)的限制。");
					theform.subject.focus();
					return false;
				}
				if(!disablepostctrl && ((postminchars != 0 && mb_strlen(theform.message.value) < postminchars) || (postmaxchars != 0 && mb_strlen(theform.message.value) > postmaxchars))) {
					alert("您的帖子长度不符合要求。\n\n当前长度: "+mb_strlen(theform.message.value)+" 字节\n系统限制: "+postminchars+" 到 "+postmaxchars+" 字节");
					return false;
				}
				if(!fetchCheckbox('parseurloff')) {
					theform.message.value = parseurl(theform.message.value, 'bbcode');
				}
				theform.replysubmit.disabled = true;
				return true;
			}
			</script>
			<form method="post" id="postform" action="http://bbs.51cto.com/post.php?action=reply&fid=133&tid=1160254&extra=&replysubmit=yes" onsubmit="return validate(this)">
				<input type="hidden" name="formhash" value="748e852b">
				<div id="quickpost">
					<span class="headactions" style="display:none;" china="删除"><a href="http://bbs.51cto.com/member.php?action=credits&view=forum_reply&fid=133" target="_blank">查看积分策略说明</a></span>
					<div class="postoptions" style="display:none;">
						<h5>选项</h5>
						<p><label><input class="checkbox" type="checkbox" name="parseurloff" id="parseurloff" value="1"> 禁用 URL 识别</label></p>
						<p><label><input class="checkbox" type="checkbox" name="smileyoff" id="smileyoff" value="1"> 禁用 <a href="http://bbs.51cto.com/faq.php?action=message&id=32" target="_blank">表情</a></label></p>
						<p><label><input class="checkbox" type="checkbox" name="bbcodeoff" id="bbcodeoff" value="1"> 禁用 <a href="http://bbs.51cto.com/faq.php?action=message&id=18" target="_blank">Discuz!代码</a></label></p>
												<p><label><input class="checkbox" type="checkbox" name="usesig" value="1"> 使用个人签名</label></p>
						<p><label><input class="checkbox" type="checkbox" name="emailnotify" value="1"> 接收新回复邮件通知</label></p>
											</div>
					<div style="display:none;">
						<h5><label>标题
						<input type="text" name="subject" value="" tabindex="1"></label></h5>
					</div>
			<a name="hf">
				</a><table width="700" border="0" cellspacing="0" cellpadding="0" align="left">
				<tbody><tr>
				<td width="200" rowspan="3" align="center" valign="top">
					<div id="smilieslist"></div>
				</td>
				<th width="500" height="32" align="left" valign="middle">快速回复主题</th>
				</tr>
				<tr>
				<td height="150" align="left" valign="middle"><label>

					 <div class="Postban"><a href="reply.jsp?id=<%=articles.get(0).getId()%>&rootID=<%=articles.get(0).getRootID() %>">立即回复</a></div>

				</label></td>
				</tr>
				<tr>
				<td height="58" align="left" valign="middle"><label>
					
				</label></td>
				</tr>
			</tbody></table><a name="hf">
				</a></div><a name="hf">
					</a></form></div><a name="hf">
		<div class="clear"></div>
<!-- taobaoke --><!-- taobaoke -->
		<script src="./img2/medal.service_new.php" type="text/javascript"></script>
<script type="text/javascript">

	function FindUid(uid)
	{
		for(var index in mjson)
		if(mjson[index].uid==uid)
		{
			return mjson[index].ucon;
		}
	}

	//var jq = jQuery.noConflict();
	
	jQuery(function(){
		
		jQuery("p[imedal]").each(function(){
			jQuery(this).html(FindUid(jQuery(this).attr("imedal")));
		});
	});	

</script>
<style>

#smiliesdiv table td {
    line-height: 30px;
    width: 30px;
}

.medalsbox{ line-height:0; font-size:0;}

.signatures {
    background: url("../../images/default/sigline.gif") no-repeat scroll 0 0 transparent;
    color: #666666;
    line-height: 1.6em;
    margin: 10px;
    overflow: hidden;
    padding-top: 20px;
	text-align:left;
}
.signatures * {
    line-height: normal;
}
.signatures strong {
    font-weight: bold;
}

.signatures { height: expression(signature(this)); max-height: 100px; }

#smiliesdiv {
	margin-top:64px;

}




//



.t_l, .t_r, .b_l, .b_r {
    height: 8px;
    width: 8px;
}
.t_c, .b_c {
    height: 8px;
}
.m_l, .m_r {
    width: 8px;
}
.t_l {
    border-radius: 8px 0 0 0;
}
.t_r {
    border-radius: 0 8px 0 0;
}
.b_l {
    border-radius: 0 0 0 8px;
}
.b_r {
    border-radius: 0 0 8px 0;
}
.m_c {
    background: none repeat scroll 0 0 #FFFFFF;
}
.m_c .tb {
    margin: 0 0 10px;
    padding: 0 10px;
}
.m_c .c {
    padding: 0 10px 10px;
}
.m_c .o {
    background: none repeat scroll 0 0 #F2F2F2;
    border-top: 1px solid #CCCCCC;
    height: 26px;
    padding: 8px 10px;
    text-align: right;
}
.m_c .el {
    width: 420px;
}
.m_c .el li {
    border: medium none;
    padding: 0;
}

</style>	
		
<!-- 2013060606 -->



		
		
		</a><div class="foot"><br>
Copyright©2005-2014</div>


	<script src="./img2/forum.inc.php" type="text/javascript"></script>
			<script src="./img2/count.js"></script><script src="./img2/count.php"></script>
</body></html>