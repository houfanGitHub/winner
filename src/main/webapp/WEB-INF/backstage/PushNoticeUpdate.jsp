<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/winner/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/winner/ueditor/ueditor.all.min.js"></script>
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<script type="text/javascript" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
<title>公告修改</title>
<script type="text/javascript">
$(function(){
 $("#example").modal();
 var ue = UE.getEditor('ueditor',{
  initialFrameWidth:1000,  //初始化编辑器宽度,默认1000
  initialFrameHeight:200  //初始化编辑器高度,默认320	
}); 
var c = ${p.pushType};
$("#pushType").val(c);
});
function home(){
	window.location.href="/winner/listPushNotice";
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
<input type="hidden" name="ttime"  id="ttime" value="${p.createDate }"/>
<input type="hidden" name="id"  value="${p.id}" />
<input type="hidden" name="status"  value="${p.status}" />
<table>
<tr>
<td><font color="whitesmoke">标题 : </font><input type="text"  name="title" value="${p.title }" /></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">类别 : </font><select name="pushType" id="pushType" style="width: 177px;"><option value=1>其他</option> <option value=0>公告</option> </select></td>
 </tr>
<tr>
<td><font color="whitesmoke">内容:</font>
</tr>
  <tr>
 <td>
<textarea id="ueditor" type="text/plain" style="width:1024px;height:200px;" name="content" >${p.content }</textarea>
</td>
 </tr>
</table>
<div class="modal-footer">
<input type="submit" value="提交"  class="btn btn-success"> <a href="#" class="btn" data-dismiss="modal" onclick="home();"><font color="red">关闭</font></a>
</div>
</form>
</center>
</div>
</div>
</div>
</body>
</html>