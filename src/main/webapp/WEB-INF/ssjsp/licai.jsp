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
<th>序号</th>
<th>手机号</th>
<th>真实姓名</th>
<th>机构名称</th>
<th>我的名片</th>
<th>邮寄地址</th>
<th>状态</th>
<th>注册时间</th>
<th> 操作  </th>
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