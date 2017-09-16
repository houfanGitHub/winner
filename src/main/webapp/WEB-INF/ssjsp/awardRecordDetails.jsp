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
<title>奖励记录</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>

<body>
<!-- <a href="#" onclick="location.href='javascript:history.go(-1);'"></a>   <a href="#" onclick="history.back()"></a>    -->
	<p><h3>&nbsp;&nbsp;▶   奖励记录</h3>
&nbsp;&nbsp;<div style="width:800px;text-align=right"><a href="javascript:history.go(-1);" class="btn btn-primary">返回</a></div>
<!-- <table width="800" bgcolor="blue" cellspacing="1" border="0" > -->

<br><br>
邀请手机号：<font color="red">${awardRecord.member.mobile_Phone}</font>&nbsp;&nbsp;&nbsp;&nbsp;
邀请码:<font color="red">${awardRecord.member.invitationCode}</font>
<table width="1100" bgcolor="blue" cellspacing="1" border="0"  
class="table table-striped table-condensed table-condensed table-hover table-bordered">
       <tr align="center" bgcolor="white">
       <td>编号</td>
       <td>邀请人手机号</td>
       <td>被邀请人手机号</td>
        <td>奖励类型</td>
        <td>奖励金额</td>
        <td>奖励时间</td>
        <td>邀请码</td>
      			
       </tr>
       <tr align="center" bgcolor="white">
       <td>${awardRecord.id }</td>
       <td>${awardRecord.member.mobile_Phone }</td>
       <!-- 被邀请人手机号  AwardRecord表中的被邀请人id  == Member表中的被邀请人id  就取出来 -->
           <td>
           		<c:if test="${awardRecord.byinvitingid == memberbyinvitingname.id }"></c:if>
           		${memberbyinvitingname.mobile_Phone}
           </td>
       <!-- 奖励类型 -->
       <td>
			<c:if test="${awardRecord.type == '0' }"><font color="blue">注册奖励</font></c:if>
			<c:if test="${awardRecord.type == '1' }"><font color="blue">投资奖励</font></c:if>
		</td>
       <td>${awardRecord.amount }</td>
       <td>${awardRecord.addTime }</td>
       <td>${awardRecord.member.invitationCode }</td>
       
       </tr>

</table>

</table>
</body>
</html>