<%@page import="com.bjsxt.shopping.CategoryDAO"%>
<%@page import="com.bjsxt.shopping.Category"%>
<%@page import="com.bjsxt.shopping.ProductMgr"%>
<%@page import="com.bjsxt.shopping.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
List<Product> products = ProductMgr.getInstance().getLatestProducts(10);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0201)http://list.suning.com/0-20062-0-0-0-9173.html?utm_source=baidu&utm_medium=cpc&utm_campaign=%E7%BD%91%E8%B4%AD+%E9%80%9A%E7%94%A8&utm_content=0biaoti&utm_term=u9789012.c0.g0.k20747557483.a6753576384.pb -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><iframe src="./images/adxcm_base_idigger.html" style="width: 0px; height: 0px; position: absolute; top: -100px; left: -100px; display: none;"></iframe><script type="text/javascript" async="" src="./images/aywmq.js"></script><script async="" src="./images/analytics.js"></script><script type="text/javascript" async="" src="./images/da_opt.js"></script>

<script>var d = function (b) {var a;return (a = document.cookie.match(RegExp("(^| )" + b + "=([^;]*)(;|$)"))) ? decodeURIComponent(a[2].replace(/\+/g, "%20")): null};</script>
<script language="javascript" src="./images/abtest.min.js" charset="utf-8"></script>
<script>
if(checkAbtest("50","50",32,".suning.com")){window.location.reload(true);}
</script>
<script type="text/javascript">
var pageType = "ssdln_20062";
var sn = {"cookieDomain":'.suning.com', "online":'online.suning.com',
"context": "/emall",
"domain": "www.suning.com",
"storeId": "10052",
"catalogId": "10051",
"memberDomain": "member.suning.com",
"cookieDomain": ".suning.com",
"categoryId": "20062",
"searchDomain": "http://search.suning.com/emall/",
"talkDomain":"http://talk.suning.com",
"hasSidebar":true,
"hasBottomFixed":true,
"hasTopFixed":true
};
</script>
<meta name="keywords" content="摄影摄像，摄影摄像报价，摄影摄像品牌，摄影摄像测试，摄影摄像图片，苏宁易购网上商城">
<meta name="description" content="苏宁易购(suning.com) 摄影摄像频道提供 摄影摄像正品行货，包括摄影摄像报价，参数，评价，品牌，图片等信息， 网购摄影摄像上苏宁!">
<title>摄影摄像【报价 品牌 测评 正品行货】—苏宁易购</title>
<style type="text/css">
</style>
<link rel="shortcut icon" href="http://www.suning.com/favicon.ico?v=3451" type="image/x-icon">

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





<!-- PRFLS RESOURCES -->
<link rel="shortcut icon" href="http://www.suning.com/favicon.ico" type="image/x-icon">

<link rel="stylesheet" href="http://res.suning.cn/public/v3/css/??v3common.min.css,search.min.css,sn-sidebar.min.css?v=2015072102">
<script type="text/javascript" src="./images/jquery.js"></script>
<script type="text/javascript" src="./images/saved_resource"></script>

<script>
	var sa;if(!sa){sa={}}if(!sa.click){sa.click={}}(function(){var u=/^\w*?.suning.com$/,t=document.location.hostname,h=(("https:"==document.location.protocol)?"https://":"http://"),p=i(),b="|",c=location.href,n=m(q(c));function r(aa,N){try{var Z=aa.name?m(aa.name):"name undefined";if(Z=="name undefined"){var ab=aa.attributes.name;if(ab!=undefined&&ab!=null){Z=ab.value?m(ab.value):"name undefined"}}if(N!=undefined&&N!=null&&N!=""){var K=aa.attributes[N];if(K!=undefined&&K!=null){Z=K.value?m(K.value):N+" undefined"}}var O=aa.id?m(aa.id):"id undefined",R=new Array(),A=(f(aa,R),R)?m(R.join("").replace(/\s|\|/ig,"")):"text undefined",U=(U=document.getElementById("resourceType"))?U.value:"",B=O+b+Z+b+A,S=(S=document.getElementById("errorCode"))?S.value:"",X=h+p+"/ajaxClick.gif",z=v(),k="_snck";l(k,z,"/","","");var Y=d();var E=typeof sn=="object"?sn.cityId:"can not get cityId",J=z+b+Y+b+B+b+n,W=aa.href?aa.href:"",I=(W?x(W):"-"),L=document.getElementById("URLPattern"),Q=(L?L.value:"");var D="";var G=o("logonStatus");if(G!=undefined&&G!=null){D=G}var F="";var j=o("_snma");if(j!=undefined&&j!=null&&j.indexOf("|")>=0){try{F=j.split("|")[1]}catch(V){}}var C="";var y=o("idsLoginUserIdLastTime");if(y!=undefined&&y!=null){C=y}var T="";var P=o("custno");if(P!=undefined&&P!=null){T=P}var M="";var ac=o("_snmb");if(ac!=undefined&&ac!=null&&ac.indexOf("|")>=0){try{M=ac.split("|")[0]}catch(V){}}var H=X+"?_snmk="+J+"&_snme="+S+"&_type="+U+"&_cId="+E+"&_sid="+I+"&urlPattern="+Q+"&vid="+F+"&lu="+C+"&sid="+M+"&mid="+T+"&ls="+D;w(H)}catch(V){}}function d(){if(!sa.pvId){sa.pvId=v()}return sa.pvId}function v(){try{var k=new Date(),j=Math.round(100000*Math.random()),z=k.getTime().toString().concat(j);return z}catch(y){}}function o(k){var j=document.cookie.split("; ");for(var y=0;y<j.length;y++){var z=j[y].split("=");if(z[0]==k){return unescape(z[1])}}}function w(j){var y="log_"+(new Date()).getTime();var k=window[y]=new Image();k.onload=(k.onerror=function(){window[y]=null});k.src=j+"&iId="+y;k=null}function i(){if(u.test(t)){return"click.suning.cn/sa"}else{return"clicksit.suning.cn/sa"}}function e(){return document.domain}function l(k,j,D,C,B){try{var A=k+"="+escape(j);if(C!=""){var z=new Date();z.setTime(z.getTime()+C);A+=";expires="+z.toGMTString()}if(D!=""){A+=";path="+D}var y=e();if(y.indexOf(".suning.com")!=-1){A+=";domain=.suning.com"}else{if(y.indexOf(".cnsuning.com")!=-1){A+=";domain=.cnsuning.com"}else{A+=";domain="+B}}document.cookie=A}catch(B){}}function x(k){var j="-";if(!a(k)){j=g(k,"tid","&")}return j}function q(j){try{if(j.length>301){j=j.substring(0,300)}while(j.indexOf(b)!=-1){j=j.replace(b,"--")}return j}catch(k){}}function f(z,k){try{if(z.nodeType==3){k.push(z.nodeValue)}else{if(z.nodeType==1){for(var j=z.firstChild;j!=null;j=j.nextSibling){f(j,k)}}}}catch(y){}}function m(j){return j!=null?encodeURIComponent(j):""}function g(y,k,B){try{var A="-",j;if(!a(y)&&!a(k)&&!a(B)){j=y.indexOf(k);if(j>-1){var z=y.indexOf(B,j);if(z<0){z=y.length}A=y.substring(j+k.length+1,z)}}return A}catch(z){}}function a(j){return(undefined==j||""==j||"-"==j)}var s=sa.click;s.sendDatasIndex=r})();
</script>
<!--[if IE 6]>
<script type="text/javascript" src="http://res.suning.cn/public/js/DD_belatedPNG.js"></script>
<![endif]--><link rel="stylesheet" type="text/css" href="./images/global_new.min.css">
<script type="text/javascript" src="./images/passport.js"></script><script src="./images/SFE.dialog.js" type="text/javascript"></script><script src="./images/jquery.cookie.min.js" type="text/javascript"></script><style>@-moz-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-webkit-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@-o-keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}@keyframes nodeInserted{from{opacity:0.99;}to{opacity:1;}}embed,object{animation-duration:.001s;-ms-animation-duration:.001s;-moz-animation-duration:.001s;-webkit-animation-duration:.001s;-o-animation-duration:.001s;animation-name:nodeInserted;-ms-animation-name:nodeInserted;-moz-animation-name:nodeInserted;-webkit-animation-name:nodeInserted;-o-animation-name:nodeInserted;}</style></head>
<body id="" class="root1200"><style id="ui-city-style">ul,li,p,h3,h5,em,b,i,span,a{ margin: 0; padding: 0; }ul,li { list-style: none; }.clearfix:after{ content:"."; display:block; height:0; clear:both; visibility:hidden}.clearfix{ zoom:1}.ui-city a,.ui-city a:visited{ line-height:14px; color:#333; text-decoration: none; outline: none; cursor: pointer;}.ui-city a:hover { text-decoration:none; }.ui-city { display:inline-block;*dispplay:inline;*zoom:1; font-size: 12px; position: relative; z-index: 0}.ui-city .dn { display: none; }.ui-city .db { display: block; }.ui-city .dib { display: inline-block; }.ui-city .arr { display: inline-block; width: 0; height:0; border-color: #bbb transparent transparent; border-width: 5px; border-style: solid dashed dashed; font-size: 0; line-height: 0; overflow: hidden; }.ui-city a.ui-city-toggle:hover { color:#333;}.ui-city-toggle { display:inline-block; border: 1px solid #bbb; padding:6px 5px 6px 6px; color: #000;background: #fff; position: relative; z-index: 100}.ui-city-toggle .address-placement {font-style: normal; float: left;}.ui-city-toggle span { padding-right: 5px}.ui-city-toggle span:hover {color: #333;}.ui-city-toggle .arr { margin-right:5px;position: relative; top:5px; float: left;}.ui-city-group { display:none; position: absolute;background: #fff; left: 0; top:27px;border: 1px solid #ccc; margin-top:-1px; width: 420px; z-index: 99; box-shadow: 0 0 6px #ddd;padding-top:5px;}.ui-city-group .ui-city-close  { position: absolute;right: 0;top: 0;padding: 5px 10px;overflow: hidden;}.ui-city-group .ui-city-close i { font: 700 14px/1.5 simsun;margin-left:-4px; color: #aaa}.ui-city-group-header { padding-top: 10px;  }.ui-city-group-header p { padding-left:15px; margin-bottom: 10px; }.ui-city-group-header .address-title { }.ui-city-group-header .address-item {clear:both; }.ui-city-group-header .address-item a,.ui-city-group-header .address-item a:visited{ display: inline-block;zoom:1; padding-top: 4px; padding-left: 5px; padding-bottom: 4px; margin-right: 10px; border: 1px solid #bbb; }.ui-city-group-header .address-item a:hover {  background: #f90; color: #fff;border:1px solid #f90; }.ui-city-group-header .address-item a span { padding-right:5px}.ui-city-group-content { margin: 10px 10px 0 10px; background:#fff;}.ui-city-group-content .nav-tabs { padding-left: 6px  }.ui-city-group-content .nav-tabs li {float: left; position: relative; z-index:2;border: 1px solid #ccc; height: 26px;background:#fff;margin-right: 6px; margin-bottom:0; cursor: pointer; }.ui-city-group-content .nav-tabs li p { padding: 6px 10px 6px 10px;border:1px solid #fff; }.ui-city-group-content .nav-tabs li a,.ui-city-group-content .nav-tabs li a:visited{ color: #999;float: left}.ui-city-group-content .nav-tabs li .arr { position: relative; top: 3px;left: 5px;font-size: 0; line-height: 0;}.ui-city-group-content .nav-tabs li.current { border: 2px solid #ffb84e; border-bottom:none; z-index: 4;}.ui-city-group-content .nav-tabs li.current p { padding: 6px 10px 5px 10px; position: relative; z-index: 4; border:none; }.ui-city-group-content .nav-tabs li.current .arr { border-color:  transparent transparent #f90; border-style:  dashed dashed solid; top:-2px; }.ui-city-group-content .nav-tabs li.current a,.ui-city-group-content .nav-tabs li.current a:visited{ display:inline-block; color: #333; }.ui-city-group-content .nav-tabs li.active a,.ui-city-group-content .nav-tabs li.active a:visited{ display:inline-block; color: #333; }.ui-city-group-content .tab-content { border-top: 2px solid #ffb84e;top:-2px;  position: relative; z-index: 3}.ui-city-group-content .tab-content .tab-panel { display: none; padding-top: 3px; padding-bottom: 15px; background: #fff;padding-left: 8px }.ui-city-group-content .tab-content .tab-panel.active { display: block;}.ui-city-group-content .tab-content li:after { content:"."; display:block; height:0; clear:both; visibility:hidden }.ui-city-group-content .tab-content li { *zoom:1;}.ui-city-group-content .tab-content li span {display:inline-block;width: 98px;}.ui-city-group-content .tab-content li a,.ui-city-group-content .tab-content li a:visited { display:inline-block; background:#fff;margin: 2px; padding: 5px; color:#000; }.ui-city-group-content .tab-content li a:hover { background: #f90; color: #fff;}.ui-city-group-content .tab-content li a.on,.ui-city-group-content .tab-content li a.on:visited { background: #f90;color: #fff; }.ui-city-group-content .tab-content .pr-panel li a{ }.ui-city.active { z-index: 10}.ui-city.active a.ui-city-toggle { border: 1px solid #ccc;background:#fff;border-bottom:none;box-shadow: 0 -1px 1px #ddd}.ui-city.active a.ui-city-toggle:hover { color: #333; background: #fff; text-decoration: none;}.ui-city.active a.ui-city-toggle .arr{ border-color:  transparent transparent #f90; border-style:  dashed dashed solid; top:0; }.ui-city.active .ui-city-group { display: block; }.ui-city .arr {transition:All .2s ease;-webkit-transition:All .2s ease;-moz-transition:All .2s ease;-o-transition:All .2s ease;-ms-transition:All .2s ease;}</style>
<script type="text/javascript">var _tBody = document.getElementsByTagName("body")[0],_tBodyW = window.screen.width;if(_tBodyW<1200){_tBody.id = "thirdN";_tBody.className= "root1000";}else{_tBody.id = "";_tBody.className= "root1200";}</script>
<!-- 页面顶部的搜索栏(及网站logo) -->
<input type="hidden" id="searchCatalogId" value="10051">

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




<div id="_TOP_BANNER_" class="ng-top-banner"></div>
<div class="ng-toolbar">
	<div class="ng-toolbar-con wrapper">
		<div class="ng-toolbar-left">
			<a href="http://www.suning.com/" class="ng-bar-node ng-bar-node-backhome" id="ng-bar-node-backhome" name="public0_none_dbgjt_fhyisy01" style="display: block;">
				<i class="ng-iconfont ng-backhome"></i><span>返回易购首页</span>
				<i class="ng-line ng-iconfont ml10"></i>
			</a>
			<script type="text/javascript">
				if (!sn.isHome){document.getElementById('ng-bar-node-backhome').style.display = "block";};
			</script>
			<!--网站导航 [[-->
			<div class="ng-bar-node-box ng-site-nav-box">
				<a href="javascript:void(0);" class="ng-bar-node ng-bar-node-site" name="public0_none_dbgjt_wzdh03">
					<span>网站导航<i class="new" style="display: inline-block;"></i></span><em class="ng-iconfont down"></em>
				</a>
				<div class="ng-sn-site-nav ng-d-box site-nav-child" style="display:none;">
					<dl class="sn-site-list lnb">
					   <dt>
					    特色购物
					   </dt>
					   <dd>
					    <p><a name="public0_none_dbgjt_wzdh030101" href="http://10035.suning.com/" target="_blank">苏宁互联</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030102" href="http://store.suning.com/v.htm" target="_blank">苏宁V购</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030103" href="http://member.suning.com/emall/GiftCardStaticPageView?storeId=10052&catalogId=10051" target="_blank">苏宁卡</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030104" href="http://g.suning.com/" target="_blank">海外购</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030105" href="http://b.suning.com/" target="_blank">政企采购</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030106" href="http://ju.suning.com/" target="_blank">大聚惠</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030107" href="http://try.suning.com/" target="_blank">0元试用</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030108" href="http://tv.suning.com/" target="_blank">视频购物</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030111" href="http://sale.suning.com/images/advertise/mdr/oabangong526/index.html" target="_blank">办公直通车</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030112" href="http://pai.suning.com/shanpai/" target="_blank">闪拍</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030113" href="http://yushou.suning.com/" target="_blank">预售</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030114" href="http://new.suning.com/" target="_blank">新发现</a></p>
					   </dd>
					</dl>
					  <dl class="sn-site-list">
					   <dt>
					    主题频道
					   </dt>
					   <dd>
					    <p><a name="public0_none_dbgjt_wzdh030201" href="http://channel.suning.com/dianqicheng.html" target="_blank">电器城<i class="hot"></i></a></p>
					    <p><a name="public0_none_dbgjt_wzdh030202" href="http://chaoshi.suning.com/" target="_blank">苏宁超市</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030203" href="http://shouji.suning.com/" target="_blank">手机</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030204" href="http://sports.suning.com/" target="_blank">运动馆</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030205" href="http://book.suning.com/" target="_blank">图书</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030207" href="http://redbaby.suning.com/" target="_blank">红孩子母婴</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030208" href="http://binggo.suning.com/" target="_blank">缤购美妆</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030209" href="http://pindao.suning.com/city/diannao.htm" target="_blank">电脑</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030210" href="http://fashion.suning.com/" target="_blank">服装城<i class="new"></i></a></p>
					    <p><a name="public0_none_dbgjt_wzdh030212" href="http://pinpai.suning.com/" target="_blank">品牌街</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030213" href="http://smarthome.suning.com/" target="_blank">智能生活</a></p>
					   </dd>
					  </dl>
					  <dl class="sn-site-list">
					   <dt>
					    生活助手
					   </dt>
					   <dd>
					    <p><a name="public0_none_dbgjt_wzdh030301" href="https://passport.suning.com/ids/trustLogin?sysCode=epp&targetUrl=https://licai.suning.com/bof/bofIndex.htm" target="_blank">零钱宝<i class="hot"></i></a></p>
					    <p><a name="public0_none_dbgjt_wzdh030302" href="http://chong.suning.com/eppscrp/mobile/fill.htm" target="_blank">手机充值</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030303" href="http://huochepiao.suning.com/" target="_blank">火车票</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030304" href="http://sh.suning.com/life/at/memtrans!input.action" target="_blank">转账还款</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030305" href="http://sale.suning.com/images/advertise/007/event/index.html" target="_blank">苏宁帮客</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030306" href="http://sh.suning.com/life/2-1.html" target="_blank">水电煤</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030307" href="http://baoxian.suning.com/ins/index.htm" target="_blank">保险</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030308" href="http://caipiao.suning.com/" target="_blank">彩票</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030309" href="http://jipiao.suning.com/" target="_blank">机票</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030310" href="https://passport.suning.com/ids/trustLogin?sysCode=manzuo&targetUrl=http%3a%2f%2fhotel.manzuo.com%2f%3fcampaign%3d%3fcampaign%3dsuning_shouye_daohang" target="_blank">酒店团购</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030509" href="http://store.suning.com/" target="_blank">门店查询</a></p>
					   </dd>
					  </dl>
					  <dl class="sn-site-list">
					   <dt>
					    会员服务
					   </dt>
					   <dd>
					    <p><a name="public0_none_dbgjt_wzdh030401" href="http://vip.suning.com/" target="_blank">会员联盟<i class="hot"></i></a></p>
					    <p><a name="public0_none_dbgjt_wzdh030402" href="http://club.suning.com/" target="_blank">苏宁社区</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030403" href="http://member.suning.com/emall/YBBagIndexView?storeId=10052&catalogId=10051" target="_blank">延长保修</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030404" href="http://snbook.suning.com/web/index.htm" target="_blank">免费书城</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030405" href="https://pay.suning.com/epp-portal/useraccount/user-account!initUserAccount.action" target="_blank">易付宝</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030407" href="https://passport.suning.com/ids/trustLogin?sysCode=epp&targetUrl=https://licai.suning.com/bof/licaiIndex.htm" target="_blank">苏宁理财</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030406" href="http://jinrong.suning.com/" target="_blank">苏宁金融<i class="new"></i></a></p>
					   </dd>
					  </dl>
					  <dl class="sn-site-list rnb">
					   <dt>
					    更多热点
					   </dt>
					   <dd>
					    <p><a name="public0_none_dbgjt_wzdh030501" href="http://www.manzuo.com/" target="_blank">满座网</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030503" href="http://www.pptv.com/" target="_blank">PPTV</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030504" href="http://sale.suning.com/images/advertise/hg/20120419xsjkhd/index.html" target="_blank">客户端</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030505" href="http://sop.suning.com/" target="_blank">商家入驻</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030506" href="http://pan.suning.com/" target="_blank">苏宁云</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030507" href="http://sncs.suning.com/" target="_blank">苏宁众包</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030508" href="http://union.suning.com/" target="_blank">苏宁联盟</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030510" href="http://ued.suning.com/survey/" target="_blank">用户体验</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030406" href="http://app.suning.com/android" target="_blank">应用商店</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030511" href="http://gongyi.suning.com/" target="_blank">公益频道</a></p>
					    <p><a name="public0_none_dbgjt_wzdh030502" href="http://sale.suning.com/images/advertise/zyn/suxiaoxiao/index.html" target="_blank">校园代理</a></p>
					    <p><a name="" href="http://sums.suning.com/front.htm" target="_blank">苏宁加盟</a></p>
					   </dd>
					  </dl>
					<a href="javascript:void(0);" class="ng-close" name="public0_none_dbgjt_wzdh030516"><em class="ng-iconfont"></em></a>
				</div>
			</div>
			<!--网站导航 ]]-->		
		</div>
		<div class="ng-toolbar-right">
			<!-- 登录注册 -->
			<a href="javascript:void(0)" class="ng-bar-node username-bar-node username-bar-node-showside" id="username-node" rel="nofollow" style="display: none;">
				<span id="usernameHtml01"></span>
				<em class="hasmsg ng-iconfont"></em>
			</a>
			<div class="ng-bar-node-box username-handle" id="username-node-slide" style="display: none;">
				<a href="http://my.suning.com/" rel="nofollow" class="ng-bar-node username-bar-node username-bar-node-noside" style="display: none;">
					<span id="usernameHtml02"></span>
					<em class="hasmsg ng-iconfont"></em>
					<em class="ng-iconfont down"></em>
				</a>
				<div class="ng-d-box ng-down-box ng-username-slide" style="display:none;">
					<a href="http://my.suning.com/person.do" class="ng-vip-union" target="_blank" rel="nofollow">账号管理</a>
					<a href="javascript:SFE.base.logoff();" rel="nofollow">退出登录</a>
				</div>
			</div>
			<div class="ng-bar-node reg-bar-node" id="reg-bar-node" style="display: block;">
				<a href="login.jsp" name="public0_none_dbgjt_login0800" class="login">登录</a>
				<a href="register.jsp" class="login reg-bbb" name="public0_none_dbgjt_register09">注册</a>
			</div>
			<script type="text/javascript">
				function d(b) {
					var a;
					return (a = document.cookie.match(RegExp("(^| )" + b + "=([^;]*)(;|$)"))) ? decodeURIComponent(a[2]
						.replace(/\+/g, "%20"))
						: null
				};
				var uernameA = d("logonStatus");
				var usernameNode = document.getElementById('username-node');
				var usernameNodeSlide = document.getElementById('username-node-slide');
				var usernameHtml01 = document.getElementById('usernameHtml01') , usernameHtml02 = document.getElementById('usernameHtml02');
				var regBarNode = document.getElementById('reg-bar-node');
				if (uernameA != null && uernameA != "") {
					var uernameC = d("nick");
					// if( ((window.sidebar_config && sidebar_config.enable)||sn.hasSidebar) && !sn.hasNewSidebar ){
					// 	usernameNode.style.display = "block";
					// }else{
						usernameNodeSlide.style.display = "block";
					//}
					usernameHtml01.innerHTML = uernameC;
					usernameHtml02.innerHTML = uernameC;
					regBarNode.style.display = "none";
				}else{
					usernameNode.style.display = "none";
					usernameNodeSlide.style.display = "none";
					usernameHtml01.innerHTML = " ";
					usernameHtml02.innerHTML = " ";
					regBarNode.style.display = "block";
				}
			</script>
			<!-- <i class="ng-line ng-iconfont">&#xe628;</i> -->

			<!--我的订单 [[-->
			<div class="ng-bar-node-box myorder-handle">
				<a href="http://member.suning.com/emall/MyOrdersView?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_order04" class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>我的订单</span><em class="ng-iconfont down"></em></a>
				<div class="ng-down-box ng-d-box myorder-child" style="display:none;">
					<a href="http://member.suning.com/emall/MyOrdersView?catalogId=10051&storeId=10052&selectTime=all&status=M" rel="nofollow" name="public0_none_dbgjt_order0401">待支付<em id="waitPayCounts"></em></a>
					<a href="http://member.suning.com/emall/MyOrdersView?catalogId=10051&storeId=10052&selectTime=all&status=C000" rel="nofollow" name="public0_none_dbgjt_order0402">待收货<em id="waitDeliveryCounts"></em></a>
					<a href="http://zone.suning.com/review/my_product_review.htm" rel="nofollow" name="public0_none_dbgjt_order0403">待评价<em id="waitEvaluation"></em></a>
					<a href="http://member.suning.com/emall/SNLingYueGoodsOrderView?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_order0404">修改订单</a>
				</div>
			</div>
			<!--我的订单 ]]-->
			<!--我的易购 [[-->
			<div class="ng-bar-node-box mysuning-handle">
				<a href="http://my.suning.com/" rel="nofollow" name="public0_none_dbgjt_wdyg05" class="ng-bar-node ng-bar-node-fix touch-href ng-bar-node-pr5"><span>我的易购</span><em class="ng-iconfont down"></em></a>
				<div class="ng-down-box ng-d-box mysuning-child" style="display:none;">
					<a href="http://msg.suning.com/" name="public0_none_dbgjt_wdyg0501" rel="nofollow">我的消息</a>
					<a href="https://passport.suning.com/ids/trustLogin?sysCode=epp&targetUrl=http://my.jr.suning.com/sfp/accountAssets/index.htm" rel="nofollow" name="public0_none_dbgjt_wdyg0502" target="_blank">我的金融</a>
					<a href="http://favorite.suning.com/myFavoriteView.do" rel="nofollow" name="public0_none_dbgjt_wdyg0503">我的收藏</a>
					<a href="http://member.suning.com/emall/MyGiftTicket?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_wdyg0504">我的优惠券</a>
					<a href="http://vip.suning.com/ams-web/member/exchangeDetail.htm" rel="nofollow" name="public0_none_dbgjt_wdyg0505">我的云钻</a>
					<a href="http://vip.suning.com/" class="ng-vip-union" target="_blank" rel="nofollow" name="public0_none_dbgjt_wdyg0506">会员联盟<em class="ng-iconfont"></em></a>
				</div>
			</div>
			<!--我的易购 ]]-->
			<!-- 购物车 -->
			<a class="ng-bar-node ng-bar-node-mini-cart" name="public0_none_minicart_gouwclj" rel="nofollow" href="http://cart.suning.com/emall/OrderItemDisplay?langId=-7&storeId=10052&catalogId=10051">
				<em class="ng-iconfont cart"></em><span>购物车</span>
				<span class="total-num-box" id="J_total_num_box">
					<b class="total-num J_cart_total_num" id="showTotalQty">0</b>
					<span class="total-num-bg-box">
						<em></em>
						<i></i>
					</span>
				</span>
			</a>
			<script type="text/javascript">
				var ngCartNum =  d("totalProdQty");
				ngCartNum = ( ngCartNum ==0 || ngCartNum == null )?0:ngCartNum;
				ngCartNum = ngCartNum>99?'99+':ngCartNum;
				document.getElementById('showTotalQty').innerHTML = ngCartNum;
			</script>

			<!--手机苏宁 [[-->	
			<div class="ng-bar-node-box app-down-box">
				<a href="http://sale.suning.com/images/advertise/hg/20120419xsjkhd/index.html" target="_blank" name="public0_none_dbgjt_sjsn01" rel="nofollow" class="ng-bar-node mb-suning touch-href">
					<em class="ng-iconfont mb"></em><span>手机苏宁</span><em class="ng-iconfont down"></em>
				</a>
				<div class="ng-mb-box ng-d-box mb-down-child" style="display:none;">
					<div class="ng-code-box">
						<p class="ng-tip">
							<a href="http://sale.suning.com/images/advertise/hg/20120419xsjkhd/index.html" rel="nofollow" name="public0_none_dbgjt_sjsn0101" target="_blank">扫一扫，下载易购客户端</a>
						</p>
						<a href="http://sale.suning.com/images/advertise/hg/20120419xsjkhd/index.html" rel="nofollow" name="public0_none_dbgjt_sjsn0102" target="_blank">
							<img src3="http://img.suning.cn/public/v3/images/code.png?var=06" alt="苏宁易购APP二维码" height="80" width="80">
						</a>
					</div>
					<div class="ng-app-box">
						<div class="ng-app-list">
	                        <a href="http://app.suning.com/android/app/page?pack=com.suning.mobile.epa" target="_blank" rel="nofollow" name="public0_none_dbgjt_sjsn0103" class="ng-app"><img src3="http://img.suning.cn/public/v3/images/app-ebook.png?var=01" title="易付宝钱包"></a>
	                        <a href="http://sale.suning.com/images/advertise/zyn/TV0811sndjt/index.html" target="_blank" rel="nofollow" name="public0_none_dbgjt_sjsn0104" class="ng-app"><img src3="http://img.suning.cn/public/v3/images/app-sn.png?var=03" title="苏宁易购TV版"></a>
	                        <a href="http://app.suning.com/android/app/page?pack=com.pplive.androidphone" target="_blank" rel="nofollow" name="public0_none_dbgjt_sjsn0105" class="ng-app"><img src3="http://img.suning.cn/public/v3/images/app-pptv.png?var=01" title="PPTV"></a>
	                        <a href="http://app.suning.com/android/app/page?pack=com.suning.mobile.subook" target="_blank" rel="nofollow" name="public0_none_dbgjt_sjsn0106" class="ng-app"><img src3="http://img.suning.cn/public/v3/images/app-suning.png?var=02" title="苏宁阅读"></a>
						</div>
						<a href="http://app.suning.com/" class="ng-app-btn" name="public0_none_dbgjt_sjsn0107" target="_blank">更多应用<em class="ng-iconfont"></em></a>
					</div>
					<a href="http://sale.suning.com/images/advertise/hb/yinliuye0512/index.html" target="_blank" rel="nofollow" name="public0_none_dbgjt_sjsn0108">
						<img src3="http://img.suning.cn/public/v3/images/newreg.png?v=20150506" height="35" width="242">
					</a>
					<a href="javascript:void(0);" name="index_none_dbgjt_sjsn0110" class="ng-close" rel="nofollow"><em class="ng-iconfont"></em></a>
				</div>
			</div>
			<!--手机苏宁 ]]-->

			<a href="https://passport.suning.com/ids/trustLogin?sysCode=epp&targetUrl=https://pay.suning.com/epp-epw/index/welcome.action" name="public0_none_dbgjt_yfb06" class="ng-bar-node ng-bar-node-pr5" target="_blank"><span>易付宝</span></a>
			<a href="http://b.suning.com/" class="ng-bar-node ng-bar-node-pr5" name="public0_none_dbgjt_qypd01" target="_blank"><span>政企采购</span></a>
			<!--服务中心 [[-->
			<div class="ng-bar-node-box service-handle">
				<a href="javascript:void(0);" class="ng-bar-node ng-bar-node-service ng-bar-node-fix touch-href ng-bar-node-pr5" rel="nofollow" name="public0_none_dbgjt_fwzx07"><span>服务中心</span><em class="ng-iconfont down"></em>
				</a>
				<div class="ng-down-box ng-d-box service-center-child ng-ser-list" style="display:none;">
					<a href="http://help.suning.com/" rel="nofollow" target="_blank" name="public0_none_dbgjt_fwzx0705">帮助中心</a>
					<a href="http://store.suning.com/" rel="nofollow" target="_blank" name="public0_none_dbgjt_fwzx0704">查找门店</a>
					<a href="http://member.suning.com/emall/returnGoodsOrderView?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_fwzx0701" target="_blank">退换货</a>
					<a href="http://member.suning.com/emall/SNRepairServiceApplyView?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_fwzx0703" target="_blank">维修保养</a>
					<a href="http://member.suning.com/emall/SNComplainServiceView?storeId=10052&catalogId=10051" rel="nofollow" name="public0_none_dbgjt_fwzx0702" target="_blank">投诉</a>
					<a href="http://s.suning.com/" rel="nofollow" name="public0_none_dbgjt_fwzx0706" target="_blank">建议反馈</a>
					<a href="javascript:findpass();" rel="nofollow" name="public0_none_dbgjt_fwzx0707">在线客服</a>
				</div>
			</div>
			<!--服务中心 ]]-->

		</div>
		<div id="ng-minicart-slide-box"></div>
	</div>
</div>
<div class="ng-header ng-channel-header">
	<div class="ng-header-con">
		<div class="wrapper">
			<div class="ng-logo-box" id="G_SUNING_LOGO">
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




<!-- LOGO -->
<a href="http://www.suning.com/" class="ng-logo">
	<img src="./images/snlogo.png" height="100" width="190" alt="苏宁易购">
</a>

				<span id="G_CHANNEL_LOGO" class="channel-logo"></span>
			</div>
			<div class="ng-search channel-search">
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





<!-- PRFLS SEARCH -->

	<div class="g-search">
		 <i class="ng-iconfont search-icon"></i>
		<form method="get" onsubmit="return SFE.search.onSubmitSearch(this)">
			<div class="search-keyword-box">
				<input tabindex="0" id="searchKeywords" type="text" class="search-keyword" name="index1_none_search_ss2" value="" autocomplete="off">
			</div>
			<input id="searchSubmit" type="submit" class="search-btn" name="index1_none_search_ss1" value="搜索">
			<div id="snKeywordNew" class="g-search-hotwords"><input type="hidden" id="searchDefaultKeyword" value="跑步机最高直降2000元" key="跑步机最高直降2000元">
  <a name="public0_RSC_变频空调_0" target="_blank" href="http://search.suning.com/%E5%8F%98%E9%A2%91%E7%A9%BA%E8%B0%83/cityId=9173"><font style="color:#FF6600">变频空调</font></a>
<a name="public0_RSC_0元试用_1" target="_blank" href="http://search.suning.com/0%E5%85%83%E8%AF%95%E7%94%A8/cityId=9173"><font style="color:#FF6600">0元试用</font></a>
<a name="public0_RSC_汽车坐垫_2" target="_blank" href="http://search.suning.com/%E6%B1%BD%E8%BD%A6%E5%9D%90%E5%9E%AB/cityId=9173">汽车坐垫</a>
<a name="public0_RSC_佳能700d_3" target="_blank" href="http://search.suning.com/%E4%BD%B3%E8%83%BD700d/cityId=9173">佳能700d</a>
<a name="public0_RSC_卫生巾_4" target="_blank" href="http://search.suning.com/%E5%8D%AB%E7%94%9F%E5%B7%BE/cityId=9173">卫生巾</a>
<a name="public0_RSC_牛奶_5" target="_blank" href="http://search.suning.com/%E7%89%9B%E5%A5%B6/cityId=9173">牛奶</a>
<a name="public0_RSC_消毒柜_6" target="_blank" href="http://search.suning.com/%E6%B6%88%E6%AF%92%E6%9F%9C/cityId=9173">消毒柜</a>
<a name="public0_RSC_奶粉_7" target="_blank" href="http://search.suning.com/%E5%A5%B6%E7%B2%89/cityId=9173">奶粉</a>
<a name="public0_RSC_饼干_8" target="_blank" href="http://search.suning.com/%E9%A5%BC%E5%B9%B2/cityId=9173">饼干</a>
</div>
		</form>
		<div id="ac_results" class="g-ac-results hide" style="display: none;"></div>
		<div id="rec_results" class="g-rec-results hide" style="display: none;">
			<ul class="history-results"></ul>
			<ul class="rec-results"></ul>
		</div>
		
		
	</div>
			</div>
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




<!-- LOGO -->
<div class="ng-top-act" id="ng-top-act"></div>

		</div>
	</div>
</div>

<div class="ng-nav-bar ng-nav-bar-chanel">
	<div class="ng-sort">
	<a class="ng-all-hook" href="http://www.suning.com/emall/pgv_10052_10051_1_.html" target="_blank" name="public0_none_dht_09">
		<span>全部商品分类</span><em class="ng-iconfont"></em>
	</a>
	<div class="ng-sort-list-box">
		<div class="ng-sort-detail">
			<a href="javascript:void(0);" class="ng-close-sort" name="public0_none_ml_gban"><em class="ng-iconfont"></em></a>
			<div class="sort-chanel">
			</div>
			<div class="cate-list">
				
			</div>
		</div>
	</div>
</div>
	<div class="ng-nav-index">
	<ul class="ng-nav" id="ng-main-nav">
		<li><a href="http://www.suning.com/" target="_blank" name="public0_none_dht_01">首页</a></li>
		<li><a href="http://chaoshi.suning.com/" target="_blank" name="public0_none_dht_02">苏宁超市</a></li>
		<li><a href="http://redbaby.suning.com/" target="_blank" name="public0_none_dht_03">红孩子母婴</a></li>
		<li><a href="http://dianqi.suning.com/" target="_blank" name="public0_none_dht_04">电器城</a></li>
		<li><a href="http://fashion.suning.com/" target="_blank" name="public0_none_dht_05">服装城<i class="new"></i></a></li>
		<li><a href="http://ju.suning.com/" target="_blank" name="public0_none_dht_06">大聚惠</a></li>
		<li><a href="http://g.suning.com/" target="_blank" name="public0_none_dht_07">全球闪购<i class="hot"></i></a></li>
		<li><a href="http://jinrong.suning.com/" target="_blank" name="public0_none_dht_08">苏宁金融</a></li>
<!-- 		<li><a href="http://binggo.suning.com/" target="_blank" name="public0_none_dht_08">美妆</a></li>
		<li><a href="http://pai.suning.com/shanpai" target="_blank" name="public0_none_dht_08">闪拍</a></li> -->
	</ul>	
</div>

	<div class="ng-nav-right-txtact"><a name="" href="http://sale.suning.com/images/advertise/007/zckj0725/index.html" target="_blank"><b></b>【新人福利】新会员10元红包免费领</a></div>
</div>
<div id="fullBg"></div>
<div class="tipInfor" id="tipInfor">
<div class="tipBg"></div>
<div class="con">
<div class="title">温馨提示<b class="closePop">关闭</b></div>
<i></i><p></p>
<a href="javascript:void(0)" class="closePop">确定</a>
</div>
</div>
<div class="wrap-search clearfix">
<input type="hidden" value="/directorySug.jsonp?keyword=20062&amp;cityId=9173" id="searchSugUrl" name="searchSugUrl">
<input type="hidden" value="20062" id="cid" name="cid">
<input type="hidden" value="9173" id="cityId" name="cityId">
<input type="hidden" value="3889" id="totalCount">
<!--面包屑-->
<div class="breadNavBg">
<div class="breadNav pb10">
<div><a title="首页" href="http://www.suning.com/">首页</a>&nbsp;&gt;&nbsp;</div><h1> <a title="手机/数码/配件" href="http://dianqi.suning.com/">手机/数码/配件</a>&nbsp;&gt;&nbsp;<span>摄影摄像</span>
</h1>
</div>
</div>
<div id="compare" style="right: 79.5px; display: none;">
<div class="top"><b>商品比较</b><a id="boxClose" onclick=""></a></div>
<div class="compareAll">
<ul id="compareCon"></ul>
<a name="ssdln_20062_dbsxsp01" class="compareBtn" href="javascript:void(0);" onclick="">对比</a>
<a class="compareClear" href="javascript:void(0);">清空对比框</a>
</div>
</div>
<div class="w1190">
<!-- 导航、最终购买、热销排行 -->
<div class="navBar">
<div class="navBar">
<!--导航-->
<div class="barTitle ">手机/数码/配件</div>
<div class="navBarCon mb10" id="navBarConIndex">
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second01" id="20002" href="http://list.suning.com/0-20002-0.html" target="_blank">手机通讯</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three01-01" id="20006" href="http://list.suning.com/0-20006-0.html" title="手机">手机</a></span>
</dd>
</dl>
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second02" id="20016" href="http://list.suning.com/0-20016-0.html" target="_blank">手机配件</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three02-01" id="20011" href="http://list.suning.com/0-20011-0.html" title="手机耳机">手机耳机</a></span>
<span><a name="ssdln_20062_catalog_three02-02" id="179001" href="http://list.suning.com/0-179001-0.html" title="移动电源">移动电源</a></span>
<span><a name="ssdln_20062_catalog_three02-03" id="308503" href="http://list.suning.com/0-308503-0.html" title="蓝牙耳机">蓝牙耳机</a></span>
<span><a name="ssdln_20062_catalog_three02-04" id="249513" href="http://list.suning.com/0-249513-0.html" title="保护壳/套">保护壳/套</a></span>
<span><a name="ssdln_20062_catalog_three02-05" id="249514" href="http://list.suning.com/0-249514-0.html" title="手机贴膜">手机贴膜</a></span>
<span><a name="ssdln_20062_catalog_three02-06" id="20038" href="http://list.suning.com/0-20038-0.html" title="车载">车载</a></span>
<span><a name="ssdln_20062_catalog_three02-07" id="20025" href="http://list.suning.com/0-20025-0.html" title="手机存储卡">手机存储卡</a></span>
<span><a name="ssdln_20062_catalog_three02-09" id="20017" href="http://list.suning.com/0-20017-0.html" title="手机电池">手机电池</a></span>
<span><a name="ssdln_20062_catalog_three02-10" id="336523" href="http://list.suning.com/0-336523-0.html" title="手机充电器">手机充电器</a></span>
<span><a name="ssdln_20062_catalog_three02-11" id="336521" href="http://list.suning.com/0-336521-0.html" title="数据线">数据线</a></span>
<span><a name="ssdln_20062_catalog_three02-12" id="125008" href="http://list.suning.com/0-125008-0.html" title="便携/蓝牙音箱">便携/蓝牙音箱</a></span>
<span><a name="ssdln_20062_catalog_three02-13" id="336522" href="http://list.suning.com/0-336522-0.html" title="手机饰品">手机饰品</a></span>
<span><a name="ssdln_20062_catalog_three02-14" id="20028" href="http://list.suning.com/0-20028-0.html" title="其他配件">其他配件</a></span>
</dd>
</dl>
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second03" id="294003" href="http://list.suning.com/0-294003-0.html" target="_blank">运营商</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three03-01" id="425503" href="http://list.suning.com/0-425503-0.html" title="宽带">宽带</a></span>
<span><a name="ssdln_20062_catalog_three03-02" id="440004" href="http://list.suning.com/0-440004-0.html" title="苏宁互联购机入网">苏宁互联购机入网</a></span>
<span><a name="ssdln_20062_catalog_three03-03" id="294004" href="http://list.suning.com/0-294004-0.html" title="购机送费">购机送费</a></span>
<span><a name="ssdln_20062_catalog_three03-04" id="294005" href="http://list.suning.com/0-294005-0.html" title="0元购机">0元购机</a></span>
<span><a name="ssdln_20062_catalog_three03-05" id="326003" href="http://list.suning.com/0-326003-0.html" title="选号入网">选号入网</a></span>
</dd>
</dl>
<dl class="foc">
<dt class="thirdBg  foc"><a name="ssdln_20062_catalog_second04" id="20062" href="http://list.suning.com/0-20062-0.html" target="_blank" class="foc">摄影摄像</a></dt>
<dd class="foc">
<span><a name="ssdln_20062_catalog_three04-01" id="20064" href="http://list.suning.com/0-20064-0.html" title="单反相机">单反相机</a></span>
<span><a name="ssdln_20062_catalog_three04-02" id="243003" href="http://list.suning.com/0-243003-0.html" title="微单/单电">微单/单电</a></span>
<span><a name="ssdln_20062_catalog_three04-03" id="20063" href="http://list.suning.com/0-20063-0.html" title="数码相机">数码相机</a></span>
<span><a name="ssdln_20062_catalog_three04-04" id="196502" href="http://list.suning.com/0-196502-0.html" title="数码摄像机">数码摄像机</a></span>
<span><a name="ssdln_20062_catalog_three04-05" id="247003" href="http://list.suning.com/0-247003-0.html" title="拍立得">拍立得</a></span>
<span><a name="ssdln_20062_catalog_three04-06" id="20068" href="http://list.suning.com/0-20068-0.html" title="镜头">镜头</a></span>
<span><a name="ssdln_20062_catalog_three04-07" id="328003" href="http://list.suning.com/0-328003-0.html" title="户外器材">户外器材</a></span>
<span><a name="ssdln_20062_catalog_three04-08" id="500316" href="http://list.suning.com/0-500316-0.html" title="航拍摄像">航拍摄像</a></span>
<span><a name="ssdln_20062_catalog_three04-09" id="500317" href="http://list.suning.com/0-500317-0.html" title="航拍摄像配件">航拍摄像配件</a></span>
<span><a name="ssdln_20062_catalog_three04-10" id="452003" href="http://list.suning.com/0-452003-0.html" title="运动相机">运动相机</a></span>
</dd>
</dl>
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second05" id="20084" href="http://list.suning.com/0-20084-0.html" target="_blank">数码配件</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three05-01" id="25507" href="http://list.suning.com/0-25507-0.html" title="存储卡">存储卡</a></span>
<span><a name="ssdln_20062_catalog_three05-02" id="20073" href="http://list.suning.com/0-20073-0.html" title="滤镜">滤镜</a></span>
<span><a name="ssdln_20062_catalog_three05-03" id="20070" href="http://list.suning.com/0-20070-0.html" title="闪光灯/手柄">闪光灯/手柄</a></span>
<span><a name="ssdln_20062_catalog_three05-04" id="177501" href="http://list.suning.com/0-177501-0.html" title="读卡器">读卡器</a></span>
<span><a name="ssdln_20062_catalog_three05-05" id="20086" href="http://list.suning.com/0-20086-0.html" title="相机贴膜">相机贴膜</a></span>
<span><a name="ssdln_20062_catalog_three05-06" id="167505" href="http://list.suning.com/0-167505-0.html" title="清洁工具">清洁工具</a></span>
<span><a name="ssdln_20062_catalog_three05-07" id="198504" href="http://list.suning.com/0-198504-0.html" title="三脚架/云台">三脚架/云台</a></span>
<span><a name="ssdln_20062_catalog_three05-08" id="199004" href="http://list.suning.com/0-199004-0.html" title="摄影包">摄影包</a></span>
<span><a name="ssdln_20062_catalog_three05-09" id="199501" href="http://list.suning.com/0-199501-0.html" title="电池/充电器">电池/充电器</a></span>
<span><a name="ssdln_20062_catalog_three05-10" id="312005" href="http://list.suning.com/0-312005-0.html" title="专业器材">专业器材</a></span>
<span><a name="ssdln_20062_catalog_three05-11" id="310504" href="http://list.suning.com/0-310504-0.html" title="拍立得附件">拍立得附件</a></span>
<span><a name="ssdln_20062_catalog_three05-12" id="337504" href="http://list.suning.com/0-337504-0.html" title="机身附件">机身附件</a></span>
<span><a name="ssdln_20062_catalog_three05-13" id="337505" href="http://list.suning.com/0-337505-0.html" title="镜头附件">镜头附件</a></span>
<span><a name="ssdln_20062_catalog_three05-14" id="31002" href="http://list.suning.com/0-31002-0.html" title="其他配件">其他配件</a></span>
</dd>
</dl>
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second06" id="410503" href="http://list.suning.com/0-410503-0.html" target="_blank">智能设备</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three06-01" id="410504" href="http://list.suning.com/0-410504-0.html" title="智能手表">智能手表</a></span>
<span><a name="ssdln_20062_catalog_three06-02" id="410505" href="http://list.suning.com/0-410505-0.html" title="智能手环">智能手环</a></span>
<span><a name="ssdln_20062_catalog_three06-03" id="410506" href="http://list.suning.com/0-410506-0.html" title="健康监测">健康监测</a></span>
<span><a name="ssdln_20062_catalog_three06-04" id="410507" href="http://list.suning.com/0-410507-0.html" title="运动跟踪">运动跟踪</a></span>
<span><a name="ssdln_20062_catalog_three06-05" id="420084" href="http://list.suning.com/0-420084-0.html" title="智能防丢">智能防丢</a></span>
<span><a name="ssdln_20062_catalog_three06-07" id="420086" href="http://list.suning.com/0-420086-0.html" title="体感车">体感车</a></span>
<span><a name="ssdln_20062_catalog_three06-08" id="420087" href="http://list.suning.com/0-420087-0.html" title="智能安防">智能安防</a></span>
<span><a name="ssdln_20062_catalog_three06-09" id="420090" href="http://list.suning.com/0-420090-0.html" title="智能家居">智能家居</a></span>
<span><a name="ssdln_20062_catalog_three06-10" id="440513" href="http://list.suning.com/0-440513-0.html" title="其他设备">其他设备</a></span>
</dd>
</dl>
<dl class=" ">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second07" id="20090" href="http://list.suning.com/0-20090-0.html" target="_blank">影音电子</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three07-01" id="224003" href="http://list.suning.com/0-224003-0.html" title="MID/平板电脑">MID/平板电脑</a></span>
<span><a name="ssdln_20062_catalog_three07-02" id="232003" href="http://list.suning.com/0-232003-0.html" title="耳机/耳麦">耳机/耳麦</a></span>
<span><a name="ssdln_20062_catalog_three07-03" id="20092" href="http://list.suning.com/0-20092-0.html" title="MP3/MP4">MP3/MP4</a></span>
<span><a name="ssdln_20062_catalog_three07-04" id="25001" href="http://list.suning.com/0-25001-0.html" title="数码相框">数码相框</a></span>
<span><a name="ssdln_20062_catalog_three07-05" id="20095" href="http://list.suning.com/0-20095-0.html" title="录音笔">录音笔</a></span>
<span><a name="ssdln_20062_catalog_three07-06" id="20096" href="http://list.suning.com/0-20096-0.html" title="收音/收录机">收音/收录机</a></span>
<span><a name="ssdln_20062_catalog_three07-07" id="185501" href="http://list.suning.com/0-185501-0.html" title="影音附件">影音附件</a></span>
</dd>
</dl>
<dl class="last">
<dt class="thirdBg  "><a name="ssdln_20062_catalog_second08" id="20103" href="http://list.suning.com/0-20103-0.html" target="_blank">电子教育</a></dt>
<dd class=" ">
<span><a name="ssdln_20062_catalog_three08-01" id="20104" href="http://list.suning.com/0-20104-0.html" title="点读机/点读笔">点读机/点读笔</a></span>
<span><a name="ssdln_20062_catalog_three08-02" id="20105" href="http://list.suning.com/0-20105-0.html" title="学生电脑">学生电脑</a></span>
<span><a name="ssdln_20062_catalog_three08-03" id="20106" href="http://list.suning.com/0-20106-0.html" title="电子词典">电子词典</a></span>
<span><a name="ssdln_20062_catalog_three08-04" id="20107" href="http://list.suning.com/0-20107-0.html" title="电子书">电子书</a></span>
<span><a name="ssdln_20062_catalog_three08-05" id="25502" href="http://list.suning.com/0-25502-0.html" title="复读机">复读机</a></span>
<span><a name="ssdln_20062_catalog_three08-06" id="336004" href="http://list.suning.com/0-336004-0.html" title="电子教材">电子教材</a></span>
<span><a name="ssdln_20062_catalog_three08-07" id="336005" href="http://list.suning.com/0-336005-0.html" title="学习机">学习机</a></span>
</dd>
</dl>
</div>
<!--广告-->
<div class="mb10 aBuy" id="aps_adboard" style="display:none"></div>
<!--最终购买--><!--热销--></div>
</div>
<div class="proList mb10">
<!--今日推荐-->
<div id="sugConHtml">
<div class="specPT">今日推荐 </div><div class="specP" style="height: auto; overflow: hidden;"></input>
<!-- ********************************************************************************************************************************** -->
<%--!
StringBuffer getJS(List<Category> categories, Category topcategory) {
	StringBuffer sb = new StringBuffer();
	int cnt = 1;
	for(int i = 0; i < categories.size(); i++) {
		Category c = categories.get(i);
		if(c.getPid() == topcategory.getId()) {
			sb.append("document.form2.category2.options["+cnt+"].text='"+c.getName()+"';\n");
			sb.append("document.form2.category2.options["+cnt+"].value='"+c.getId()+"';\n");
			cnt++;
		}
	}
	sb.insert(0, "document.form2.category2.options[0].text='--please choose second category!--';\n");
	sb.insert(0, "document.form2.category2.options[0].value='-1';\n");
	sb.insert(0, "document.form2.category2.selectedIndex = 0;\n");
	sb.insert(0, "document.form2.category2.length = "+cnt+";\n");
	sb.insert(0, "if(document.form2.category1.options[document.form2.category1.selectedIndex].value == '"+topcategory.getId()+"') {\n");
	sb.append("}\n");
	return sb;
}

--%>

<%
List<Category> categories = Category.getCategories();
List<Category> topcategories = new ArrayList<Category>();
//String str = "";
for(int i = 0; i < categories.size(); i++) {
	Category c = categories.get(i);
	if(c.getGrade() == 1) {
		topcategories.add(c);
//System.out.println(getJS(categories, c));
//str += getJS(categories, c);
	}
		
}
//System.out.println(str);
%>

<script>
function change(id) {
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState==4 && xmlhttp.status==200) {
			eval(xmlhttp.responseText);
		}
	}
	xmlhttp.open('get', 'Query.jsp?id='+id, true);
	xmlhttp.send();
}
</script>
<form name="form2" action="xx" method="post">
<select name="category1" style="font-size: 9pt; color: rgb(85, 85, 85);" onchange="change(this.value)">
                          <option selected="selected" value="0">--所有商品--</option>
                          <%
                          for(int i = 0; i < topcategories.size(); i++) {
                        	  Category c = topcategories.get(i);
                      	  %>
                      	  <option value="<%= c.getId()%>"><%= c.getName()%></option>
                      	  <%
                          }
                          %>
                        </select>
                  		
                  		<select name="category2">
                  		<option value="xxx">xxx</option>
                  		</select>
</form>
<!-- ********************************************************************************************************************************** -->
<!-- <option value="21">ThinkPad配件</option>
                          <option value="5">笔记本配件</option>
                          <option value="4">笔记本包</option>
                          <option value="2">电脑配套</option>
                          <option value="20">网络设备</option>
                          <option value="22">数码专区</option>
                          <option value="12">车载用品</option>
                          <option value="23">AV线缆</option>
                          <option value="3">办公文仪</option>
                          <option value="8">商务礼品</option>
                          <option value="24">清洁洗涤</option>
                          <option value="26">防眩防窥</option>
                          <option value="1">保修服务</option> -->

<ul id="specPB" style="width: 2024px;"><li val="16800307" class="16800307" gid="16800307"><a name="ssdln_20062_recjrtjn_1-1_p_0000000000_104243812_01A" href="http://product.suning.com/0000000000/104243812.html?f=t&src=ssdln_20062_recjrtjn_1-1_p_0000000000_104243812_01A" target="_blank"><img class="err-product" alt="佳能（Canon） EOS 70D 单反套机 （EF-S 18-135mm f/3.5-5.6 IS STM镜头）" src="./images/000000000104243812_1_100x100.jpg" width="100" height="100"></a><div><span><a id="baoguang_recjrtjn_1-1_0000000000_104243812_01A" name="ssdln_20062_recjrtjn_1-1_c_0000000000_104243812_01A" href="http://product.suning.com/0000000000/104243812.html?f=t&src=ssdln_20062_recjrtjn_1-1_c_0000000000_104243812_01A" target="_blank" title="佳能（Canon） EOS 70D 单反套机 （EF-S 18-135mm f/3.5-5.6 IS STM镜头）"><p>佳能（Canon） EOS 70D 单反套机 （EF-S 18-135mm f/3.5-5.6 IS STM镜头）<em></em></p></a></span><p class="price"><b>¥</b><img class="liprice" src="./images/16800307_9173_10052_9-1.png"></p></div></li><li val="1524608" class="1524608" gid="1524608"><a name="ssdln_20062_recjrtjn_1-2_p_0000000000_102381623_01A" href="http://product.suning.com/0000000000/102381623.html?f=t&src=ssdln_20062_recjrtjn_1-2_p_0000000000_102381623_01A" target="_blank"><img class="err-product" alt="富士（FUJIFILM） MINI 7S 一次成像 拍立得 （蓝色）" src="./images/000000000102381623_1_100x100.jpg" width="100" height="100"></a><div><span><a id="baoguang_recjrtjn_1-2_0000000000_102381623_01A" name="ssdln_20062_recjrtjn_1-2_c_0000000000_102381623_01A" href="http://product.suning.com/0000000000/102381623.html?f=t&src=ssdln_20062_recjrtjn_1-2_c_0000000000_102381623_01A" target="_blank" title="富士（FUJIFILM） MINI 7S 一次成像 拍立得 （蓝色）"><p>富士（FUJIFILM） MINI 7S 一次成像 拍立得 （蓝色）<em></em></p></a></span><p class="price"><b>¥</b><img class="liprice" src="./images/1524608_9173_10052_9-1.png"></p></div></li><li val="1742916" class="1742916" gid="1742916"><a name="ssdln_20062_recjrtjn_1-3_p_0000000000_102467271_01A" href="http://product.suning.com/0000000000/102467271.html?f=t&src=ssdln_20062_recjrtjn_1-3_p_0000000000_102467271_01A" target="_blank"><img class="err-product" alt="尼康（Nikon） D3200 单反套机（AF-S DX 18-55mm f/3.5-5.6G VR II 防抖镜头）黑" src="./images/000000000102467271_1_100x100.jpg" width="100" height="100"></a><div><span><a id="baoguang_recjrtjn_1-3_0000000000_102467271_01A" name="ssdln_20062_recjrtjn_1-3_c_0000000000_102467271_01A" href="http://product.suning.com/0000000000/102467271.html?f=t&src=ssdln_20062_recjrtjn_1-3_c_0000000000_102467271_01A" target="_blank" title="尼康（Nikon） D3200 单反套机（AF-S DX 18-55mm f/3.5-5.6G VR II 防抖镜头）黑"><p>尼康（Nikon） D3200 单反套机（AF-S DX 18-55mm f/3.5-5.6G VR II 防抖镜头）黑<em></em></p></a></span><p class="price"><b>¥</b><img class="liprice" src="./images/1742916_9173_10052_9-1.png"></p></div></li><li val="384620" class="384620" gid="384620"><a name="ssdln_20062_recjrtjn_1-4_p_0000000000_101364609_01A" href="http://product.suning.com/0000000000/101364609.html?f=t&src=ssdln_20062_recjrtjn_1-4_p_0000000000_101364609_01A" target="_blank"><img class="err-product" alt="尼康（Nikon） D7000 单反套机（AF-S DX 18-105 f/3.5-5.6G ED VR 防抖镜头）" src="./images/000000000101364609_1_100x100.jpg" width="100" height="100"></a><div><span><a id="baoguang_recjrtjn_1-4_0000000000_101364609_01A" name="ssdln_20062_recjrtjn_1-4_c_0000000000_101364609_01A" href="http://product.suning.com/0000000000/101364609.html?f=t&src=ssdln_20062_recjrtjn_1-4_c_0000000000_101364609_01A" target="_blank" title="尼康（Nikon） D7000 单反套机（AF-S DX 18-105 f/3.5-5.6G ED VR 防抖镜头）"><p>尼康（Nikon） D7000 单反套机（AF-S DX 18-105 f/3.5-5.6G ED VR 防抖镜头）<em></em></p></a></span><p class="price"><b>¥</b><img class="liprice" src="./images/384620_9173_10052_9-1.png"></p></div></li></ul></div><div class="sale" style="display:none">
</div>
</div>
<!--筛选项-->
<div id="filterShrink" class="filterDown"><span name="ssdln_20062_screen_more">更多选项</span><span class="txt"></span><b></b></div>
<!--排序-->
<div class="address">
  <div class="chose_citys clearfix">

</div>
<div class="search-common clearfix"><a href="javascript:void(0)" class="more twomore">
更多
<i class="thirdBg more-arrow"></i>
</a>
</div>
</div>
<!--商品列表-->
<div id="productTab" class="productTab">
<script type="text/javascript">
if (typeof param != 'undefined'){
param.currentPage = "0";
param.pageNumbers = "82";
param.numFound = "3889";
if("ssdln_20062"=="{pageType}"){
makeProductName($("#proShow,.snPages"));
}
}
</script>
<div class="proListTile" id="proShow">
<ul class="container clearfix ">

<!-- ************************************************************Product************************************************************ -->
<%
	for(int i=0;i<products.size();i++) {
		Product p = products.get(i);
%>
<li class="1742916 000000000102467271 102467271   item" name="000000000102467271">
<input type="hidden" class="hidenInfo" bigpartys="" order="" contract="" tryinstore="/">
<i class="searchBang"></i> 
<a title="<%= p.getName()%>" class="search-bl" href="productdetailshow.jsp?id=<%= p.getId()%>" target="_blank" name="ssdln_20062_pro_pic01-1_0_0_102467271_0">
<img class="err-product " src="./images/products/<%= p.getId()%>.jpg" alt="<%= p.getName()%>" width="200" height="200" rel="">
</a>
<div class="inforBg">
<h3>
<a href="productdetailshow.jsp?id=<%= p.getId()%>" class="proName" title="<%= p.getName()%>" target="_blank" name="ssdln_20062_pro_name01-1_0_0_102467271_0"><p><%= p.getName()%><em></em></p></a>
</h3>
<div class="infor-top clearfix">
<p class="price"><b>¥<%= p.getMemberprice()%></b>
</p>
<div class="label-box tag"></div>
</div>
<div class="comment clearfix">
<p><a target="_blank" name="ssdln_20062_pro_comment01-1_0_0_102467271_0" href="http://product.suning.com/102467271.html#pro_detail_tab"><i>16430</i>条评价</a></p>
</div>
<div class="stock">
<span><a name="ssdln_20062_pro_sjgs01-1_0_0_102467271_0" href="http://www.suning.com/sellers/102467271.html"><i class="cnt">6</i>个商家</a>在售</span>
</div>
</div>
<ul class="opre clearfix">
<li>
<a href="buy.jsp?id=<%= p.getId()%>" name="ssdln_20062_pro_buy01-1_0_0_102467271_0" class="buy ">加入购物车</a>
</li>
<li> <a class="" href="javascript:addToInterests(1742916,'000000000102467271');" name="ssdln_20062_pro_collect01-1_0_0_102467271_0">收藏</a></li>
<li><a href="javascript:void(0);" partnumber="102467271" val="1742916" class="compareBtn last" name="ssdln_20062_pro_compare01-1_0_0_102467271_0">对比</a></li>
</ul>
</li>
<%
}
%>
<!-- ************************************************************Product************************************************************ -->

</ul>


<input id="dsParam" type="hidden" value="9173-0-000000000102467271_1742916,000000000127385872_26691763,000000000101364609_384620,000000000121619325_21877644,000000000108145216_19932491,000000000106386139_18842464,000000000103798029_7042714,000000000106219104_18758342,000000000103687939_4842179,000000000122720420_22338818,000000000123397907_22891437,000000000106913904_19069385,000000000103441691_4086452,000000000106811520_19006921,000000000120979845_21337781,000000000125098762_24494243,000000000122971497_22478288,000000000101401578_289623,000000000126618017_25967918,000000000127385673_26712166,000000000124670771_24067953,000000000101395557_297281,000000000127198581_26535045,000000000103798030_7042711,000000000109748664_20640439,000000000123072605_22604857,000000000109815927_20696028,000000000124288153_23714904,000000000125309767_24682654,000000000105270478_18016238,000000000101264064_151080,000000000126335211_25695451,000000000108144914_19932213,000000000127385858_26712331,000000000104243812_16800307,000000000102381623_1524608,000000000106385720_18842339,000000000101401577_289622,000000000103982764_12700015,000000000103441688_4086454,000000000104260318_16818805,000000000123680676_23123862,000000000121619339_21877645,000000000121359535_21682583,000000000103711370_4931331,000000000108305317_19997860,000000000127161702_26489270,000000000125314808_24675508">
</div>
<script type="text/javascript">
var param = {"holdURL":"strd.do?ci=20062&cityId=9173"
,"isList":"0","isAllBook":false, "sortIndex":"","categoryId":"20062"
,"level":""
,"dirBean_level":"2"
,"currentPage":"0","pageNumbers":"82","numFound":"3889"
,"sortType":"","inventory":"","historyFilter":"","maxPrice":""
,"cityId":"9173","n":"2","promotionAll":""
,"urlSuffix":"sn/20062/cityId=9173&iy=0&sc=0", "searchType":"1", "promotion" : "0", "ctype":"-1"
,"showStock":""
,"searchUrl":"","adKeyFlag":false
,"":"","si":"","st":"14","promotionSearchFlag":"1"
,"searchBrandType":"0"
,"shopSearchFlag":"1"
,"swl":"1"

,"ext":""
,"ch":""};
param.inventory = "&iy=-1";
param.searchUrl = "http://list.suning.com";
</script>
<input id="uriJSON" type="hidden" value="{&quot;st&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;7&quot;},&quot;ext&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;6&quot;},&quot;il&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;17&quot;},&quot;path&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;0&quot;},&quot;ch&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;9&quot;},&quot;ci&quot;:{&quot;value&quot;:&quot;20062&quot;,&quot;index&quot;:&quot;1&quot;},&quot;cityId&quot;:{&quot;value&quot;:&quot;9173&quot;,&quot;index&quot;:&quot;5&quot;},&quot;bi&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;16&quot;},&quot;l&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;23&quot;},&quot;cp&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;2&quot;},&quot;sc&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;21&quot;},&quot;iy&quot;:{&quot;value&quot;:&quot;0&quot;,&quot;index&quot;:&quot;3&quot;},&quot;p&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;19&quot;},&quot;ct&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;4&quot;},&quot;showStock&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;18&quot;},&quot;tp&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;24&quot;},&quot;sp&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;8&quot;},&quot;hf&quot;:{&quot;index&quot;:&quot;10&quot;,&quot;count&quot;:&quot;6&quot;},&quot;_&quot;:{&quot;value&quot;:null,&quot;index&quot;:&quot;22&quot;}}">
</div>
<div class="clear"></div>
<div id="sellerSelect" class="few-pro"></div>
</div>
</div>

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




<div class="clear"></div>
<div class="ng-footer"><!--top fix bar [[-->
<div class="ng-fix-bar"></div>
<!--top fix bar ]]-->
</div><script type="text/javascript" src="./images/jquery_lib.min.js" charset="utf-8"></script>
<script type="text/javascript">
var URLPrefix = {"searchPage_logo":"http://script.suning.cn/images/logo/logo_search.png","brandLogo_domain":"http://image.suning.cn","suning_online":"online.suning.com","cookie_domain":".suning.com","ebook_url":"http://snbook.suning.com/web","book_emall":"http://www.suning.com","threePageHelpSelect":"http://zhishi.suning.com/zhishitang","adDir":"20055,336016,165005,20342,346870,341024,312005,92515,340571,20401,244004,258009,20320","list_search":"http://list.suning.com","positionID":"100001033","evaluateUrl":"http://review.suning.com","searchPositionID":"100000001","search_static":"http://script.suning.cn/newsearch","mobileUrl":"http://m.suning.com","domain":"http://image.suning.cn","tuijian_recommend":"http://tuijian.suning.com/recommend-portal","ï»¿#commerce":"emall çurlåç¼","adSuggest":"http://th.suning.com","detail_emall":"http://product.suning.com","commerce_emall":"http://www.suning.com/emall","search_static_new":"http://script.suning.cn/search","scriptDomianDir":"https://imgssl.suning.com","public_logo":"http://script.suning.cn/images/logo/snlogo.png","nintyDetail_emall":"http://product1.suning.com","appStoreUrl":"http://app.suning.com","party_emall":"http://ju.suning.com/","ds_server":"http://ds.suning.cn","zone_review":"https://zone.suning.com/review","res_static":"http://res.suning.cn","cart_emall":"http://cart.suning.com/emall","book_logo":"http://script.suning.cn/css/css_sn/bookchannel/bookchannel_630/images/booklogo2.png","shop_emall":"http://shopping.suning.com","favorite_dialog":"http://script.suning.cn","binggo_url":"http://binggo.suning.com","redbaby_url":"http://redbaby.suning.com","mobileProductUrl":"http://product.m.suning.com/","key_search":"http://search.suning.com","member_emall":"https://member.suning.com/emall","search":"http://search.suning.com/emall","talkDomain":"http://talk.suning.com"};
</script>
<script type="text/javascript">
var pageGlobalJsParam = {'priceImageServerNum':'2','cityId':'9173','imageServerNum':'5','prdImageDomain':'','prcImageDomain':''};
</script>
<script type="text/javascript" src="./images/favorite-api.min.js"></script>
<script type="text/javascript" src="./images/sellPointService.js"></script>
<script type="text/javascript" src="./images/SFE.city.js"></script>
<script language="javascript" src="./images/global_header_new.min.js" charset="utf-8"></script>
<!--[if IE 6]>
<script language="javascript" src="http://script.suning.cn/search/common/js/DD_belatedPNG.js?v=3451" charset="utf-8"></script>
<![endif]-->
<script type="text/javascript" src="./images/a_load_c.js"></script>
<script type="text/javascript" src="./images/third_slash_new.js"></script>
<!--iDigger Tracking Codes-->
<script>
var _wmmq = _wmmq || [];
_wmmq.push( [ "db", "ifc" ] ,[ "sitecode", "T-000130-01" ]);
_wmmq.push([ "cateid", "20089_20062"] ,["catename","手机/数码/配件:摄影摄像"]);
_wmmq.push(["userid", d("custno")] ,["userflag", ""]);
_wmmq.push( [ "_trackPoint" ] );
</script>
<!--iDigger Tracking Codes-->
<input type="hidden" name="URLPattern" id="URLPattern" value="listnew.suning.com">
<div class="sn-sidebar" style="right: 0px; display: block;"><div class="sn-sidebar-bg" style="left: 0px;"></div><div class="sn-sidebar-tabs sn-sidebar-middle-tabs" style="top: 108.5px; left: 0px; height: 274px;"><div class="sn-sidebar-tabs sn-sidebar-middle-tabs-top"><div class="sn-sidebar-tab sn-sidebar-tab-member sn-sidebar-tab-js" data-type="member"><a href="javascript:;"><i class="tab-icon tab-icon-member"></i><i class="tab-icon-tip"></i></a></div><div class="sn-sidebar-tab sn-sidebar-tab-cart sn-sidebar-tab-js" data-type="cart"><a href="javascript:;"><div class="tab-cart-tip-warp-box"><div class="tab-cart-tip-warp"><i class="tab-icon  tab-icon-cart"></i><i class="tab-icon-tip tab-icon-cart-tip"></i><span class="tab-cart-tip">购物车</span><span class="tab-cart-num J_cart_total_num">0</span></div></div></a></div></div><div class="sn-sidebar-tabs sn-sidebar-middle-tabs-bottom"><div class="sn-sidebar-tab sn-sidebar-tab-recharge sn-sidebar-tab-js" data-type="recharge"><a href="javascript:;"><i class="tab-icon tab-icon-recharge"></i><i class="tab-icon-tip"></i><span class="tab-tip">充值</span></a></div><div class="sn-sidebar-tab sn-sidebar-tab-history sn-sidebar-tab-js" data-type="history"><a href="javascript:;"><i class="tab-icon tab-icon-history"></i><i class="tab-icon-tip"></i><span class="tab-tip">足迹</span></a></div></div></div><div class="sn-sidebar-tabs sn-sidebar-bottom-tabs" style="left: 0px; height: 140px;"><div class="sn-sidebar-tab sn-sidebar-wider-tab sn-sidebar-code sn-sidebar-tab-js"><a href="javascript:;"><i class="tab-icon-tip tab-icon-code-tip"></i><i class="tab-icon tab-icon-code"></i></a></div><div class="sn-sidebar-tab sn-sidebar-wider-tab sn-sidebar-service sn-sidebar-tab-js" id="sn-sidebar-change-service"><a href="javascript:findpass();"><i class="tab-icon tab-icon-service"></i><span class="tab-tip tab-tip-wider">在线客服</span></a></div><div class="sn-sidebar-tab sn-sidebar-wider-tab sn-sidebar-feedback sn-sidebar-tab-js" id="sn-sidebar-change-feedback"><a href="http://ued.suning.com/survey/view/xinban" target="_blank"><i class="tab-icon tab-icon-feedback"></i><span class="tab-tip tab-tip-wider">调查问卷</span></a></div><div class="sn-sidebar-tab sn-sidebar-wider-tab sn-sidebar-to-top sn-sidebar-tab-js"><i class="tab-icon tab-icon-to-top"></i><span class="tab-tip tab-tip-wider">返回顶部</span></div></div><div class="tab-tip-code-warp" id="sn-sidebar-change-code"><a href="http://sale.suning.com/images/advertise/hb/yinliuye0512/index.html" target="_blank"><img class="tab-tip-code-warp-img" src="./images/code-img.jpg"></a></div><div class="sn-sidebar-contents"><div class="sn-sidebar-content sn-sidebar-cart"><div class="ng-sidebar-cart-wrapper"></div></div><div class="sn-sidebar-content sn-sidebar-recharge"></div><div class="sn-sidebar-content sn-sidebar-activity"></div><div class="sn-sidebar-content sn-sidebar-member"></div><div class="sn-sidebar-content sn-sidebar-history"></div><div class="sn-sidebar-content sn-sidebar-finance"></div><div class="sn-sidebar-all-loading"><p class="loading-content">加载中...</p></div></div></div><iframe id="_iframe_sa_sendByIframe" src="./images/cma_suning.html" height="0" width="0" style="display: none; visibility: hidden;"></iframe></body></html>