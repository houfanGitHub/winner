<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="winner/webapp/sscss/sushuang.css">

<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
 
<title>邀请奖励</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>


 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
</head>
<body>
<form action="" method="post">
<table width="1100" bgcolor="blue" cellspacing="1" border="0"  
class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr align="center" bgcolor="white">
<th>编号</th>
<th>手机号</th>
<th>姓名</th>
<th>邀请码</th>
<th>被邀请码</th>
<th>奖励金额</th>
<th>是否已注册奖励</th>
<th>是否已投资奖励</th>
<th>添加时间</th>

<td>操作</td>
</tr>

<c:forEach items="${listawardrecord}" var="listawardrecord" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1 }</td>
<td>${listawardrecord.member.mobile_Phone }</td>   <!-- 手机号 -->
<td>${listawardrecord.member.memberName }</td> <!-- 姓名 -->
<td>${listawardrecord.member.invitationCode }</td>  <!-- 邀请码 -->
<td>${listawardrecord.member.invitedCode}</td>       <!-- 被邀请码-->
<td>${listawardrecord.amount }</td>    <!-- 奖励金额-->


    <!-- 奖励状态 -->  
<td><c:if test="${listawardrecord.type  == '0' }"><font color="red">注册奖励</font></c:if>
	<c:if test="${listwith.status == '1' }"><font color="green">投资奖励</font></c:if>

	</td>
<td>${listawardrecord.createDate }</td>  <!-- 添加时间 -->
<td><a href="#" class="btn btn-primary" type="button">操作</a></td>
<td>操作</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>