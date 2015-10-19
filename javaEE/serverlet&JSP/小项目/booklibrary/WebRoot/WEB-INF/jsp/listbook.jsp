<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CategoryList</title>
</head>
<body>
	<br>
	<br>
	<form action="${pageContext.request.contextPath }/servlet/BookServlet?method=query" method="post">
		<fieldset>
			<legend>Query</legend>
		input book's name or author's name or other keywords:<input type="text" name="name" value="${requestScope.name }">
		<input type="submit" value="query">
		</fieldset>
	</form>
	<br>
	<br>
	<div align="center" >
		<table border="1">
			<tr>
				<th>ID</th>
				<th>书名</th>
				<th>描述</th>
				<th>作者</th>
				<th>出版日期</th>
				<th>类别</th>
				<th>出版社</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach var="b" items="${requestScope.pb.list }">
				<tr>
					<td>${b.id }</td>
					<td>${b.name }</td>
					<td>${b.description }</td>
					<td>${b.author }</td>
					<td>${b.pdate }</td>
					<td>
						<c:forEach var="c" items="${b.categories }">
							${c.name }
						</c:forEach>
					</td>
					<td>${b.publisher }</td>
					<td><a href="${pageContext.request.contextPath}/servlet/BookServlet?method=updateBookUI&id=${b.id}">update</a></td>
					<td><a href="${pageContext.request.contextPath}/servlet/BookServlet?method=delBook&id=${b.id}">del</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
		
		
		totalRecord:${pb.totalrecord } pageSize:<input id="pagesize" type="text" style="width: 30px" onchange="changesize(this.value, ${pb.pagesize})" value="${pb.pagesize }" > 
		totalPage:${pb.totalpage } 
		currentpage:${pb.currentpage } 
		<br>
		<a href="javascript:void(0)" onclick="gotopage(${pb.previouspage})">previous</a>
		<c:forEach var="i" items="${pb.pagebar }">
			<c:if test="${i==pb.currentpage }">
				<span style="color: red">${i }</span>
			</c:if>
			<c:if test="${i!=pb.currentpage }">
				<a href="javascript:void(0)" onclick="gotopage(${i})">${i }</a>
			</c:if>
		</c:forEach>
		<a href="javascript:void(0)" onclick="gotopage(${pb.nextpage})">next</a>
		
		
	</div>
	
	<script type="text/javascript">
		function gotopage(currentpage) {
			if (currentpage > ${pb.totalrecord} || currentpage < 1) {
				alert('wrong input...');
			} else { 
				var pagesize = document.getElementById('pagesize').value;
				window.location.href = '${pageContext.request.contextPath}/servlet/BookServlet?method=${method}&currentpage='+currentpage+'&pagesize='+pagesize+'&name=${name}';
			}
		}
		
		function changesize(newsize, oldsize) {
			if (newsize > ${pb.totalrecord} || newsize < 1) {
				alert('size too big or too small..');
				document.getElementById('pagesize').value = oldvalue;
			} else {
				var currentpage = ${pb.currentpage};
				window.location.href = '${pageContext.request.contextPath}/servlet/BookServlet?method=${method}&currentpage='+currentpage+'&pagesize='+newsize+'&name=${name}';
			}
		}
	</script>
</body>
</html>