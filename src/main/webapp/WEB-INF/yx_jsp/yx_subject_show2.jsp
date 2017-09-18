<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看投资</title>
 <link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<body>
<table border="1" cellspacing="0" class="table table-condensed table-hover">
<tr height="40" align="center">
<td>序号</td><td>流水号</td><td>会员姓名</td><td>购买金额</td><td>结算利息</td><td>是否还款</td><td>购买时间</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr height="40" align="center">
<td>${stat.index+1}</td>
<td>${t.subject.serialNumber}</td>
<td>${t.member.memberName}</td>
<td>${t.amount}</td>
<td>${t.interest }</td>
<td><c:if test="${t.ispayment==0}">
否
</c:if>
<c:if test="${t.ispayment==1}">
是
</c:if>
</td>
<td>${t.createDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>