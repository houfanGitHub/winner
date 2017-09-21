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
				<td width="15%"><font color="black">用户名</font></td>
				<td width="35%">${member.name }</td>
				<td width="15%"><font color="black">手机号</font></td>
				<td width="35%">${member.mobile_Phone }</td>
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
		<br>
		<table width="100%" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
			<tr height="20">
				<td  colspan="10" align="center" bgcolor="#AFD9EE">投资记录</td>
				
			</tr>
			<tr align="center" bgcolor="white">
				<td><font color="black">序号</font></td>
              <td><font color="black">投资编号</font></td>
                 <td><font color="black">投资金额</font></td>
               <td><font color="black">投资状态</font></td>
              <td><font color="black">投资标的名称</font></td>
              <td><font color="black">投资收益</font></td>
               <td><font color="black">投资时间</font></td>
           
           </tr>
           <c:forEach items="${listspr}" var="listspr" varStatus="stat">
           <tr align="center" bgcolor="white">
             <td><font color="black">${stat.index+1 }</font></td>
			<td><font color="black">${listspr.id }</font></td>
			<td><font color="black">${listspr.amount }</font></td>
			<td><font color="black">
			
			<c:if test="${listspr.subject.status == '0'}"><font color="red">未发布</font></c:if>
      <c:if test="${listspr.subject.status == '1'}"><font color="blue">募集中</font></c:if>
       <c:if test="${llistspr.subject.status == '2'}"><font color="black">募集结束</font></c:if>
       </font></td>
			<td><font color="black">${listspr.subject.name }</font></td>
		
	
		<td>11111</td>
		 <td><font color="black">${listspr.createDate}</font></td>
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
				<td  colspan="10" align="center" bgcolor="#AFD9EE">充值记录</td>
				
			</tr>
			<tr align="center" bgcolor="white">
				<td><font color="black">序号</font></td>
              <td><font color="black">充值编号</font></td>
                 <td><font color="black">充值金额</font></td>
               <td><font color="black">充值状态</font></td>
              <td><font color="black">充值渠道</font></td>
              <td><font color="black">充值渠道编号</font></td>
               <td><font color="black">充值时间</font></td>
           
           </tr>
           <c:forEach items="${memberDepositRecord}" var="depositre" varStatus="stat">
           <tr align="center" bgcolor="white">
           <td> ${stat.index+1 } </td>
           
           <td> ${depositre.id } </td>
           <td> ${depositre.amount } </td>
           <td><!-- 充值状态 -->
            <c:if test="${depositre.status=='0' }"><font color="red">充值失败</font></c:if>
            <c:if test="${depositre.status== '1'}"><font color="green">充值成功</font></c:if>
           </td>
           <td> ${depositre.payChannelName }  </td>
           <td> ${depositre.payChannelOrderNo }  </td>
           <td> ${depositre.createDate }  </td>
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
				<td  colspan="10" align="center" bgcolor="#AFD9EE">钱包交易记录</td>
				
			</tr>
			<tr align="center" bgcolor="white">
				<td><font color="black">序号</font></td>
              <td><font color="black">交易编号</font></td>
                 <td><font color="black">交易金额</font></td>
               <td><font color="black">交易状态</font></td>
              <td><font color="black">交易分类</font></td>
              <td><font color="black">交易名称</font></td>
               <td><font color="black">交易时间</font></td>
           
           </tr>
           <c:forEach items="${memberTradeRecord }" var="tradere" varStatus="stat">
           <tr align="center" bgcolor="white">
           <td>${stat.index+1 }  </td>
           <td> ${tradere.id } </td>
           <td> ${tradere.amount }  </td>
           <td> ${tradere.tradeStatus }  </td>
           <td> ${tradere.tradeType }  </td>
           <td> ${tradere.tradeName }  </td>
           <td> ${tradere.fundFlow}  </td>
           </tr>
           </c:forEach>


			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="white"></td>
				
			</tr>
			<tr height="20" >
				<td  colspan="10" align="center" bgcolor="#737373"></td>
				
			</tr>
		</table>
		
		


</body>
</html>