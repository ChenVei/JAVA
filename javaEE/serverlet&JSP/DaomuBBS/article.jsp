<%@page import="java.util.Iterator"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.ws.DB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ws.Article"%>
<%@page pageEncoding="UTF-8" %>

<%!
	public void tree(Connection conn, List<Article> articles, int pid, int grade) {
		Statement stmt = DB.createStatement(conn);
		String sql = "select * from daomu where pid = " + pid;
		ResultSet rs = DB.getResult(stmt, sql);
		try{
			while(rs.next()) {
				Article a = new Article(rs);
				a.setGrade(grade);
				articles.add(a);
				if(!a.isLeaf()) 
					tree(conn, articles, a.getId(), grade+1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs, stmt);
		}
	}
 %>
<%
	boolean login;
	String str = (String)session.getAttribute("adminLogined");     //注意是session.
	login = (str != null && str.trim().equals("true"))?true:false;
	List<Article> articles = new ArrayList<Article>();
	Connection conn = DB.getConn();
	tree(conn, articles, 0, 0);	
	conn.close();
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><script async="" src="http://www.google-analytics.com/analytics.js"></script><script src="./img1/id.php" charset="utf-8"></script>

<title>Java论坛 -  51CTO技术论坛_中国领先的IT技术社区 </title>
<meta name="keywords" content="Java开发,Java视频教程,Java软件下载,Java编程,Java框架IT论坛">
<meta name="description" content="国内领先的Java开发技术社区,欢迎在这里讨论Java框架、Java组件、Java变量、2ee线程、Java GUI、遍历、Java递归、ajax、Swing、J2ME、JMF等技术。 51CTO技术论坛_中国领先的IT技术社区 ">
<link rel="archives" title="51CTO技术论坛_中国领先的IT技术社区" href="http://bbs.51cto.com/archiver/">
<link href="./img1/global.css" rel="stylesheet" type="text/css">
<link href="./img1/map_menu.css" rel="stylesheet" type="text/css">
<link href="./img1/style.css" rel="stylesheet" type="text/css">
<link href="./img1/sidebar.css" rel="stylesheet" type="text/css">
<script src="./img1/guanggao.php" type="text/javascript"></script>
<script type="text/javascript" charset="gb2312" src="./img1/adx.js"></script>
		<script type="text/javascript">
		function AD_random(){return new String(Math.random()).substring(2,11);}
		if (!document.phpAds_used) document.phpAds_used = ',';
		</script>
<link href="./img1/art_master_top.css" rel="stylesheet" type="text/css">
<style type="text/css">
#home_top .top_nav .right .login2 {padding:0;}


.vbox {
background:#ebf3f8;
margin-bottom:10px;
}
.vlist {
	width:218px;
	padding:10px 0 10px 14px;
	float:left;
}
.vlist img {
	float:left;
	margin-right:10px;
}
.vlist dl {
	text-align:left;
	width:122px;
	float:left;
}
.vlist dl dt {
	height:38px;
	overflow:hidden;
	padding-top:5px;
}
.vlist dl dt, .vlist dl dt a {
	color:#262626;
}
.vlist dl dd, .vlist dl dd a {
	color:#777;
}
.vbox_tit {
	font-size:14px;
	
	color:#666;
	margin-top:10px;
	border-bottom:1px solid #b3d0e6;
	text-align:left;
}
.video-icon{
    position: relative;
}
.video-icon a.i_video {
    background: url("http://www.51cto.com/images/homepage/Images/eduplay.png") repeat scroll 0 0 rgba(0, 0, 0, 0);
    display: block;
    height: 25px;
    left:46px;
    position: absolute;
    top:29px;
    width: 25px;
    z-index: 10;
}
</style>
<script src="./img1/jquery-1.4.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	jQuery.noConflict();
</script>
<script src="./img1/common.min.js" type="text/javascript"></script>
<script src="./img1/common.js" type="text/javascript"></script>
<style>@-moz-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-webkit-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-o-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}embed,object{animation-duration:.001s;-ms-animation-duration:.001s;-moz-animation-duration:.001s;-webkit-animation-duration:.001s;-o-animation-duration:.001s;animation-name:nodeInserted;-ms-animation-name:nodeInserted;-moz-animation-name:nodeInserted;-webkit-animation-name:nodeInserted;-o-animation-name:nodeInserted;}</style></head>
<div id="append_parent"></div><div id="ajaxwaitid"></div>



<div class="clear"></div>
<div class="top"></div>
<div class="first"> <a class="logo"><img src="./img1/logo.jpg"></a>
 </div>
<link href="./img1/nav.css" rel="stylesheet" type="text/css"><link href="./img1/bbspass.css" rel="stylesheet" type="text/css">


<script>
    jQuery(function() {
        jQuery.ajax({
            type:'post',
            url:'/plugins/index/service.sy.php',
            success: function(msg){
                if(msg == 1 || msg == 2 || msg == 3) {
                    jQuery('#bbs_bz_display').css('display','block');
                } else {
                    jQuery('#bbs_bz_display').css('display','none');
                }
            }
        })
        jQuery('#showTag').bind('click',function() {
            var dis = jQuery('#bbsTag').css('display');
            var jTop = jQuery('.jing').css('top');
            var jian = jQuery('.jian').css('top');
            var edit_shou = jQuery('.edit_shou').css('top');

            if(dis == 'block') {
                jQuery('#bbsTag').slideUp('slow');
                jQuery('#showTag').removeClass('un_flod_btn');
                jQuery('#showTag').addClass('flod_btn');
            } else {
                jQuery('#bbsTag').slideDown('slow');
                jQuery('#showTag').removeClass('flod_btn');
                jQuery('#showTag').addClass('un_flod_btn');
            }
            if(jTop || jian || edit_shou) {
                jTop = parseInt(jTop);
                jian = parseInt(jian);
                edit_shou = parseInt(edit_shou);
                if(jTop == 246) {
                    jQuery('.jing').css('top',416);
                } else {
                    jQuery('.jing').css('top',246);
                }
                if(jian == 346) {
                    jQuery('.jian').css('top',516);
                } else {
                    jQuery('.jian').css('top',346);
                }
                if(edit_shou == 346) {
                    jQuery('.edit_shou').css('top',516);
                } else {
                    jQuery('.edit_shou').css('top',346);
                }
            }
        });
    })
</script>
<script type="text/javascript">
function Check() {
    if (jQuery("#srchtxt").val() == '' || jQuery("#srchtxt").val() =='搜索话题、问题...') {
        alert('请输入需要搜索的关键词!');
        return false;
    }	
	jQuery("#search").submit();
}

jQuery(function(){

	jQuery('#show_table tr').each(function(){
		var tr = this;		
		jQuery(this).hover(function(){
			jQuery(tr).addClass('trhover');
		
		}, function(){
			jQuery(tr).removeClass('trhover');
		});
	
	});
	
	var show_name = '搜索话题、问题...';
	
	jQuery("#srchtxt").one('click', function(){
		jQuery(this).val('').css({color:'#000'});
	});
		
	jQuery('#srchtxt').bind('blur', function(){	
		if ('' == jQuery(this).val()) {
			jQuery(this).val(show_name).css({color:'#ccc'});
		}
	}).bind('focus', function(){
		jQuery(this).val('').css({color:'#000'});		
	});
	
	jQuery('.thread_types ul li').last().css({'background':'none', 'margin-right':0});
});
</script>
<a href="post.jsp">POST A NEW THEME</a>
<div class="position">
	<div id="page">
	  <div class="chl-poster simple" id="header">
	    <div id="site-nav"></div>
		</div>
	</div>
</div>
<div id="ad_plate"></div>
<div class="clear"></div>
<div class="t_main" style="position:relative;">
  <div class="t_main01">
    <div class="t_header">
		<p class="t_author">作者</p>
			<p class="t_reply">回复/查看</p>
			<p class="t_lastPost">最后发表</p>
		</div>
	</div>
	<form method="post" name="moderate" action="http://bbs.51cto.com/topicadmin.php?action=moderate&fid=133">
	<input type="hidden" name="formhash" value="748e852b">
	<div class="trbg" china="主贴列表">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" id="mytable">

			<tbody>			<tr>
			<td colspan="7" align="center" valign="middle" id="fjx" class="fjx">
							
			
			</td>
			</tr>		
<!-- ***********************帖子区******************************************************************************** -->				
						<%
							for(Iterator<Article> it = articles.iterator(); it.hasNext();) {
								Article a = it.next();
								String pre = "";
								for(int i = 0;i < a.getGrade(); i++) 
									pre += "******";
						 %>
						
						<tr class="t_item trhoverbg"> 
							<td width="70" align="center" valign="middle">
				<% if(login) {%>
<%--更改帖子： --%>	 <a href="modify.jsp?id=<%=a.getId()%>">Update</a>
<%--删除帖子： --%>	 <a href="delete.jsp?id=<%=a.getId()%>&isLeaf=<%=a.isLeaf()%>&pid=<%=a.getPid()%>">Del</a>
				<% } %>			
							</td>
                            
            
                            
							<td width="32" colspan="2" align="left" valign="middle" class="common">				
													
								<span id="thread_1159922">
			<%--帖子内容： --%>												<a href="articleDetail.jsp?id=<%=a.getId() %>" target="_blank" title="<%= a.getCont()%>"><%= pre + a.getCont()%></a>
								
								</span>
	
													
													
												</td>
							
											
							<td width="120" align="left" valign="middle" class="by">
														<a href="http://bbs.51cto.com/space-uid-10449085.html">BurningWS</a>
													<br>2015-6-24				
							</td>
							<td width="70" align="left" valign="middle" class="td03">
								<a href="http://bbs.51cto.com/thread-1159922-1.html" target="_blank">363</a>
								<br />6828				</td>
							<td width="130" align="left" valign="middle" class="by">
													<a href="http://bbs.51cto.com/space-username-51studyit.html">BurningWS</a>
			<%--日期： --%>							<br /><%= a.getPdate() %>				</td>
						</tr>
						
						<%
						} 
						%>			
<!-- ******************************************************************************************************* -->			

 
			</tbody></table>
	</div>
	<div class="clear"></div>
		</form>
</div>
<div class="pagebox">
 <ul>
 <li><a class="abg">1</a></li><li><a href="http://bbs.51cto.com/forum-133-2.html">2</a></li><li><a href="http://bbs.51cto.com/forum-133-2.html" class="next">下一页</a></li>  </ul>
</div>
<div class="clear hr10"></div>
<div class="foot">
<br>
  Copyright©2005-2014 <a target="_blank" href="http://www.51cto.com/">51CTO.COM</a> <br>
</body></html>