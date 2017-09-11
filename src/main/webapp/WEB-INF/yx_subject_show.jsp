<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>固收类显示页面</title>
	<link rel="stylesheet" href="/winner/backstage/show/yx_jsp/bootstrap.min.css" />
</head>
<body>

<table border="0" cellspacing="1" bgcolor="blue" width="100%">
<tr align="center" bgcolor="white">
<td>序号</td><td>ID</td><td>合同编号</td><td>类型</td><td>名称</td><td>标的总金额</td><td>已投总金额</td><td>投资期限</td><td>起投金额</td><td>年化收益</td><td>状态</td><td>可使用体验金</td><td>添加时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1}</td>
<td>${t.name}</td>
</tr>
</c:forEach>
</table>
</body>
</html>