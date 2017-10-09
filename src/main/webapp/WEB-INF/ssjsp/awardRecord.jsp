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


<script type="text/javascript">
	$(function(){
		$("#btn6").click(function(){
			document.forms[0].action="/winner/sushuang6/list6";
			document.forms[0].submit();
		});
		
		$("#cz").click(function(){
 			//document.forms[0].action="/winner/sushuang1/listcz1";
			//document.forms[0].submit();
			$("input").val('');
	})
	
	});
</script>
<body>
<form action="" method="post">
姓名：<input type="text" name="qmemberName" value="${qmemberName }">&nbsp;&nbsp;
手机号：<input type="text" name="qmobile_Phone" value="${qmobile_Phone }">&nbsp;&nbsp;
奖励类型：<select name="qtype" id="qtype">
  <option value="" >请选择</option>
  <option value="0">注册奖励</option>
   <option value="1">投资奖励</option>
</select>&nbsp;&nbsp;
奖励状态：<select name="qisAward" id="qisAward">
  <option value="">请选择</option>
  <option value="1">已奖励</option>
   <option value="0">未奖励</option>
</select>
<br><br>
邀请码：<input type="text" name="qinvitationCode" value="${qinvitationCode }">&nbsp;&nbsp;
被邀请码：<input type="text" name="qinvitedCode" value="${qinvitedCode }">&nbsp;&nbsp;
<a href="#" class="btn btn-primary" type="button"  id="btn6">查询</a>&nbsp;&nbsp;
<a href="#" class="btn btn-primary" type="reset" id="cz">重置</a>&nbsp;&nbsp;
<!-- <input class="btn btn-primary" type="button" value="查询" id="btn6"> -->

<!-- <input  class="btn btn-primary"  type="reset"  id="cz" value="重置"> -->
<br><br></form>

<table width="1100" bgcolor="blue" cellspacing="1" border="0"  
class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr align="center" bgcolor="white">
<td>编号</td>
<td>手机号</td>
<td>姓名</td>
<td>邀请码</td>
<td>被邀请码</td>
<td>投资金额</td>  <!-- 投资金额 没有算 -->
<td>奖励类型</td>

<td>奖励状态</td>
<td>添加时间</td>

<td>操作</td>
</tr>

<c:forEach items="${listawardrecord}" var="listawardrecord" varStatus="stat">
<tr align="center" bgcolor="white">
<td>${stat.index+1 }</td>
<td>${listawardrecord.member.mobile_Phone}</td>   <!-- 手机号 -->
<td>${listawardrecord.member.memberName }</td> <!-- 姓名 -->
<td>${listawardrecord.member.invitationCode}</td>  <!-- 邀请码 -->
<td>${listawardrecord.member.invitedCode}</td>       <!-- 被邀请码-->
<td>￥${listawardrecord.amount}元</td>
  

    <!-- 奖励类型 -->  
<td><c:if test="${listawardrecord.type  == '0' }"><font color="blue">注册奖励</font></c:if>
	<c:if test="${listawardrecord.type == '1' }"><font color="green">投资奖励</font></c:if>
	<c:if test="${listawardrecord.type != '1'&& listawardrecord.type != '0' }"><font color="green">没有奖励</font></c:if>
	</td>
	 <!-- 奖励状态 -->
	<td><c:if test="${listawardrecord.isAward  == '0' }"><font color="red">未奖励</font></c:if>
	<c:if test="${listawardrecord.isAward == '1' }"><font color="green">已奖励</font></c:if>
	</td>
					
<td>${listawardrecord.addTime }</td>  <!-- 添加时间 -->
<!--  <td><a href="#" class="btn btn-primary" type="button">操作</a></td>  -->
<td>
<c:if test="${listawardrecord.isAward==0 }"><font color="red">不能奖励</font></c:if>				
<c:if test="${listawardrecord.isAward==1 }"><font color="blue">已奖励</font>&nbsp;&nbsp;
<a href="/winner/sushuang6/awardrecord6/${listawardrecord.member.id}/${listawardrecord.byinvitingid}" class="btn btn-primary" type="button">奖励记录</a></c:if>
<c:if test="${listawardrecord.type != '1'&& listawardrecord.type != '0' }"><font color="red">没有奖励</font></c:if>
</td>

</tr>
</c:forEach>
</table>

</body>
</html>