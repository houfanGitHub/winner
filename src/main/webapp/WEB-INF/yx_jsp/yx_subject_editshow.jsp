<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>固收类编辑查看</title>
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
<script type="text/javascript">
$(function(){
	$("#id").val(${subject.type});
	$("#id2").val(${subject.safeGuard_way});
	$("#id3").val(${subject.status});
});
</script>
<script type="text/javascript" charset="utf-8">
var ue = UE.getEditor("myUeditor");  
var ue2 = UE.getEditor("myUeditor2");
var ue3 = UE.getEditor("myUeditor3"); 
  	function sub(){    
         if(!UE.getEditor('myUeditor').hasContents()){	// 判断内容是否为空
        	alert("请填写回复内容！");
        	return false;
         }  
	}
</script>
<script type="text/javascript">
 $(function(){
$("#form1").click(function(){
		document.forms[0].action="/winner/yx/updateSubject/"+${subject.id };
		document.forms[0].submit();
	});
 });
</script>
<script type="text/javascript">
function fun(){
	var  a1=document.form1.name.value;
	//var  a2=document.form1.type.value;
	var  a3=document.form1.serialNo.value;
	var  a4=document.form1.purpose.value;
	var  a5=document.form1.floorAmount.value;
	var  a6=document.form1.safeGuard_way.value;
	var  a7=document.form1.yearRate.value;
	var  a8=document.form1.experStatus.value;
	var  a9=document.form1.status.value;
	var  a10=document.form1.bought.value;
	var  a11=document.form1.period.value;
	var  a12=document.form1.borrowername.value;
	var  a13=document.form1.borrowerid.value;
	var b1=document.getElementById("name");
	//var b2=document.getElementById("type");
	var b3=document.getElementById("serialNo");
	var b4=document.getElementById("purpose");
	var b5=document.getElementById("floorAmount");
	var b6=document.getElementById("safeGuard_way");
	var b7=document.getElementById("yearRate");
	var b8=document.getElementById("experStatus");
	var b9=document.getElementById("status");
	var b10=document.getElementById("bought");
	var b11=document.getElementById("period");
	var b12=document.getElementById("borrowername");
	var b13=document.getElementById("borrowerid");
	if(a1==""){
		b1.innerHTML="<img src='/winner/files/text_error.png'><font color=red>请填写姓名!</font>";
		return false;
		}else{
			b1.innerHTML="<font color=green>姓名格式通过</font>";
			}
	var reg3=/^[0-9]{1,10}$/;
	if(!reg3.test(a3)){
		b3.innerHTML="<img src='/winner/files/text_error.png'><font color=red>合同编号类型有误!</font>";
		return false;
		}else{
			b3.innerHTML="<font color=green>合同编号验证通过!</font>";
			}
	if(a4==""){
		b4.innerHTML="<img src='/winner/files/text_error.png'><font color=red>借款用途验证有误!</font>";
		return false;
		}else{
			b4.innerHTML="<font color=green>借款用途验证通过</font>";
			}
	var reg5=/^[0-9]{1,10}$/;
	if(!reg5.test(a5)){
		b5.innerHTML="<img src='/winner/files/text_error.png'><font color=red>起投金额验证有误!</font>";
		return false;
		}else{
			b5.innerHTML="<font color=green>起投金额验证通过</font>";
			}
	var reg7=/^[0-9]{1,20}$/;
	if(!reg7.test(a7)){
		b7.innerHTML="<img src='/winner/files/text_error.png'><font color=red>年化收益验证有误!</font>";
		return false;
		}else{
			b7.innerHTML="<font color=green>年化收益验证通过</font>";
			}
	var reg10=/^[0-9]{1,20}$/;
	if(!reg10.test(a10)){
		b10.innerHTML="<img src='/winner/files/text_error.png'><font color=red>已购人数验证有误!</font>";
		return false;
		}else{
			b10.innerHTML="<font color=green>已购人数验证通过</font>";
			}
	var reg11=/^[0-9]{1,10}$/;
	if(!reg11.test(a11)){
		b11.innerHTML="<img src='/winner/files/text_error.png'><font color=red>投资期限验证有误!</font>";
		return false;
		}else{
			b11.innerHTML="<font color=green>投资期限验证通过</font>";
			}
	var reg12=/^[\w]{2,15}$/;
	if(!reg12.test(a12)){
		b12.innerHTML="<img src='/winner/files/text_error.png'><font color=red>借款人姓名验证有误!</font>";
		return false;
		}else{
			b12.innerHTML="<font color=green>借款人格式通过</font>";
			}
	var reg13=/^[0-9]{1,10}$/;
	if(!reg13.test(a11)){
		b13.innerHTML="<img src='/winner/files/text_error.png'><font color=red>债权编号验证有误!</font>";
		return false;
		}else{
			b13.innerHTML="<font color=green>债权编号验证通过</font>";
			}
	return true;
}


</script>


<p><p><p><h4>▶&nbsp;固收类类编辑</h4>
<p><p>
<form   method="post" onsubmit="return sub(),fun();"  enctype="multipart/form-data">
 <input type="hidden" value="${subject.id }" name="id"> 
 <%-- <input type="hidden" value="${subjectFile.id}" name="SubjectFolder.SubjectFile.id">  --%>

<table width="100%">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td><td><input type="text" name="name" value="${subject.name}" class="form-control"><span id="name"></span></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型:</td><td><select id="id" name="type" class="form-control" readonly="readonly">
<c:if test="${subject.type==0}">
<option value="0">固收类</option>
</c:if>
<c:if test="${subject.type==1}">
<option value="1">P2P车贷</option>
</c:if>
<c:if test="${subject.type==2}">
<option value="2">P2P房贷</option>
</c:if>
</select><span id="type"></span></td>
</tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合同编号:</td><td><input type="text" name="serialNo" value="${subject.serialNo}" class="form-control"><span id="serialNo"></span></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;借款用途:</td><td><input type="text" name="purpose" value="${subject.purpose}" class="form-control"><span id="purpose"></span></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起投金额(元):</td><td><input type="text" name="floorAmount" value="${subject.floorAmount}" class="form-control"><span id="floorAmount"></span></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保障方式:</td>
<td>
<select id="id2" name="safeGuard_way" class="form-control">
<option value="0">企业担保</option>
<option value="1">银行监管</option>
</select><span id="safeGuard_way"></span>
</td>
<tr>
<td>状态:</td><td><select id="id3" name="status" class="form-control">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select><span id="status"></span></td><td>已购人数:</td><td><input type="text" name="bought" value="${subject.bought}" class="form-control"></td>
</tr>
<tr><td>投资期限:</td><td><input type="text" name="period" value="${subject.period}" class="form-control"><span id="period"></span></td><td colspan="2"></td></tr>
<tr>
<td>借款人姓名:</td><td><input type="text" name="borrowername" value="${subject.borrowername}" class="form-control"><span id="borrowername"></span></td><td colspan="2"></td>
</tr>
<tr><td colspan="4"><p><p><p><h4>▶&nbsp;固收类类编辑</h4><hr></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;债权编号:</td><td><input type="text" value="${subject.borrowerid}" name="borrowerid" class="form-control"><span id="borrowerid"></span></td>
<td></td><td></td>
</tr>
</table>
<hr>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品速览</h4><hr>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit" value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div>
	<textarea id="myUeditor" name="comment"style="height:250px;">${subject.comment}</textarea>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea  id="myUeditor"  name="content"   style="height:0px;"></textarea>
	
<p><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 项目详情</h3><hr>
   <%--  <script id="editor2" type="text/plain"name="projectDetails" value="${subject.projectDetails}" style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor2" name="projectDetails"style="height:250px;">${subject.projectDetails}</textarea>
<p><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 安全保障</h3><hr>
   <%--  <script id="editor3" type="text/plain" name="safetyControl" value="${subject.safetyControl}" style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor3" name="safetyControl" style="height:250px;">${subject.safetyControl}</textarea>
<div style="width:100%" align="center">
<input type="submit" class="btn btn-primary" id="form1" value="保存" >
</div>

<!-- <p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr> -->

&nbsp;&nbsp;&nbsp;<!-- 图片预览 :<span id="preview" ></span> -->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div style="100px;" align="center">
<!--  <input type="file" name="file_name"  onchange="preview(this)"  required="required"/>  -->
</div>

</form>


</body>
</html>