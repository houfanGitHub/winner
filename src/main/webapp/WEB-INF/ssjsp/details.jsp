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
 

<title>账号详情</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>
<body>
<!-- <a href="#" onclick="location.href='javascript:history.go(-1);'"></a>   <a href="#" onclick="history.back()"></a>    -->
	<p><h3>&nbsp;&nbsp;▶   账号详情</h3>
&nbsp;&nbsp;<div style="width:800px;text-align=right"><a href="javascript:history.go(-1);" class="btn btn-primary">返回</a></div>
<!-- <table width="800" bgcolor="blue" cellspacing="1" border="0" > -->
	<table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="4" align="center" bgcolor="#AFD9EE">账号信息</td>
				
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">用户名</font></td>
				<td>${member.name }</td>
				<td><font color="black">手机号</font></td>
				<td>${member.mobile_Phone }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">真实姓名</font></td>
				<td>${member.memberName }</td>
				<td><font color="black">身份证</font></td>
				<td>${member.identity }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">邀请码</font></td>
				<td>${member.invitationCode }</td>
				<td><font color="black">被邀请码</font></td>
				<td>${member.invitedCode }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">添加时间</font></td>
				<td colspan="3">${member.createDate }</td>
				
			</tr>
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="#737373"></td>
				
			</tr>
		</table>
		<br>
		<table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="4" align="center" bgcolor="#AFD9EE">资金信息</td>
				
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">真实姓名</font></td>
				<td colspan="3" >${memberAccount.member.memberName }  </td>
				
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">可用余额</font></td>
				<td>${memberAccount.useableBalance }  </td>
				<td><font color="black">冻结金额</font></td>
				<td> ${memberAccount.imusealeBalance} </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">累计收益</font></td>
				<td> ${memberAccount.totalProfit } </td>
				<td><font color="black">投资总额</font></td>
				<td> ${memberAccount.investAmount } </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">红包金额</font></td>
				<td>${memberAccount.bonusAmount } </td>
				<td><font color="black">体验金</font></td>
				<td> ${memberAccount.bbinAmount}</td>
			</tr>
			
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="#737373"></td>
				
			</tr>
		</table>
		<br>
		<table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="4" align="center" bgcolor="#AFD9EE">理财师信息</td>
				
			</tr>
			
			<tr height="20" bgcolor="white">
				<td><font color="black">真实姓名</font></td>
				<td>${financialPlanner.name }  </td>
				<td><font color="black">机构名称</font></td>
				<td> ${financialPlanner.orgname} </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td><font color="black">邮寄地址</font></td>
				<td> ${financialPlanner.address } </td>
				<td><font color="black">添加时间</font></td>
				<td> ${financialPlanner.createDate } </td>
			</tr>
			
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="4" align="center" bgcolor="#737373"></td>
				
			</tr>
		</table>


</body>
</html>