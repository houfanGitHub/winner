<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私募/股权类编辑</title>
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
 <p><p><p><h4>▶&nbsp;私募/股权类编辑</h4>
<body>
 <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor1');
    var ue2 = UE.getEditor('editor2');
    var ue3 = UE.getEditor('editor3');
    function sub() {
        if(!UE.getEditor('editor1'&&'editor2'&&'editor3').hasContents()){	// 判断内容是否为空
        	alert("请填写内容！");
        	return false;
         }  
    }
</script> 


<script type="text/javascript">
$(function(){
	$("#id").val(${fs.status});
	$("#id2").val(${fs.type});
});
</script>

<script type="text/javascript" charset="utf-8">
var ue = UE.getEditor("myUeditor");  
var ue2 = UE.getEditor("myUeditor2");
var ue3 = UE.getEditor("myUeditor3"); 
var ue4 = UE.getEditor("myUeditor4"); 
var ue5 = UE.getEditor("myUeditor5"); 
function sub(){    
         if(!UE.getEditor('myUeditor'&&'myUeditor2'&&'myUeditor3'&&'myUeditor4'&&'myUeditor5').hasContents()){	// 判断内容是否为空
        	alert("请填写回复内容！");
        	return false;
         }  
	}
</script>

<!-- 表单验证部分开始 -->
<script type="text/javascript">
function fun(){
	var  a2=document.form1.name.value;
	var  a3=document.form1.floorAmount.value;
	var  a4=document.form1.yearRate.value;
	var  a7=document.form1.ratio.value;
	var  a9=document.form1.period.value;
	var  a13=document.form1.productManagerName.value;
	var  a14=document.form1.productManagerTitle.value;
	var  a15=document.form1.productManagerDesc.value;
	var  a19=document.form1.bankAccount.value;
	var b2=document.getElementById("name");
	var b3=document.getElementById("floorAmount");
	var b4=document.getElementById("yearRate");
	var b7=document.getElementById("ratio");
	var b9=document.getElementById("period");
	var b13=document.getElementById("productManagerName");
	var b14=document.getElementById("productManagerTitle");
	var b15=document.getElementById("productManagerDesc");
	var b19=document.getElementById("bankAccount");
	if(a2==""){
		b2.innerHTML="<img src='/winner/files/text_error.png'><font color=red>请填写姓名!</font>";
		return false;
		}else{
			b2.innerHTML="<font color=green>姓名格式通过</font>";
			}
	var reg3=/^[0-9]{1,10}$/;
	if(!reg3.test(a3)){
		b3.innerHTML="<img src='/winner/files/text_error.png'><font color=red>起投金额类型有误!</font>";
		return false;
		}else{
			b3.innerHTML="<font color=green>起投金额验证通过!</font>";
			}
	var reg4=/^[0-9]{1,10}$/;
	if(!reg4.test(a4)){
		b4.innerHTML="<img src='/winner/files/text_error.png'><font color=red>年化收益类型有误!</font>";
		return false;
		}else{
			b4.innerHTML="<font color=green>年化收益验证通过!</font>";
			}
	var reg7=/^[0-9]{1,10}$/;
	if(!reg7.test(a7)){
		b7.innerHTML="<img src='/winner/files/text_error.png'><font color=red>返佣比例类型有误!</font>";
		return false;
		}else{
			b7.innerHTML="<font color=green>返佣比例验证通过!</font>";
			}
	var reg9=/^[0-9]{1,10}$/;
	if(!reg9.test(a9)){
		b9.innerHTML="<img src='/winner/files/text_error.png'><font color=red>投资期限类型有误!</font>";
		return false;
		}else{
			b9.innerHTML="<font color=green>投资期限验证通过!</font>";
			}
	var reg13=/^[0-9a-zA-Z]{2,10}$/;
	if(!reg13.test(a13)){
		b13.innerHTML="<img src='/winner/files/text_error.png'><font color=red>基金经理名称验证有误!</font>";
		return false;
		}else{
			b13.innerHTML="<font color=green>基金经理名称验证通过!</font>";
			}
	var reg14=/^[0-9a-zA-Z]{2,}$/;
	if(!reg14.test(a14)){
		b14.innerHTML="<img src='/winner/files/text_error.png'><font color=red>基金经理头衔验证有误!</font>";
		return false;
		}else{
			b14.innerHTML="<font color=green>基金经理头衔验证通过!</font>";
			}
	var reg15=/^[0-9a-zA-Z]{2,}$/;
	if(!reg15.test(a15)){
		b15.innerHTML="<img src='/winner/files/text_error.png'><font color=red>基金经理简介验证有误!</font>";
		return false;
		}else{
			b15.innerHTML="<font color=green>基金经理简介验证通过!</font>";
			}
	var reg19=/^[0-9]{16,21}$/;
	if(!reg19.test(a19)){
		b19.innerHTML="<img src='/winner/files/text_error.png'><font color=red>基金经理简介验证有误!</font>";
		return false;
		}else{
			b19.innerHTML="<font color=green>基金经理简介验证通过!</font>";
			}
}
</script>
<!-- 表单验证部分结束-->

<p><p>
<form action="/winner/yx2/updateFinanceProductFunds" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${fs.id}">
<table border="0" width="100%">
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类别:</td>
<td width="35%">
<select readonly="readonly" id="id2" name="type" class="form-control">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select><span id="type"></span></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td>
<td width="35%"><input type="text" name="name" value="${fs.name}"  class="form-control"placeholder="请输入文本"><span id="name"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起投金额(元):</td>
<td width="35%"><input type="text" name="floorAmount" value="${fs.floorAmount}" class="form-control" placeholder="请输入文本"><span id="floorAmount"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年化收益(%):</td>
<td width="35%"><input type="text" name="yearRate" value="${fs.yearRate}" class="form-control" placeholder="请输入文本"><span id="yearRate"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始日期:</td>
<td width="35%"><input type="date" name="startDate" value="${fs.startDate}" class="form-control" placeholder="请输入文本"><span id="startDate"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束日期:</td>
<td width="35%"><input type="date" name="endDate" value="${fs.endDate}" class="form-control" placeholder="请输入文本"><span id="endDate"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返佣比例:</td>
<td width="35%"><input type="text" name="ratio" value="${fs.ratio}" class="form-control"placeholder="请输入文本"><span id="ratio"></span></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:</td>
<td width="35%">
<select name="status" id="id" class="form-control">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>
</td><td colspan="2">
</td></tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资期限(天):</td>
<td width="35%"><input type="text" name="period" value="${fs.period}" class="form-control" placeholder="请输入文本"><span id="period"></span></td><td colspan="2"></td>
</tr>
</table>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金专题/关于基金</h4><hr>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="productTopic" style="height:250px;">${fs.productTopic}</textarea>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品要素</h4><hr>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor2" name="productFactor" style="height:250px;">${fs.productFactor}</textarea>
	
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品策略</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor3" name="productStrategy" style="height:250px;">${fs.productStrategy}</textarea>
	
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金经理</h4><hr>	

<table width="100%" border="0">
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理名称:</td>
<td width="35%"><input type="text" name="productManagerName" value="${fs.productManagerName}" class="form-control" placeholder="请输入文本">
<span id="productManagerName"></span></td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理头衔:</td>
<td width="35%"><input type="text" name="productManagerTitle" value="${fs.productManagerTitle}" class="form-control" placeholder="请输入文本">
<span id="productManagerTitle"></span></td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理简介:</td>
<td width="35%"><input type="text" name="productManagerDesc" value="${fs.productManagerDesc}" class="form-control" placeholder="请输入文本">
<span id="productManagerDesc"></span></td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理头像:</td>
<td width="35%"><input type="file" name="file_name" value="${fs.productManagerPic}" required="required"  class="form-control">
</td><td></td></tr>
</table>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金经理详情</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor4" name="productManager"  style="height:250px;">${fs.productManager}</textarea>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 私募合同</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor5" name="contract" style="height:250px;">${fs.contract}</textarea>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 银行账户</h4><hr>
<table>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;银行账户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" name="bankAccount" value="${fs.bankAccount}" class="form-control" placeholder="请输入文本"><font color="red">例:招商银行杭州高新支行|1234 5678 1234 123|杭州吉威投资管理有限公司 </font></td><td colspan="2"></td>
</tr>
<tr>
<td></td><td></td><td colspan="2"><input type="submit" class="btn btn-primary" id="btn1" value="保存" onclick="return sub();"></td>
</tr>
</table>
</form>

</body>
</html>