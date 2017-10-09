<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%> 
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
 
<title>付息计划</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>
</head>

<script type="text/javascript">
	$(function(){
		$("#btn8").click(function(){
			document.forms[0].action="/winner/sushuang8/list8";
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
名称：<input type="text" name="sname" value="${sname}">&nbsp;&nbsp;&nbsp;&nbsp;
状态：<select name="sstatus" id="sstatus">
<!--  <option value="${sstatus }">${sstatus }</option>  -->
<option value="">全部</option>
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">募集结束</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;

类型：<select name="stype" id="stype">
<option value="">全部</option>
<option value="0">固收类</option>
<option value="1">P2P房贷</option>
<option value="2">P2P车贷</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" class="btn btn-primary" type="button"  id="btn8">查询</a>&nbsp;&nbsp;
<a href="#" class="btn btn-primary" type="reset" id="cz">重置</a>&nbsp;&nbsp;<br><br>
<!-- <input  class="btn btn-primary" type="button" id="btn8" value="查询">&nbsp;&nbsp; -->
<!-- <input class="btn btn-primary" type="reset"  id="cz"value="重置"><br><br> -->
</form>
<table width="1100" cellspacing="1" border="0" bgcolor="blue" class="table table-striped table-condensed table-condensed table-hover table-bordered">
<tr bgcolor="white" align="center">
<td>序号</td>
<td>合同编号</td>
<td>标的类别</td>
<td>标的名称</td>
<td>标的总金额</td>
<td>已投金额</td>
<td>已投人数</td>
<td>标的期限</td>
<td>年化收益</td>
<td>标的状态</td>
<td>可体验金购买</td>

<td> 操作   </td>
</tr>

<c:forEach items="${listsubject}"  var="listsubject"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${stat.index+1}</td>
<td>${listsubject.serialNo}</td>  <!-- 合同编号  -->

 <!-- 标的类别 -->
 <td>
 <c:if test="${listsubject.type == '0'}" ><font color="blue">固收类</font></c:if>
  <c:if test="${listsubject.type == '1'}" ><font color="blue">P2P房贷</font></c:if>
   <c:if test="${listsubject.type == '2'}" ><font color="blue">P2P车贷</font></c:if>
 </td>
<td>${listsubject.name}</td>   <!--标的名称 -->
<td>￥${listsubject.amount*listsubject.bought}元</td>  <!-- 标的总金额 -->

<!-- 已投金额 -->
<td> 
<c:forEach items="${listsumsubject}" var="listsum">
	<c:if test="${listsubject.id==listsum.subject_id }">
	￥${listsum.sumamount}元
	<!--￥<fmt:formatNumber type="number" value="${listsum.sumamount}"  maxFractionDigits="2"></fmt:formatNumber>元</font>-->
	</c:if>
	
	</c:forEach></td> 
							
  <!--<td>￥${listsubject.floorAmount}元</td>   <!-- 已投金额 -->  
<td>${listsubject.bought}人</td>  <!-- 已投人数  已购人数 -->
<td>${listsubject.period}天</td> <!-- 标的期限    标的周期 -->

 <!-- <td>${listsubject.yearRate}%</td>     <!-- 年化收益 -->
<td><fmt:formatNumber type="number" value="${listsubject.yearRate}"  maxFractionDigits="2"></fmt:formatNumber></font>%</td>
    <!-- 标的状态-->
    <td>
    <c:if test="${listsubject.status == '0'}"><font color="red">未发布</font></c:if>
      <c:if test="${listsubject.status == '1'}"><font color="blue">募集中</font></c:if>
       <c:if test="${listsubject.status == '2'}"><font color="black">募集结束</font></c:if>
    </td>

 <!-- 可体验金额购买-->
<td>
<c:if test="${listsubject.experStatus == '0' }"><font color="red">否</font></c:if>
	<c:if test="${listsubject.experStatus== '1' }"><font color="blue">是</font></c:if></td>   

<td><c:if test="${listsubject.experStatus == '0' }">
<a href="/winner/sushuang8/listsubjectpurchaserecord8/${listsubject.id}" class="btn btn-primary" type="button"  >付息列表</a>
</c:if>
	<c:if test="${listsubject.experStatus == '1' }">
	<a href="/winner/sushuang8/listsubjectbbin8/${listsubject.id}" class="btn btn-primary" type="button" >体验金付息</a>
<a href="/winner/sushuang8/listsubjectpurchaserecord8/${listsubject.id}" class="btn btn-primary" type="button"  >付息列表</a>		
</c:if>
</td>

</tr>
</c:forEach>
</table>

</body>
</html>