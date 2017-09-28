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

<title>账号管理</title>
<script type="text/javascript" src=/winner/sushuangjs/jquery.min.js></script>

 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>

</head>
<script type="text/javascript">
	$(function(){
		
		$("#btn1").click(function(){
			document.forms[0].action="/winner/sushuang1/list1";
			document.forms[0].submit();
		});
	
		$("#cz").click(function(){
			document.forms[0].action="/winner/sushuang1/listcz1";
			document.forms[0].submit();
	})
	});
	//清空文本矿的值
	//$(document).ready(function(){  
		// $(function(){  
		//   $('input:reset').click(function(){  
		  //   $('.input').val("");  
		  //  });  
		//  });
	//  }); 
</script>
<body>
<form action="" method="post">
用户名：<input type="text"  class="input" name="qname1"  id="qname1" value="${qname1}">&nbsp;&nbsp;
手机号：<input type="text" name="mobile"  value="${mobile}">&nbsp;&nbsp;
姓名：<input type="text" name="qname2" value="${qname2}">&nbsp;&nbsp;
邀请码：<input type="text" name="invit" value="${invit}"><br><br>
注册时间：<input type="date" name="create_date1" value="${create_date1}">&nbsp;&nbsp;
<input type="date" name="create_date2" align="left" value="${create_date2 }">

<input class="btn btn-primary" type="button" id="btn1" value="查  询">&nbsp;&nbsp;
<input class="btn btn-primary" type="reset"   id="cz" value="重置"><br><br>
<!-- <input value="重置" class="btn btn-primary" onClick="" type="reset">  -->

<table class="table table-striped table-condensed table-condensed table-hover table-bordered" 
 width="1100" bgcolor="blue" cellspacing="1" border="0" >
<tr align="center" bgcolor="white">
<td>序号</td>
<td>手机号</td>
<td>用户名</td>
<td>姓名</td>
<td>身份证</td>
<td>邀请码</td>
<td>注册时间</td>
<td>操作</td>
</tr>

<c:forEach items="${listzh }" var="li" >
<tr align="center" bgcolor="white">
<td>${li.id}</td>
<td>${li.mobile_Phone}</td>
<td>${li.name }</td>
<td>${li.memberName }</td>
<td>${li.identity }</td>
<td>${li.invitationCode }</td>
<td>${li.createDate }</td>
<td><a href="/winner/sushuang1/getmemberId/${li.id }" class="btn btn-primary">账号详情</a></td>
</tr>
</c:forEach>
</table>
</form>

</body>
</html>