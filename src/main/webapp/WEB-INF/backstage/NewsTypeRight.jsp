<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/winner/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/winner/ueditor/ueditor.all.min.js"></script>
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<link href="/winner/backstage/show/ButtonColors.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
<title>咨询分类</title>
<style type="text/css">
img{
 width:auto;
 height:auto;
 max-width:100%;
 max-height:100%;
}
.green {
	color: #e8f0de;
	border: solid 1px #538312;
	background: #64991e;
	background: -webkit-gradient(linear, left top, left bottom, from(#7db72f), to(#4e7d0e));
	background: -moz-linear-gradient(top,  #7db72f,  #4e7d0e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#7db72f', endColorstr='#4e7d0e');
}
.green:hover {
	background: #538018;
	background: -webkit-gradient(linear, left top, left bottom, from(#6b9d28), to(#436b0c));
	background: -moz-linear-gradient(top,  #6b9d28,  #436b0c);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#6b9d28', endColorstr='#436b0c');
}
.green:active {
	color: #a9c08c;
	background: -webkit-gradient(linear, left top, left bottom, from(#4e7d0e), to(#7db72f));
	background: -moz-linear-gradient(top,  #4e7d0e,  #7db72f);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#4e7d0e', endColorstr='#7db72f');
}
.red {
	color: #faddde;
	border: solid 1px #980c10;
	background: #d81b21;
	background: -webkit-gradient(linear, left top, left bottom, from(#ed1c24), to(#aa1317));
	background: -moz-linear-gradient(top,  #ed1c24,  #aa1317);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ed1c24', endColorstr='#aa1317');
}
.red:hover {
	background: #b61318;
	background: -webkit-gradient(linear, left top, left bottom, from(#c9151b), to(#a11115));
	background: -moz-linear-gradient(top,  #c9151b,  #a11115);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#c9151b', endColorstr='#a11115');
}
.red:active {
	color: #de898c;
	background: -webkit-gradient(linear, left top, left bottom, from(#aa1317), to(#ed1c24));
	background: -moz-linear-gradient(top,  #aa1317,  #ed1c24);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#aa1317', endColorstr='#ed1c24');
}
.blue {
	color: #d9eef7;
	border: solid 1px #0076a3;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
	background: -moz-linear-gradient(top,  #00adee,  #0078a5);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
}
.blue:hover {
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
	background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
}
.blue:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
	background: -moz-linear-gradient(top,  #0078a5,  #00adee);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
}
</style>
<script type="text/javascript">
function funtwo(){
	document.forms[0].action="/winner/listNewsType";
	document.forms[0].submit();
	}
function update(id){
window.location.href="/winner/getNewsType/"+id;
}
function deletes(tid){
$("#delcfmModel").modal('show');
$("#url").val("/winner/deleteNewsType/"+tid);
}
function urlSubmit(){
var url = $("#url").val();
alert(url);
window.location.href=url
}
</script>
</head>
<body>
<table class="table table-bordered table-hover" style='table-layout:fixed;' border="1">
<th>序号</th><th>名称:</th><th>上级类别</th><th>简介</th><th>排序</th><th>添加时间</th><th>操作</th>
</tr>
<c:forEach items="${list}" var="n"> 
<tr>
<td>${n.id }</td><td >${n.name }</td> <td>${n.supType}</td><td >${n.info}</td><td >${n.sort}</td><td>${n.addTime}</td>
<td><input type="button" value="添加" class="green"  data-toggle="modal" href="#example"  />&nbsp<input type="button" value="编辑" class="blue" onclick="update(${n.id})" /></td>
</tr>
</c:forEach>
</table>
<div class="container">
<div id="example" class="modal fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3><font color="whitesmoke">添加资讯类别</font></h3>
</div>
<div class="modal-body">
<center>
<form action="/winner/saveNewsType" method="post">
<table>
<tr>
<td><font color="whitesmoke">名称:</font></td><td><input type="text"  name="name"  /></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">简介:</font></td><td><input type="text"  name="info"  /></td>
 </tr>
<tr>
<td><font color="whitesmoke">排序:</font><td><input type="number" name="sort" /></td>
</tr>
  <tr>
 <td><font color="whitesmoke">上级类别:</font></td><td><select name="supType" style="width: 176px;height: 26px;">
 <option value="0">根类别</option>
  <option value="1">子类别</option>
 </select></td>
 </tr>
</table>
<div class="modal-footer">
<input type="submit" value="提交"  class="btn btn-success"> <a href="#" class="btn" data-dismiss="modal"><font color="red">关闭</font></a>
</div>
</form>
</center>
</div>
</div>
</div> 
</body>
</html>