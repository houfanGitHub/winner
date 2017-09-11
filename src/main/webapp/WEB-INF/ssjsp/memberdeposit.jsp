<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="winner/webapp/sscss/sushuang.css">
<title>充值管理</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>

<script type="text/javascript">
	$(function(){
		$("#btn4").click(function(){
			document.forms[0].action="/winner/sushuang4/list4";
			document.forms[0].submit();
		});
	});
</script>
<body>
<form action="" method="post">

订单编号：<input type="text" name="serialNumber2" value="${serialNumber2}">&nbsp;&nbsp;
手机号：<input type="text" name="mobile2" value="${mobile2 }">&nbsp;&nbsp;
订单状态：<input type="text" name="status2" value="${status2 }">&nbsp;&nbsp;
富友订单：<input type="text" name="payChannelOrder2" value="${payChannelOrder2 }">&nbsp;&nbsp;
订单时间：<input type="text" name="date1" value="${date1 }">&nbsp;&nbsp;
<input type="text" name="date2" value="${date2 }">&nbsp;&nbsp;
<input type="button" id="btn4" value="查询">
<table width="600" cellspacing="1" border="0" bgcolor="blue">
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

<c:forEach items="listdeposit"  var="listdeposit"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${stat.index+1}</td>
<td>${listdeposit.serialNumber}</td>  <!-- 订单编号  流水号 -->
<td>${listdeposit.member.mobile_Phone}</td>  <!-- 手机号 -->
<td>${listdeposit.amount}</td>   <!-- 订单金额 -->
<td>${listdeposit.status}</td>  <!-- 订单状态-->
<td>${listdeposit.payChannelName}</td>   <!-- 充值渠道 -->
<td>${listdeposit.payChannelOrderNo}</td>  <!-- 富友手机充值订单 -->
<td>${listdeposit.createDate}</td>     <!-- 订单时间 -->
</tr>
</c:forEach>
</table>
</form>

</body>
</html>