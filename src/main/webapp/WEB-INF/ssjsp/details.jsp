<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="sscss/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="sushuangjs/bootstrap.min.js"></script>
<script type="text/javascript" src="sushuangjs/jquery.min.js"></script>
<title>账号详情</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>
<body>
<!-- <a href="#" onclick="location.href='javascript:history.go(-1);'"></a>   <a href="#" onclick="history.back()"></a>    -->
	<div class=container>
<div style="width:800px;text-align=right"><a href="javascript:history.go(-1);">返回</a></div>
<!-- <table width="800" bgcolor="blue" cellspacing="1" border="0" > -->
	<table class="table table-striped table-condensed" >
<tr align="center" bgcolor="white">

<th class="danger">用户名</th>
<th class="danger">手机号<th>
<th class="danger">真实姓名</th>
<th class="danger">身份证</th>
<th class="danger">邀请码</th>
<th class="danger">被邀请码</th>
<th class="danger">注册时间</th>

</tr>

<c:forEach items="${listzh }" var="li" varStatus="ststa">
<align="center" bgcolor="white" class="info">
<td>${li.name }</td>
<td>${li.mobile_Phone}</td>
<td>${li.memberName }</td>
<td>${li.identity }</td>
<td>${li.invitationCode }</td>  <!--邀请码  -->
<td>${li.invitedCode }</td>  <!-- 被邀请码 -->
<td>${li.createDate }</td>

</tr>
</c:forEach>
</table>

</div>
</body>
</html>