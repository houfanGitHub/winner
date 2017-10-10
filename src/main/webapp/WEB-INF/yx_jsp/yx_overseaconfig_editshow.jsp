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
<style>

/*日期控件*/
body{ padding:50px 0 0 50px;}
.datainp{ width:200px; height:30px; border:1px #ccc solid;}
.datep{ margin-bottom:40px;}
</style>
<script type="text/javascript" charset="utf-8" src="/winner/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/winner/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="/winner/ueditor/ueditor.parse.js"></script>
 <script type="text/javascript" src="/winner/js/jquery-3.2.0.min.js"></script>
 <script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<script type="text/javascript" src="/winner/js/jedate.js"></script>
<body>
<script type="text/javascript" charset="utf-8">
var ue = UE.getEditor("myUeditor");  
  	function sub(){    
         if(!UE.getEditor('myUeditor').hasContents()){	// 判断内容是否为空
        	alert("请填写回复内容！");
        	return false;
         }  
	}
</script>
<script type="text/javascript">
$(function(){
	$("#id").val(${overseaConfig.status});
});
</script>
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
	var reg1=/^[0-9a-zA-Z]{2,20}$/;
	if(!reg1.test(a1)){
		b1.innerHTML="<img src='/winner/files/text_error.png'><font color=red>借款人姓名验证有误!</font>";
		return false;
		}else{
			b1.innerHTML="<font color=green>借款人格式通过</font>";
			}
	var reg2=/^[0-9a-zA-Z]{2,20}$/;
	if(!reg2.test(a2)){
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

<p><p><p><h4>▶&nbsp;海外配置编辑</h4>
<form action="/winner/yx3/updateOverseaConfig" enctype="multipart/form-data" method="post">
<input type="hidden" name="id" value="${overseaConfig.id}"/>
<table width="100%">
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题:</td><td><input type="text"name="title" class="form-control" size="100" align="top"  value="${overseaConfig.title}"><span id="title"></span></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;子标题:</td><td><input type="text" name="childTitle" value="${overseaConfig.childTitle}" class="form-control"><span id="childTitle"></span></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述:</td><td><input type="text" name="description" value="${overseaConfig.description}" class="form-control"><span id="description"></span></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户群体:</td><td><input type="text" name="userType" value="${overseaConfig.userType}" class="form-control"><span id="userType"></span></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;排序值:</td><td><input type="text" name="sortColum" value="${overseaConfig.sortColum}" class="form-control"><span id="sortColum"></span></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:</td><td>
<select id="id" class="form-control" name="status">  
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>

</select>
</td></tr>                                                            
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间:</td><td><input type="date" name="startDate" value="${overseaConfig.startDate}"  class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间:</td><td><input type="date" name="endDate" value="${overseaConfig.endDate}"  class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图标:</td><td><input type="file" name="fileopload" class="form-control" required="required">${overseaConfig.overseaIcon}</td></tr>
<tr><td colspan="2">
</td></tr>
</table>
<div>
<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="content"style="height:250px;">${overseaConfig.content}</textarea>
<div align="center"><input type="submit" value="保存" class="btn btn-primary"></div>
</form>



</body>
</html>