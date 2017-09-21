<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="sscss/bootstrap.min.css" rel="stylesheet"/>
 
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  

<script type="text/javascript" src="sushuangjs/bootstrap.min.js"></script>
<script type="text/javascript" src="sushuangjs/jquery.min.js"></script>

 
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
 
<title>体验金付息列表</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>
<!-- <a href="#" onclick="location.href='javascript:history.go(-1);'"></a>   <a href="#" onclick="history.back()"></a>    -->
	<p><h3>&nbsp;&nbsp;▶   体验金付息</h3>
&nbsp;&nbsp;<div style="width:800px;text-align=right"><a href="javascript:history.go(-1);" class="btn btn-primary">返回</a></div>
<!-- <table width="800" bgcolor="blue" cellspacing="1" border="0" > -->
<body>
<form action="" method="post">
<table width="1100" cellspacing="1" border="0" bgcolor="blue" class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr bgcolor="white" align="center">
<td>序号</td>
<td>流水号</td>
<td>投资人手机号</td>
<td>投资人姓名</td>
<td>投资人身份证</td>
<td>投资体验金</td>
<td>还款利息</td>
<td>还款时间</td>
<td>还款状态</td>
<td>操作 </td>
</tr>
<c:forEach items="${listsubjectbb }"  var="lsb" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1 }</td>  <!-- 序号 -->
<td>${lsb.serialNumber }</td>   <!--流水号 -->
<td>${lsb.member.mobile_Phone }</td>  <!-- 投资人手机号 -->
<td>${lsb.member.memberName }</td>  <!-- 投资人姓名 -->
<td>${lsb.member.identity}</td> <!-- 投资人身份证 -->

<!-- 投资体验金 -->
<td>${lsb.amount}</td>

<td>${lsb.interest }%</td> <!-- 还款利息 -->
<td>${lsb.updateDate }</td>  <!-- 还款时间 -->
<!-- 还款状态 -->
<td>
<c:if test="${lsb.ispayment == '0' }"><font color="red">待还款</font></c:if>	
<c:if test="${lsb.ispayment == '1' }"><font color="blue">已还款</font></c:if>		
</td>
<!-- 还款操作 -->						
<td>
<c:if test="${lsb.ispayment == '0' }">
<a href="/winner/sushuang8/updatesubjectbbin8/${lsb.id }/${lsb.subject.id}" 
class="btn btn-primary" type="button" id="btn"> 还款</a></c:if>	
<c:if test="${lsb.ispayment == '1' }"><font color="blue">已还款</font></c:if>		
</td>						
</tr>
</c:forEach>
</table>
</form>
</body>
</html>