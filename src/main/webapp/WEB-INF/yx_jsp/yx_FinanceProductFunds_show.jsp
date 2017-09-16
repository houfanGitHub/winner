<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<body>
<!-- 修改前的查询 -->
 <script type="text/javascript">
 function editshow(id){
	 location="/winner/yx2/listEdit/"+id;
 }
</script>

 <script type="text/javascript">
 $(function(){
$("#cx").click(function(){
		document.forms[0].action="/winner/yx2/list2";
		document.forms[0].submit();
	});
 });
</script>




<form action="" method="post">

<table width="100%" border="0"  class="table table-condensed table-hover">
<tr>
<td colspan="2" align="center">
<label>名称:</label>
</td><td colspan="2"><input type="text" name="qname" value="${qname}"  class="form-control" placeholder="名称"/></td>
<td colspan="2"><label>状态:</label></td>
<td colspan="2" align="center">
<select class="form-control" name="qstatus" id="qstatus"><option value="">全部</option>
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>
</td>
<td colspan="2" align="center"><label>类别:</label></td>
<td colspan="2" align="center">
<select class="form-control" name="qtype">
<option value="">全部</option>
<option value="SIMU">私募</option>
<option value="GUQUAN">股权</option>
</select>
</td>
<td>
<input type="button" class="btn btn-primary" id="cx"  value="搜索"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-primary" id="btn1" value="新增"/>
</td>
</tr>

<tr align="center">
<td>序号</td><td>ID</td><td>名称</td><td>类型</td><td>状态</td><td>年化收益</td><td>返佣比例</td><td>开始日期</td><td>结束日期</td>
<td>投资期限</td><td>投资金额</td><td>添加时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr align="center">
<td>${stat.index+1}</td>
<td>${t.id}</td>
<td>${t.name}</td>
<td>
<c:if test="${t.type=='SIMU'}">私募类</c:if>
<c:if test="${t.type=='GUQUAN'}">股权类</c:if>
</td>
<td>${t.status}</td>
<td>${t.yearRate}</td>
<td>${t.ratio}</td>
<td>${t.startDate}</td>
<td>${t.endDate}</td>
<td>${t.period}</td>
<td>${t.floorAmount}</td>
<td>${t.createDate }</td>
<td><input type="button"  class="btn btn-primary" value="未签署人" id="weiqianshu"/>
<input type="button"  class="btn btn-primary" value="编辑/查看" onclick="editshow(${t.id})"/>
</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>