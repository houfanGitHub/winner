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
	<p><h3>&nbsp;&nbsp;▶   提现管理账号详情</h3>
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
				<td width="15%" ><font color="black">真实姓名</font></td>
				<td colspan="3" >${memberAccount.member.memberName }  </td>
				
			</tr>
			<tr height="20" bgcolor="white">
				<td width="10%"><font color="black">可用余额</font></td>
				<td width="40%" >${memberAccount.useableBalance }  </td>
				<td width="10%"><font color="black">冻结金额</font></td>
				<td width="40%"> ${memberAccount.imusealeBalance} </td>
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
				<td width="10%"><font color="black">真实姓名</font></td>
				<td width="40%">${financialPlanner.name }  </td>
				<td width="10%"><font color="black">机构名称</font></td>
				<td width="40%"> ${financialPlanner.orgname} </td>
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
		<br><table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="10" align="center" bgcolor="#AFD9EE">提现记录</td>
				
			</tr>
			<tr align="center" bgcolor="white">
				<td><font color="black">序号</font></td>
              <td><font color="black">提现编号</font></td>
                 <td><font color="black">提现金额</font></td>
               <td><font color="black">提现状态</font></td>
              <td><font color="black">提现银行</font></td>
              <td><font color="black">提现卡号</font></td>
               <td><font color="black">提现时间</font></td>
           
           </tr>
           <c:forEach items="${memberWithdrawRecord}" var="withdrawr" varStatus="stat">
           <tr align="center" bgcolor="white">
           <td>${stat.index+1 }  </td>
           <td> ${withdrawr.id} </td>
           <td> ${withdrawr.amount} </td>
           
           <td>  <!-- 提现状态 -->
           <c:if test="${withdrawr.status=='0' }"><font color="red">待审核</font></c:if>
            <c:if test="${withdrawr.status== '1'}"><font color="green">已打款</font></c:if>
             <c:if test="${withdrawr.status=='2' }"><font color="blue">打款中</font></c:if>
              <c:if test="${withdrawr.status=='3'}"><font color="red">打款失败</font></c:if>
           </td>
           
           <td> ${withdrawr.bankName} </td>
           <td> ${withdrawr.bankCard} </td>
           <td> ${withdrawr.createDate} </td>
           </tr>
           </c:forEach>


			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="#737373"></td>
				
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