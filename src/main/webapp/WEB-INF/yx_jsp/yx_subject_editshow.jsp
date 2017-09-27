<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		document.forms[0].action="/winner/yx/updateSubject/"+${subject.id};
		document.forms[0].submit();
	});
 });
</script>
<p><p><p><h4>▶&nbsp;固收类类编辑</h4>
<p><p>
<form   method="post" onsubmit="return sub();" enctype="multipart/form-data">
<table width="100%">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td><td><input type="text" name="name" value="${subject.name}" class="form-control"></td>
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
</select></td>
</tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合同编号:</td><td><input type="text" name="serialNo" value="${subject.serialNo}" class="form-control"></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;借款用途:</td><td><input type="text" name="purpose" value="${subject.purpose}" class="form-control"></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起投金额(元):</td><td><input type="text" name="floorAmount" value="${subject.floorAmount}" class="form-control"></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保障方式:</td>
<td>
<select id="id2" name="safeGuard_way" class="form-control">
<option value="0">企业担保</option>
<option value="1">银行监管</option>
</select>
</td>
<tr>
<td>状态:</td><td><select id="id3" name="status" class="form-control">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select></td><td>已购人数:</td><td><input type="text" name="bought" value="${subject.bought}" class="form-control"></td>
</tr>
<tr><td>投资期限:</td><td><input type="text" name="period" value="${subject.period}" class="form-control"></td><td colspan="2"></td></tr>
<tr>
<td>借款人姓名:</td><td><input type="text" name="borrowername" value="${subject.borrowername}" class="form-control"></td><td colspan="2"></td>
</tr>
<tr><td colspan="4"><p><p><p><h4>▶&nbsp;固收类类编辑</h4><hr></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;债权编号:</td><td><input type="text" value="${subject.borrowerid}" name="borrowerid" class="form-control"></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;债权人:</td><td><input type="text" value="${subject.borrowername}" name="borrowername" class="form-control" ></td>
</tr>
</table>
<hr>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品速览</h4><hr>
   <%--  <script id="editor1" type="text/plain" name="comment" value="${subject.comment}"  style="width:100%px;height:500px;"></script> --%>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit" value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div>
	<textarea id="myUeditor" name="comment"style="height:250px;">${subject.comment}</textarea>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea  id="myUeditor"  name="content" ${subject.comment}  style="height:0px;"></textarea>
	
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

<p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr>

&nbsp;&nbsp;&nbsp;图片预览 :<span id="preview" ></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div style="100px;" align="center">
<input type="file" name="file_name"  onchange="preview(this)"  required="required"/>
</div>

</form>




</body>
</html>