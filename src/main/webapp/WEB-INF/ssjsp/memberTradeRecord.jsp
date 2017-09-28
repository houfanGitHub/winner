<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="winner/webapp/sscss/sushuang.css">

<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
<title>钱包交易记录</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>

 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
</head>
</head>
<script type="text/javascript">
	$(function(){
		$("#btn9").click(function(){
			document.forms[0].action="/winner/sushuang4/list4";
			document.forms[0].submit();
		});
		
		
		
	/*	$("#cz").click(function(){
			document.forms[0].action="/winner/sushuang4/listcz4";
			document.forms[0].submit();
	})*/
	});
</script>
<body>
<form action="" method="post">
交易记录：<input type="text" name="stat2" value="${stat2}">&nbsp;&nbsp;
交易状态：<input type="text" name="tradeStatus2" value="${tradeStatus2}">&nbsp;&nbsp;
交易时间：<input type="date" name="date1" value="${date1 }">&nbsp;&nbsp;
<input type="date" name="date2" value="${date2 }">&nbsp;&nbsp;
<input  class="btn btn-primary" type="button" id="btn9" value="查询">&nbsp;&nbsp;
<input class="btn btn-primary" type="reset"  id="cz" value="重置"><br><br>
<table width="1100" cellspacing="1" border="0" bgcolor="blue" class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr bgcolor="white" align="center">
<td>序号</td>
<td>交易号</td>
<td>手机号</td>
<td>交易类型</td>
<td>交易状态</td>
<td>交易时间</td>


<td> 操作   </td>
</tr>

<c:forEach items="${listmembertrade}"  var="listmembertrade"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${stat.index+1}</td>
<td>${listmembertrade.tradeNo}</td>  <!-- 交易号 -->
<td>${listmembertrade.member.mobile_Phone}</td>  <!-- 手机号 -->

<!-- 交易类型 -->
<td><c:if test="${listmembertrade.tradeType == '0' }"><font color="red">11111</font></c:if>
	<c:if test="${listmembertrade.tradeType== '1' }"><font color="blue">22222</font></c:if></td>   
<!-- 交易状态 -->
<td><c:if test="${listmembertrade.tradeStatus == '0' }"><font color="red">33333</font></c:if>
	<c:if test="${listmembertrade.tradeStatus== '1' }"><font color="blue">444444</font></c:if></td> 

<td>${listmembertrade.createDate}</td>     <!-- 交易时间 -->

<td>操作</td>

</tr>
</c:forEach>
</table>
</form>

</body>
</html>