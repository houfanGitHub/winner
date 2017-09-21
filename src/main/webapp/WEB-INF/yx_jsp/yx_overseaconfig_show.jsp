<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海外配置</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
 
<body>

<script type="text/javascript">
$(function(){
		$("#ck").click(function(){
			document.forms[0].action="/winner/yx3/list3_3";
			document.forms[0].submit();
		});
			$("#add").click(function(){
				document.forms[0].action="/winner/yx3/toOverseaConfig";
				document.forms[0].submit();
			});
});
</script>
<script type="text/javascript">

</script>


<p><p><p><h4>▶&nbsp;海外配置</h4><hr>
<form action="" method="post" >
<table border="0" class="table table-condensed table-hover">
<tr>
<td colspan="9" align="right"><input type="button" id="add" class="btn btn-primary" value="添加">&nbsp;&nbsp;</td>
</tr>
<tr align="center" height="40" bgcolor="#F5F5F5">
<td>序号</td><td>ID</td><td>标题</td><td>子标题</td><td>状态</td><td>排序值</td><td>图标</td><td>添加时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr align="center">
<td>${stat.index+1}</td>
<td>${t.id}</td>
<td>${t.title}</td>
<td>${t.childTitle }</td>
<td>
<c:if test="${t.status==0}">
未发布</c:if>
<c:if test="${t.status==1}">
募集中</c:if>
<c:if test="${t.status==2}">
回款中</c:if>
<c:if test="${t.status==3}">
还款完成</c:if>
</td>
<td>${t.sortColum}</td>
<td>${t.overseaIcon }</td>
<td>${t.addTime }</td>
<td><input type="button" id="ck" value="查看预约"  class="btn btn-primary">
&nbsp;<input type="button" value="编辑/查看" onclick="editShow(${t.id})" class="btn btn-primary"></td>
</tr>
</c:forEach>
</table>
</form>
<script type="text/javascript">
function editShow(id){
	window.location="/winner/yx3/listEdit/"+id;
}
</script>

</body>
</html>