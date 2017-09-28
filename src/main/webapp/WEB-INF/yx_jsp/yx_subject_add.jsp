<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息详细表</title>
<link rel="stylesheet" href="/winner/files/layer.css" id="layui_layer_skinlayercss"> 
 <link rel="stylesheet" href="/winner/backstage/show/bootstrap.min.css"> 
    <style type="text/css">
        div{
            width:100%;
        }
        span: #preview{
            height:50px;
            width:50px;
            }
    </style>
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



<script type="text/javascript">    
 function preview(file)  
 {  
 var prevDiv = document.getElementById('preview');  
 if (file.files && file.files[0])  
 {  
 var reader = new FileReader();  
 reader.onload = function(evt){  
 prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
}    
 reader.readAsDataURL(file.files[0]);  
}  
 else    
 {  
 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
 }  
 }  
 </script>  





<p><h3>&nbsp;&nbsp;▶ 产品信息详细表</h3><!--  -->
<form  action="/winner/yx/saveSubject" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" width="100%">
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;名称:</td><td><input type="text" name="name" class="form-control"></td><td>&nbsp;&nbsp;类型:</td><td><select class="form-control" name="type"><option value="0">固收类</option><option value="1">P2P车贷</option><option value="2">P2P房贷</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;合同编号:</td><td><input type="text" name="serialNo" class="form-control"></td><td>&nbsp;&nbsp;借款用途:</td><td><input type="text" name="purpose"  class="form-control"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;起投金额(元):</td><td><input type="text" name="floorAmount" class="form-control"></td><td>&nbsp;&nbsp;保障方式:</td><td><select name="safeGuard_way" class="form-control"><option value="0">企业担保</option><option value="1">银行监管</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;年化收益(%):</td><td><input type="text" name="yearRate" class="form-control"></td><td>&nbsp;&nbsp;可使用体验金:</td><td><select name="experStatus" class="form-control"><option value="0">否</option><option value="1">是</option></select></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;状态:</td><td><select class="form-control" name="status">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select></td><td>&nbsp;&nbsp;已购人数:</td><td><input type="text" class="form-control" name="bought"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;投资期限(天):</td><td><input type="text" class="form-control" name="period"></td><td colspan="2"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;借款人姓名:</td><td><input type="text" name="borrowername" class="form-control"></td><td colspan="2"></td>
</tr>
<tr height="60">
<td colspan="4"><h3>&nbsp;&nbsp;▶ 特定属性</h3><hr></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;债权编号:</td><td><input type="text" name="borrowerid" class="form-control"></td><td>&nbsp;&nbsp;&nbsp;债权人:</td><td><input type="text" name="borrowername" class="form-control" ></td>
</tr>
</table>

<hr>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品速览</h4><hr>
   <%--  <script id="editor1" type="text/plain" name="comment" value="${subject.comment}"  style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit" value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div>
	<textarea id="myUeditor" name="comment" style="height:250px;"></textarea>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="content" style="height:0px;"></textarea>
<p><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 项目详情</h3><hr>
   <%--  <script id="editor2" type="text/plain"name="projectDetails" value="${subject.projectDetails}" style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor2" name="projectDetails"  style="height:250px;"></textarea>
<p><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 安全保障</h3><hr>
   <%--  <script id="editor3" type="text/plain" name="safetyControl" value="${subject.safetyControl}" style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor3" name="safetyControl" style="height:250px;"></textarea>
<div style="width:100%" align="center">
<input type="submit" class="btn btn-primary" id="btn1" value="保存" onclick="return sub();">
</div >
<p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr>

&nbsp;&nbsp;&nbsp;图片预览 :<span id="preview" ></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div style="100px;" align="center">
<input type="file" name="file_name" onchange="preview(this)"  required="required"/>
</div>
</form>
<p><br>
<!--  <form action="/winner/yx/uploadFile" method="post" enctype="multipart/form-data">
<table border="0" cellspacing="0" width="100%">
<tr height="60"><td colspan="4"><p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr></td></tr>
<tr height="60"><td colspan="2">&nbsp;&nbsp;&nbsp;图片预览 :<span id="preview" style="width:50px;height:50px;"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td>
<input type="file" name="file_name" onchange="preview(this)" class="form-control" required="required"/></td>
<td>
<input type="submit" value="上传"   class="btn btn-primary" /></td>
</tr>
</table>
</form>  -->

<script type="text/javascript" charset="utf-8">
var ue = UE.getEditor("myUeditor");  
var ue2 = UE.getEditor("myUeditor2");
var ue3 = UE.getEditor("myUeditor3"); 
  	function sub(){    
         if(!UE.getEditor('myUeditor'&&'myUeditor2'&&'myUeditor3').hasContents()){	// 判断内容是否为空
        	alert("请填写回复内容！");
        	return false;
         }  
	}
</script>
</body>
</html>