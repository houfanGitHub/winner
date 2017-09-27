<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/winner/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/winner/ueditor/ueditor.all.min.js"></script>
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<script type="text/javascript" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	 $("#example").modal();
	}); 
function home(){
	window.location.href="/winner/listFeedback"
}
</script>
</head>
<body>
<div class="container">
<div id="example" class="modal" >
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3><font color="whitesmoke">添加资讯类别</font></h3>
</div>
<div class="modal-body">
<center>
<form action="/winner/updatePushNotice" method="post">
<table>
<tr>
<td><font color="whitesmoke">姓名: </font></td><td><font color="whitesmoke">${m.memberName}</font></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">电话 : </font><td><font color="whitesmoke">${m.mobile_Phone }</font></td>
 </tr>
<tr>
<td><font color="whitesmoke">用户名:</font></td><td><font color="whitesmoke">${m.name }</font></td>
</tr>
<tr>
<td><font color="whitesmoke">省份证:</font><td><font color="whitesmoke">${m.identity}</font></td>
</tr>
<tr>
<td><font color="whitesmoke">提款密码:</font><td><font color="whitesmoke">${m.withdrawPassword}</font></td>
</tr>
</table>
<div class="modal-footer">
 <a href="#" class="btn" data-dismiss="modal" onclick="home();"><font color="red">关闭</font></a>
</div>
</form>
</center>
</div>
</div>
</div>
</body>
</html>