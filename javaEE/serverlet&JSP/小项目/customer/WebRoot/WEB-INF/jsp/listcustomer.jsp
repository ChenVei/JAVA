<%@page import="cn.domain.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table border="1" style="text-align:center">
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>性别</td>
			<td>birthday</td>
			<td>cellphone</td>
			<td>email</td>
			<td>preference</td>
			<td>type</td>
			<td>description</td>
			<td>operation</td>
		</tr>
		
		<c:forEach var="i" items="${requestScope.pagebean.list }">
			<tr>
				<td>${i.id }</td>
				<td>${i.name }</td>
				<td>${i.gender }</td>
				<td>${i.birthday }</td>
				<td>${i.cellphone }</td>
				<td>${i.email }</td>
				<td>${i.preference }</td>
				<td>${i.type }</td>
				<td>${i.description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/EditCustomerServlet?id=${i.id}">update</a>
					<a href="javascript:void(0)" onclick="del(${i.id})">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	totalRecord:${pagebean.totalrecord }&nbsp;&nbsp;pageSize:<input type="text" id="pagesize" value="${pagebean.pagesize }" onchange="changesize(this.value, ${pagebean.pagesize })" style="width:30px">&nbsp;&nbsp;totalPage:${pagebean.totalpage }&nbsp;&nbsp;currentPage:${pagebean.currentpage }
	<br />
	<a href="javascript:void(0)" onclick="gotopage(${pagebean.previouspage})">previousPage</a>
	<c:forEach var="i" items="${pagebean.pagebar }">
		<c:if test="${i==pagebean.currentpage }">
			<span style="color:red">${i }</span>
		</c:if>
		<c:if test="${i!=pagebean.currentpage }">
			<a href="javascript:void(0)" onclick="gotopage(${i})">${i }</a>
		</c:if>
	</c:forEach>
	<a href="javascript:void(0)" onclick="gotopage(${pagebean.nextpage})">nextPage</a>
	<input type="text" id="pagenum" style="width:30px" value="${pagebean.currentpage}" >
	<input type="button" value="go" onclick="gotopage(document.getElementById('pagenum').value)">
	</div>
	<script type="text/javascript">
		function del(id) {
			if (window.confirm("Are you sure?")) {
				window.location.href='${pageContext.request.contextPath }/servlet/DelCustomerServlet?id='+id;
			}
		}
		function gotopage(currentpage) {
			if (currentpage<1||currentpage>${pagebean.totalpage}) {
				alert("wrong input!");
				document.getElementById("pagenum").value="";
			} else {
				var pagesize = document.getElementById("pagesize").value;
				window.location.href='${pageContext.request.contextPath}/servlet/ListCustomerServlet?currentpage='+currentpage+'&pagesize='+pagesize;
			}
		}
		function changesize(newsize, oldsize) {
			if (newsize > ${pagebean.totalpage} || newsize < 0) {
				alert('wrong input');
				document.getElementById('pagesize').value = oldsize;
			} else {
				window.location.href='${pageContext.request.contextPath}/servlet/ListCustomerServlet?currentpage=${pagebean.currentpage}&pagesize='+newsize;
			}
		}
	</script>
</body>
</html>