<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>固收类显示页面</title>
 <link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
  <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
 
<body>
 <script type="text/javascript">
 $(function(){
$("#cx").click(function(){
		document.forms[0].action="/winner/yx/list";
		document.forms[0].submit();
	});
$("#btn1").click(function(){//跳转到添加方法
	document.forms[0].action="/winner/yx/toSubject";
	document.forms[0].submit();
});

$("#cz").click(function(){//重置
	/* document.forms[0].action="/winner/yx/listcz";
	document.forms[0].submit(); */
	$("#qname").val("");
});

 });
</script>

<script type="text/javascript">
function showtz(id){
	window.location="/winner/yx/listtouzi/"+id;
}
function editshow(id){
	window.location="/winner/yx/listEdit/"+id;
	}
</script>

<p><p><p><h4>▶&nbsp;固收类/P2P</h4>

<form action="">
<table border="0" class="table table-condensed table-hover">
<tr>
<td colspan="2" align="center"><label>名称</label></td><td width="200px;"><input type="text" id="qname" name="qname" value="${qname}" class="form-control" placeholder="名称"></td><td></td>
<td align="center"><label>状态</label></td>
<td colspan="2">
<select class="form-control" name="qstatus" id="qstatus"><option value="">全部</option>
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select>
</td>
<td align="center"><label>类型:</label></td>
<td colspan="2" align="center">
<select class="form-control" name="qtype">
<option value="">全部</option>
<option value="0">固收类</option>
<option value="1">P2P车贷</option>
<option value="2">P2P房贷</option>
</select>
</td>
<td></td>  
<td align="center">
 <input type="button" id="cx" class="btn btn-primary"  value="查询"></td><td align="center"><input type="button" class="btn btn-primary" id="cz"  value="重置"/></td>
<td>
<!-- <a href="#" class="btn btn-primary" type="button"  id="cx">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" class="btn btn-primary" type="reset" id="cz">重置</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->

<input type="button" class="btn btn-primary" id="btn1" value="新增"/>  
</td>
</tr>
</table>
</form>
<table border="0" class="table table-condensed table-hover">
<tr  align="center">
<td>序号</td><td>ID</td><td>合同编号</td><td>类型</td><td>名称</td><td>标的总金额</td><td>已投总金额</td><td>投资期限</td><td>起投金额</td><td>年化收益</td><td>状态</td><td>可使用体验金</td><td>添加时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr class="sucess"  align="center">
<td>${stat.index+1}</td>
<td>${t.id}</td>
<td>${t.serialNo}</td>
<td>
<c:if test="${t.type==0}">
固收类
</c:if>
<c:if test="${t.type==1}">
P2P车贷
</c:if>
<c:if test="${t.type==2}">
P2P房贷
</c:if>
</td>

<td>${t.name}</td>
<td>${t.amount*t.bought}</td>
<td> ${t.floorAmount*t.bought} </td><!-- 已投总金额 -->
<td>${t.period }</td>
<td>${t.floorAmount }</td><!-- 起投金额 -->
<td>${(t.floorAmount*t.yearRate/365)*t.period}</td><!-- 收益=本金*年利率/365*天数 -->
<td>
<c:if test="${t.status==0}">未发布</c:if>
<c:if test="${t.status==1}">募集中</c:if>
<c:if test="${t.status==2}">回款中</c:if>
<c:if test="${t.status==3}">还款完成</c:if>
</td><!-- 状态 -->
<td>
<c:if test="${t.experStatus==0}">否</c:if>
<c:if test="${t.experStatus==1}">是</c:if>
</td>
<td>${t.createDate }</td>
<td>
<input type="button"  class="btn btn-primary" value="编辑/查看" onclick="editshow(${t.id})"/><br>
<input type="button" class="btn btn-primary" value="查看投资" onclick="showtz(${t.id })"/>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>
