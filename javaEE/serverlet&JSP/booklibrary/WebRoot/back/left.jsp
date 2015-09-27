<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/jquery.accordion.js"></script>
<script language="javascript">
	jQuery().ready(function(){
		jQuery('#navigation').accordion({
			header: '.head',
			navigation1: true, 
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'
		});
	});
</script>
<style type="text/css">
<!--
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
}
#navigation {
	margin:0px;
	padding:0px;
	width:147px;
}
#navigation a.head {
	cursor:pointer;
	background:url(images/main_34.gif) no-repeat scroll;
	display:block;
	font-weight:bold;
	margin:0px;
	padding:5px 0 5px;
	text-align:center;
	font-size:12px;
	text-decoration:none;
}
#navigation ul {
	border-width:0px;
	margin:0px;
	padding:0px;
	text-indent:0px;
}
#navigation li {
	list-style:none; display:inline;
}
#navigation li li a {
	display:block;
	font-size:12px;
	text-decoration: none;
	text-align:center;
	padding:3px;
}
#navigation li li a:hover {
	background:url(images/tab_bg.gif) repeat-x;
		border:solid 1px #adb9c2;
}
-->
</style>
</head>
<body>
<div  style="height:100%;">
  <ul id="navigation">
    <li> <a class="head">书籍管理</a>
      <ul>
        <li><a href="${pageContext.request.contextPath}/servlet/BookServlet?method=addBookUI" target="rightFrame">添加书籍</a></li>
        <li><a href="${pageContext.request.contextPath}/servlet/BookServlet?method=listBook" target="rightFrame">查看/修改书籍</a></li>
      </ul>
    </li>
    <li> <a class="head">分类管理</a>
      <ul>
        <li><a href="${pageContext.request.contextPath}/servlet/CategoryServlet?method=addCategoryUI" target="rightFrame">添加分类</a></li>
        <li><a href="${pageContext.request.contextPath}/servlet/CategoryServlet?method=listCategory" target="rightFrame">查看/删除分类</a></li>
      </ul>
    </li>
    <li> <a class="head">留言评论管理</a>
      <ul>
        <li><a href="#" target="rightFrame">查看/删除留言</a></li>
        <li><a href="#" target="rightFrame">查看/删除评论</a></li>
      </ul>
    </li>
    <li> <a class="head">版本信息</a>
      <ul>
        <li><a href="#" >V1.0</a></li>
      </ul>
    </li>
  </ul>
</div>
</body>
</html>
