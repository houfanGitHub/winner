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

<title>理财师审核</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>


 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script> 
</head>


<script type="text/javascript">
	$(function(){
		$("#btn2").click(function(){
			document.forms[0].action="/winner/sushuang2/list2";
			document.forms[0].submit();
		});
		
		$("#cz").click(function(){
			document.forms[0].action="/winner/sushuang2/listcz2";
			document.forms[0].submit();
	})
	
	});
</script>
<body>
<form action="" method="post">
手机号：<input type="text" name="amobile_Phone" value="${amobile_Phone}">&nbsp;&nbsp;
真实姓名：<input type="text" name="amemberName" value="${amemberName}">&nbsp;&nbsp;
状态：<select  name="astatu" id="astatu">
<option value="" selected="selected">请选择</option>
<option value="0">未审核</option>
<option value="1">认证成功</option>
</select><br><br>
注册时间：<input type="date" name="adate1" value="${adate1 }">&nbsp;&nbsp;
<input type="date" name="adate2" value="${adate2 }">
<input class="btn btn-primary" type="button" value="查询" id="btn2">&nbsp;&nbsp;

<input  class="btn btn-primary"  type="reset" id="cz"  value="重置">
<br><br>
<table  width="1100" bgcolor="blue" cellspacing="1" border="0" class="table table-bordered">
<tr bgcolor="white" align="center">
<td>序号</td>
<td>手机号</td>
<td>真实姓名</td>
<td>机构名称</td>
<td>我的名片</td>
<td>邮寄地址</td>
<td>状态</td>
<td>注册时间</td>
<td> 操作  </td>
</tr>

<c:forEach items="${listfinap }"  var="lifp"  varStatus="stat">

<tr bgcolor="white" align="center">
<td>${lifp.id}</td>
<td>${lifp.member.mobile_Phone }</td>  
<td>${lifp.member.name }</td>
<td>${lifp.orgname }</td>
<td>${lifp.mycard }</td>
<td>${lifp.address }</td>
<!-- 状态 -->
<td>
	<c:if test="${lifp.status == '0' }"><font color="red">未审核</font></c:if>
	<c:if test="${lifp.status == '1' }"><font color="blue">认证成功</font></c:if>
</td>
<td>${lifp.createDate }</td>
<td>
<c:if test="${lifp.status == '0' }"><a href="#" class="btn btn-primary" type="button">未审核</a></c:if>
	<c:if test="${lifp.status == '1' }"><font color="blue">已认证</font></c:if>
</td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>