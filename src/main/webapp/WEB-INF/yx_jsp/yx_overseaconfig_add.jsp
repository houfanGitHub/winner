<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- 表单验证部分开始 -->
<script type="text/javascript">
function fun(){
	var  a1=document.form1.title.value;
	var  a2=document.form1.childTitle.value;
	var  a3=document.form1.description.value;
	var  a4=document.form1.userType.value;
	var  a5=document.form1.sortColum.value;
	var b1=document.getElementById("title");
	var b2=document.getElementById("childTitle");
	var b3=document.getElementById("description");
	var b4=document.getElementById("userType");
	var b5=document.getElementById("sortColum");
	//var reg1=/^[0-9a-zA-Z]{2,20}$/;
	if(a1==null){
		b1.innerHTML="<img src='/winner/files/text_error.png'><font color=red>借款人姓名验证有误!</font>";
		return false;
		}else{
			b1.innerHTML="<font color=green>借款人格式通过</font>";
			}
	//var reg2=/^[0-9a-zA-Z]{2,20}$/;
	if(a2==null){
		b2.innerHTML="<img src='/winner/files/text_error.png'><font color=red>子标题验证有误!</font>";
		return false;
		}else{
			b2.innerHTML="<font color=green>子标题格式通过</font>";
			}
	var reg3=/^[0-9a-zA-Z]{2,20}$/;
	if(!reg3.test(a3)){
		b3.innerHTML="<img src='/winner/files/text_error.png'><font color=red>描述验证有误!</font>";
		return false;
		}else{
			b3.innerHTML="<font color=green>描述格式通过</font>";
			}
	var reg4=/^[0-9a-zA-Z]{2,20}$/;
	if(!reg4.test(a4)){
		b4.innerHTML="<img src='/winner/files/text_error.png'><font color=red>用户群体验证有误!</font>";
		return false;
		}else{
			b4.innerHTML="<font color=green>用户群体格式通过</font>";
			}
	var reg5=/^[0-9]{1,10}$/;
	if(!reg5.test(a5)){
		b5.innerHTML="<img src='/winner/files/text_error.png'><font color=red>排序值验证有误!</font>";
		return false;
		}else{
			b5.innerHTML="<font color=green>排序值验证通过</font>";
			}
}

</script>
<!-- 表单验证部分结束-->

<p><p><p><h4>▶&nbsp;海外配置</h4><hr>
<form action="/winner/yx3/saveOverseaConfig" name="form1"  enctype="multipart/form-data" onSubmit="return fun();" method="post" >
 <table border="0" width="100%">
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td>
<td width="35%"><input type="text" name="title"  class="form-control"placeholder="请输入文本"><span id="title"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;子标题:</td>
<td width="35%"><input type="text" name="childTitle" class="form-control" placeholder="请输入文本"><span id="childTitle"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述:</td>
<td width="35%"><input type="text" name="description" class="form-control" placeholder="请输入文本"><span id="description"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户群体:</td>
<td width="35%"><input type="text" name="userType" class="form-control" placeholder="请输入文本"><span id="userType"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排序值:</td>
<td width="35%"><input type="text" name="sortColum" class="form-control" placeholder="请输入文本"><span id="sortColum"></span></td><td colspan="2"></td>
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
<input type="date" name="startDate"  class="form-control" required="required">
</td><td colspan="2">
</td></tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间:</td>
<td width="35%">
<input type="date" name="endDate"  class="form-control" required="required">
</td><td colspan="2">
</td></tr> 
<tr> 
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图标:</td>
<td width="35%">
<input type="file" name="fileopload"  class="form-control" required="required">
</td><td colspan="2">
</td></tr>
</table>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="content" style="height:250px;"></textarea>
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