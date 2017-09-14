<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="winner/webapp/sscss/sushuang.css">

<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
 
<title>充值管理</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>

 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
</head>

<script type="text/javascript">
	$(function(){
		$("#btn4").click(function(){
			document.forms[0].action="/winner/sushuang4/list4";
			document.forms[0].submit();
		});
		
		$("#btn").click(function(){
			document.forms[0].action="/winner/sushuang4/list4";
			document.forms[0].submit();
		});
	});
</script>
<body>
<form action="" method="post">

订单编号：<input type="text" name="serialNumber2" value="${serialNumber2}">&nbsp;&nbsp;
手机号：<input type="text" name="mobile2" value="${mobile2 }">&nbsp;&nbsp;
订单状态：
<select name="status2" id="status2">
 <option value="${status2 }" >${status2 }</option>
<option value="" selected="selected">请选择</option>
<option value="0">充值失败</option>
<option value="1">充值成功</option>
					</select><br><br>
富友订单：<input type="text" name="payChannelName2" value="${payChannelName2 }">&nbsp;&nbsp;
订单时间：<input type="date" name="date1" value="${date1 }">&nbsp;&nbsp;
<input type="date" name="date2" value="${date2 }">&nbsp;&nbsp;
<input  class="btn btn-primary" type="button" id="btn4" value="查询">&nbsp;&nbsp;
<input class="btn btn-primary" type="reset" value="重置">
<table width="1100" cellspacing="1" border="0" bgcolor="blue" class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr bgcolor="white" align="center">
<th>序号</th>
<th>订单编号</th>
<th>手机号</th>
<th>订单金额</th>
<th>订单状态</th>
<th>充值渠道</th>
<th>富友手机充值订单</th>
<th>订单时间</th>

<th> 操作   </th>
</tr>

<c:forEach items="${listdeposit}"  var="listdeposit"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${stat.index+1}</td>
<td>${listdeposit.serialNumber}</td>  <!-- 订单编号  流水号 -->
<td>${listdeposit.member.mobile_Phone}</td>  <!-- 手机号 -->
<td>${listdeposit.amount}</td>   <!-- 订单金额 -->

<td><c:if test="${listdeposit.status == '0' }"><font color="red">充值失败</font></c:if>
	<c:if test="${listdeposit.status== '1' }"><font color="blue">充值成功</font></c:if></td>    <!-- 订单状态-->
<td>${listdeposit.payChannelName}</td>   <!-- 充值渠道 -->
<td>${listdeposit.payChannelOrderNo}</td>  <!-- 富友手机充值订单 -->
<td>${listdeposit.createDate}</td>     <!-- 订单时间 -->
<td><c:if test="${listdeposit.status == '0' }">
<input  class="btn btn-primary" type="button" id="btn" value="更新订单">
</c:if>
	<c:if test="${listdeposit.status == '1' }">
<font color="red">充值成功</font>
</c:if>
	
</td>

</tr>
</c:forEach>
</table>
</form>

</body>
</html>