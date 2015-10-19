<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/front/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0026)http://news.people.com.cn/ -->
<title>滚动新闻</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="./listnews/2011newscenter.css" type="text/css" media="all">
<!--[if IE 6]>
<link href="ie6_style.css" type="text/css" rel="stylesheet" rev="stylesheet" media="all" />
<![endif]-->
<script src="./listnews/swfobject.js" language="javascript"></script>
<script type="text/javascript" src="./listnews/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="./listnews/jquery.pagination.js"></script>
<script src="./listnews/2010rmw.tab.js" type="text/javascript"></script>
<script language="JavaScript">
function gotxt() {

        var today = new Date();
        var bday = new Date(2009,04, 27);

        tf=document.dateform;
        vd=tf.sday.options[tf.sday.selectedIndex].value;
        vm=tf.smonth.options[tf.smonth.selectedIndex].value;
vy=tf.syear.options[tf.syear.selectedIndex].value;
        var aday = new Date(vy ,vm-1, vd);
		if((vy>2009)){ window.open("http://www.people.com.cn/GB/24hour/index"+vy+"_"+vm+"_"+vd+".html")}
 else if ((vd<29)&&(vm<09)&&(vy=2009))
 { window.alert("回顾请从2006年09月29日开始");}
 else    {
        document.location="http://www.people.com.cn/GB/24hour/index"+vy+"_"+vm+"_"+vd+".html";}
}
function resetselect () {
	var mydate = new Date();
    var myyear = mydate.getFullYear();
    var mymonth = mydate.getMonth()+1;
	var mytoday = mydate.getDate()-1;
	if(new String(mymonth).length==1)mymonth="0"+new String(mymonth);
	if(new String(mytoday).length==1)mytoday="0"+new String(mytoday);
	document.dateform.syear.value=myyear;
    document.dateform.smonth.value=mymonth;
    document.dateform.sday.value=mytoday;
}
</script>
<script type="text/javascript">
	var allNews=new Array();
    var members=new Array();
    var pageSize = 40;

	function pageselectCallback(page_index, jq){
		var items_per_page =pageSize;
		var max_elem = Math.min((page_index+1) * items_per_page, members.length);
		var newcontent = '<ul class="clearfix">';
		var line=1;
		for(var i=page_index*items_per_page;i<max_elem;i++)
		{
		    newcontent += '<li><a href="'+members[i].url+'" target="_blank">'+members[i].title+'</a><span>'+members[i].date+'</span></li>';
		   if(line%10==0){
		   newcontent +='</ul><ul class="clearfix">';
		   }
		   line++;
		}
		newcontent +='</ul>';
	$('#Searchresult').html(newcontent);
		return false;
	}
   
function initPagination() {
	$.ajax({
		type:"GET",
		cache:false,
		dataType:"json",
		url: "/210801/211150/index.js",
		success: function(json) {

		allNews=json.items;
		//members=allNews;
		//makePage();
		checkBoxChange();
		}

	});
}

function makePage(){
	var num_entries = members.length;
	$("#Pagination").pagination(num_entries, {
		 callback: pageselectCallback,
		 num_edge_entries: 2,
		 num_display_entries: 6,
		 items_per_page:pageSize,
		 prev_text:"上一页",
		 next_text:"下一页"
	});

}
$(document).ready(function(){      
	initPagination();
});

function checkBoxChange(){
	members=new Array();
	var selectNodeId=new Array();
	var checked=$("input:checked");
	if(checked!=null&&checked.length>0){
		for(var i=0;i<checked.length;i++){
			var value=checked[i].value;
			var nodelist=value.split(",");
			if(nodelist!=null&&nodelist.length>0){
				for(var j=0;j<nodelist.length;j++){
					selectNodeId.push(nodelist[j]);
				}
			}
		}
	}
	
	if(selectNodeId.length>0&&allNews.length>0){
		for(var i=0;i<allNews.length;i++){
			var item=allNews[i];
			if($.inArray(item.nodeId,selectNodeId)>=0){
				members.push(item);
			}
		}
	}else{
		//members=allNews;
	}
	makePage();
}

function pageChange(i){
		if(i==1){
		    pageSize = 10;
			}
		else if(i==2){
		    pageSize = 20;
			}
	    else if(i==3){
			pageSize = 30;
			}
		makePage();
		}
</script>
<script type="text/javascript">
<!--
function showMenu() {
    document.getElementById('people_menu').style.display = 'block';
}
function hideMenu() {
    document.getElementById('people_menu').style.display = 'none';
}
-->
</script>
<style type="text/css" media="screen">#FDL {visibility:hidden}#FP {visibility:hidden}</style><style type="text/css"></style></head>
<body>
<!--ad top-->
<div class="m0 mb10 w960"><!--AdForward Begin:-->
<script type="text/javascript" src="./listnews/s" charset="gbk"></script><script language="Javascript">
</script>
<!--AdForward End--></div>
<div class="m0 mb10 w960"><!--AdForward Begin:-->
<script type="text/javascript" src="./listnews/s(1)" charset="gbk"></script><script language="Javascript">
</script>
<!--AdForward End--></div>
<!--nav-->

<!--top ad-->


<!--content-->
<div class="w960 m10 box_main clearfix">
  <!--left-->
  
  <!--right-->
  <div class="box_right fr">
   <div class="tools clearfix"> </div>
   <div class="box news_list">
  		<div id="Searchresult">
  		<ul class="clearfix">
	  		<c:forEach var="n" items="${list }">
		  		<li><a href="news.jsp?id=${n.id }" target="_blank">${n.title }</a><span>${n.pdate }</span></li>
	  		</c:forEach>
  		</ul>
  		<ul class="clearfix"></ul></div>
      
   </div>
  </div>
</div>
<div class="w960 m0"><!--AdForward Begin:--><script type="text/javascript" src="./listnews/s(2)" charset="gbk"></script><script language="Javascript">
</script>
<!--AdForward End--></div>


<!--版权信息-->
<!-- 版权栏 -->
<style>
#copyright{clear:both; margin:15px auto 5px; padding-top:10px; width:980px; height:auto; color:#333; font-size:12px; text-align:center;}
#copyright p{margin:0 0 2px 0; text-align:center;}
#copyright a{color:#333;}
#copyright p.p5{padding:5px 0;}
#copyright p.pb10{width:980px; margin:0 auto; padding-bottom:10px; word-break:keep-all; line-height:28px; overflow:hidden;}
#copyright p.mt10{margin-top:10px;}
#copyright p.mt10 span.red{color:#cc0000;}
#copyright p.mt10 span.red a:link,#copyright p.mt10 span.red a:hover,#copyright p.mt10 span.red a:visited{color:#cc0000; text-decoration:none;}
</style>

<!-- 版权栏结束 -->
<!--AdForward Begin:-->
<script type="text/javascript" src="./listnews/s(3)" charset="gbk"></script><script language="Javascript">
</script>
<!--AdForward End-->
<!--AdForward Begin:-->
<script type="text/javascript" src="./listnews/s(4)" charset="gbk"></script><script language="Javascript">
</script>
<!--AdForward End-->
<!--AdForward Begin:-->
<script type="text/javascript" language="JavaScript">
 if (window.screen.width >= 1024){
  document.write("<s"+"cript type='text/javascript' src='http://pmm.people.com.cn/main/s?user=people|news|T2&db=people&border=0&local=yes&js=ie' charset='gbk'></script"+">");
 }
</script><script type="text/javascript" src="./listnews/s(5)" charset="gbk"></script><script language="Javascript">
</script>

<!--AdForward End-->
<!--AdForward Begin:-->
<script type="text/javascript" src="./listnews/s(6)" charset="gbk"></script><script language="Javascript">
</script>

<!--AdForward End-->
<!-- 84261：滚动新闻弹出视窗 -->
<script type="text/javascript">//<![CDATA[
ac_as_id = 84261;
ac_format = 0;
ac_mode = 1;
ac_group_id = 1;
ac_server_base_url = "afp.csbew.com/";
//]]></script>
<ins id="ac_js86_84261" style="display: none;"></ins><script type="text/javascript" src="./listnews/k.js"></script>
<script src="./listnews/webdig_test.js" language="javascript" type="text/javascript"></script><script id="tr_statobj" src="./listnews/webdig.js" type="text/javascript"></script><script type="text/javascript"> wd_paramtracker('_wdxid=000000000000000000000000000000000000000000');</script>

<div class="_bd_ext_tip" style="visibility: hidden;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>