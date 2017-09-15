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
	<p><h3>&nbsp;&nbsp;▶   体现管理账号详情</h3>
&nbsp;&nbsp;<div style="width:800px;text-align=right"><a href="javascript:history.go(-1);" class="btn btn-primary">返回</a></div>
<!-- <table width="800" bgcolor="blue" cellspacing="1" border="0" > -->
	<table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="4" align="center" bgcolor="#AFD9EE">账号信息</td>
				
			</tr>
			<tr height="20" bgcolor="white">
				<td>用户名</td>
				<td>${memberWithdrawRecord.member.name }</td>
				<td>手机号</td>
				<td>${memberWithdrawRecord.member.mobile_Phone }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>真实姓名</td>
				<td>${memberWithdrawRecord.member.memberName }</td>
				<td>身份证</td>
				<td>${memberWithdrawRecord.member.identity }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>邀请码</td>
				<td>${memberWithdrawRecord.member.invitationCode }</td>
				<td>被邀请码</td>
				<td>${memberWithdrawRecord.member.invitedCode }</td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>添加时间</td>
				<td colspan="3">${memberWithdrawRecord.member.createDate }</td>
				
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
				<td>可用余额</td>
				<td> ${listmemberaccount.useableBalance }  </td>
				<td>冻结金额</td>
				<td> ${listmemberaccount.imusealeBalance } </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>累计收益</td>
				<td>${listmemberaccount.totalProfit }  </td>
				<td>投资金额</td>
				<td> ${listmemberaccount.investAmount } </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>红包金额</td>
				<td> ${listmemberaccount.bonusAmount }</td>
				<td>体验金</td>
				<td>${listmemberaccount. bbinAmount } </td>
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
				<td>真实姓名</td>
				<td> ${list.member.memberName}  </td>
				<td>机构名称</td>
				<td> ${list. orgname } </td>
			</tr>
			<tr height="20" bgcolor="white">
				<td>邮寄地址</td>
				<td> ${list.address } </td>
				<td>添加时间</td>
				<td> ${list.createDate } </td>
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
				<td  colspan="10" align="center" bgcolor="#AFD9EE">投资记录</td>
				
			</tr>
			<tr align="center" bgcolor="white">
				<th>序号</th>
              <th>投资编号</th>
                 <th>投资金额</th>
               <th>投资状态</th>
              <th>投资标的名称</th>
              <th>投资收益</th>
               <th>投资时间</th>
           <th>提现开户行地址</th>
            <th>提现状态</th>
                 <th>提现时间</th>
</tr>
			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="#737373"></td>
				
			</tr>
		</table>
		
		


</body>
</html>