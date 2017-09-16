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
 <script type="text/javascript">
 function editshow(id){
	 location="/winner/yx2/listEdit/"+id;
 }
</script>
<table width="100%" border="1" cellspacing="0">
<tr align="center">
<td>序号</td><td>ID</td><td>名称</td><td>类型</td><td>状态</td><td>年化收益</td><td>返佣比例</td><td>开始日期</td><td>结束日期</td>
<td>投资期限</td><td>投资金额</td><td>添加时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="t" varStatus="stat">
<tr align="center">
<td>${stat.index+1}</td>
<td>${t.id}</td>
<td>${t.name}</td>
<td>${t.type}</td>
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

</body>
</html>