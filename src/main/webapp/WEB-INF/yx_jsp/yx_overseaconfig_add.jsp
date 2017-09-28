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
 <script type="text/javascript" charset="utf-8" src="/winner/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/winner/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="/winner/ueditor/ueditor.parse.js"></script>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<body>

<!-- <script type="text/javascript">
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
</script> -->

<p><p><p><h4>▶&nbsp;海外配置</h4><hr>

<form action="/winner/yx3/saveOverseaConfig" method="post" enctype="multipart/form-data">
<table border="0" width="100%">
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td>
<td width="35%"><input type="text" name="name"  class="form-control"placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;子标题:</td>
<td width="35%"><input type="text" name="childTitle" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述:</td>
<td width="35%"><input type="text" name="description" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户群体:</td>
<td width="35%"><input type="text" name="userType" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排序值:</td>
<td width="35%"><input type="text" name="sortColum" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:</td>
<td width="35%">
<select name="status" class="form-control">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>
</td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间:</td>
<td width="35%">
<input type="date" name="startDate" class="form-control" placeholder="请输入文本">
</td><td colspan="2">
</td></tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间:</td>
<td width="35%">
<input type="date" name="endDate" class="form-control" placeholder="请输入文本">
</td><td colspan="2">
</td></tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图标:</td>
<td width="35%">
<input type="file" name="overseaIcon"  class="form-control">
</td><td colspan="2">
</td></tr>
</table>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="productTopic" style="height:250px;"></textarea>
<div align="center"><input type="submit" class="btn btn-primary" id="btn1" value="保存" onclick="return sub();"></div>
</form>






<script type="text/javascript" charset="utf-8">
var ue = UE.getEditor("myUeditor");  
function sub(){    
         if(!UE.getEditor('myUeditor').hasContents()){	// 判断内容是否为空
        	alert("请填写回复内容！");
        	return false;
         }  
	}
</script>
</body>
</html>