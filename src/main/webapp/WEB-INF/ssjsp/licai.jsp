<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理财师审核</title>
</head>
<body>
<form action="" method="post">
<table width="1100" cellspacing="1" border="0" bgcolor="blue">
<tr bgcolor="white" align="center">
<td>序号</td>
<td>手机号</td>
<td>真实姓名</td>
<td>机构名称</td>
<td>我的名片</td>
<td>邮寄地址</td>
<td>状态</td>
<td>注册时间</td>
<td> 操作  </td>
</tr>

<c:forEach items="${listfinap }"  var="lifp"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${lifp.id}</td>
<td>${lifp.member.mobile_Phone }</td>  
<td>${lifp.member.name }</td>
<td>${lifp.orgname }</td>
<td>${lifp.mycard }</td>
<td>${lifp.address }</td>
<td>${lifp.status }</td>
<td>${lifp.createDate }</td>
<td></td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>