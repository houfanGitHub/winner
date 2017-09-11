<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="winner/webapp/sscss/sushuang.css">
<title>绑卡管理</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>

</head>
<script type="text/javascript">
	$(function(){
		$("#btn2").click(function(){
			document.forms[0].action="/winner/sushuang3/list3";
			document.forms[0].submit();
		});
	});
</script>
<body>
<form action="" method="post">
手机号：<input type="text" name="mobile_phone1" value="${mobile_phone1 }">&nbsp;&nbsp;
绑卡姓名：<input type="text" name="member_name1" value="${member_name1 }">&nbsp;&nbsp;
绑卡卡号：<input type="text" name="card_no1 " value="${card_no1  }">&nbsp;&nbsp;
注册时间：<input type="date" name="qdate1" value="${qdate1  }">&nbsp;&nbsp;
<input type="date" name="qdate2" align="left" value="${qdate2 }">&nbsp;&nbsp;
<input type="button" id="btn2" value="查  询">
<table width="600" bgcolor="blue" cellspacing="1" border="0">
<tr align="center" bgcolor="white">
<th>序号</th>
<th>手机号</th>
<th>绑卡人姓名</th>
<th>绑卡身份证</th>
<th>绑卡类型</th>
<th>绑卡卡号</th>
<th>绑卡地址</th>
<th>状态</th>
<th>添加时间</th>
<th>操作</th>
</tr>

<c:forEach items="${listbank }" var="listbank" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1 }</td>
<td>${listbank.member.mobile_Phone }</td>
<td>${listbank.member.memberName}</td>
<td>${listbank.member.identity}</td>
<td>${listbank.type }</td>
<td>${listbank.cardNo }</td>
<td>${listbank.cardaddress }</td>
<td>${listbank.delflag}</td>
<td>${listbank.createDate}</td>

<td></td>

</tr>
</c:forEach>
</table>
</form>
</body>
</html>