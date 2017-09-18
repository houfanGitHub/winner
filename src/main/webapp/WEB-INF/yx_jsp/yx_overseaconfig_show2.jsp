<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海外配置预约记录</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
 
<body>

<p><p><p><h4>▶&nbsp;海外配置预约记录</h4><hr>
<table border="1" cellspacing="0" width="100%">
<tr align="center" height="40" bgcolor="#F5F5F5">
<td>序号</td><td>姓名</td><td>联系电话</td><td>地址</td><td>预约时间</td>
</tr>

<c:forEach items="${list}" var="t2" varStatus="stat">
<tr align="center" height="40">
<td>${stat.index+1}</td>
 <td>${t2.name}</td>
<td>${t2.phone}</td>
<td>${t2.addr}</td>
<td>${t2.createDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>