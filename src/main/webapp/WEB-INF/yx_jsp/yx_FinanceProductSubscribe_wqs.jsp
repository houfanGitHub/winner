<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约记录</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css">  
</head>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<body>
<script type="text/javascript">
 $(function(){
$("#qssb").click(function(){
		document.forms[0].action="/winner/yx2/list";
		document.forms[0].submit();
	});
	});
 </script>



<table border="1" width="100%">
<tr align="center">
<td>序号</td><td>姓名</td><td>联系电话</td><td>地址</td><td>状态</td><td>签署拍照图</td><td>查看文档</td><td>预约时间</td><td>操作</td>
</tr>
<c:forEach items="${fe}" var="f" varStatus="stat">
<tr align="center"><td>${stat.index+1}</td>
<td>${f.name}</td>
<td>${f.phone}</td>
<td>${f.addr}</td>
<td><c:if test="${f.status==2}">
<font color="red">审核中</font>
</c:if>
<c:if test="${f.status==0}">
<font color="red">签署拍照</font>
</c:if>
<c:if test="${f.status==1}">
<font color="green">已签署</font>
</c:if>
<c:if test="${f.status==3}">
<font color="red">签署失败</font>
</c:if>
</td><!-- 是否处理(0:签署拍照|1:已签约|2:审核中|3:签署失败)' -->
<td>
<c:if test="${!empty f.signedPhotos}">
<a href="/winner/yx2/listchakan/${f.id}">查看</a></c:if>
<c:if test="${empty f.signedPhotos}">
---
</c:if></td>
<td><%-- ${f.comment} --%>
<c:if test="${!empty f.comment}"><a href="/winner/yx2/listchakan/${f.id}">私募合作|</a><a href="" onclick="fengxian()">风险提示书</a></c:if>
<c:if test="${empty f.comment}">---</c:if>
</td>
<td>
${f.startDate}</td>
<td>
<c:if test="${f.status==2}">
<a href="/winner/yx2/selectsign/${f.id}"  class="btn btn-primary">签署</a>&nbsp;
<a href="/winner/yx2/updatecssb/${f.id}/${id2}" onclick="return confirm('确认签署失败吗?')"  class="btn btn-primary">签署失败</a>
</c:if>
<c:if test="${f.status==0}">
<input type="button" value="签署拍照" class="btn btn-primary disabled" readonly="readonly">&nbsp;
</c:if>
<c:if test="${f.status==1}">
<input type="button" value="已签署" class="btn btn-primary disabled" readonly="readonly">&nbsp;
</c:if>
<c:if test="${f.status==3}">
<input type="button" value="签署失败"  class="btn btn-primary disabled">&nbsp;
</c:if>
</td>

</c:forEach>
</table>
</body>
<script type="text/javascript">
function fengxian(){
	window.parent.document.location="/winner/itemweb/index";
}
	

</script>

</html>