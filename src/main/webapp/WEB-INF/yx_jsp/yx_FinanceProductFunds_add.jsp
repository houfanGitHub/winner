<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>私募股权类添加</title>
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
<p><h4>&nbsp;&nbsp;▶ 私募股权类添加</h4><hr>
<form action="/winner/yx2/saveFinanceProductFunds" method="post" enctype="multipart/form-data">
<table border="0" width="100%">
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类别:</td>
<td width="35%"><select name="type" class="form-control">
<option value="SIMU">私募类</option>
<option value="GUQUAN">股权类</option>
</select></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td>
<td width="35%"><input type="text" name="name"  class="form-control"placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起投金额(元):</td>
<td width="35%"><input type="text" name="floorAmount" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年化收益(%):</td>
<td width="35%"><input type="text" name="yearRate" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始日期:</td>
<td width="35%"><input type="date" name="startDate" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束日期:</td>
<td width="35%"><input type="date" name="endDate" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返佣比例:</td>
<td width="35%"><input type="text" name="ratio" class="form-control"placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:</td>
<td width="35%">
<select name="status" class="form-control">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>
</td><td colspan="2">
</td></tr>
<tr>
<td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资期限(天):</td>
<td width="35%"><input type="text" name="period" class="form-control" placeholder="请输入文本"></td><td colspan="2"></td>
</tr>
</table>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金专题/关于基金</h4><hr>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor" name="productTopic" style="height:250px;"></textarea>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品要素</h4><hr>
<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor2" name="productFactor" style="height:250px;"></textarea>
	
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 产品策略</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor3" name="productStrategy" style="height:250px;"></textarea>
	
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金经理</h4><hr>	

<table width="100%" border="0">
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理名称:</td>
<td width="35%"><input type="text" name="productManagerName"class="form-control" placeholder="请输入文本">
</td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理头衔:</td>
<td width="35%"><input type="text" name="productManagerTitle"class="form-control" placeholder="请输入文本">
</td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理简介:</td>
<td width="35%"><input type="text" name="productManagerDesc"class="form-control" placeholder="请输入文本">
</td><td></td></tr>
<tr><td width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;基金经理头像:</td>
<td width="35%"><input type="file" name="file_name"class="form-control" placeholder="请输入文本">
</td><td></td></tr>
</table>

<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 基金经理详情</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor4" name="productManager" style="height:250px;"></textarea>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 合同类容</h4><hr>
	<div style="width:100%;background-color:#EDE7D1;">
		<input type="submit"   value="" style="width:80px;height:33px;background:url(img/pn_reply.png); border:none;"/>
	</div><textarea id="myUeditor5" name="productManager" style="height:250px;"></textarea>
<p><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;▶ 银行账户</h4><hr>
<table>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;银行账户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" name="bankAccount" class="form-control" placeholder="请输入文本"><font color="red">例:招商银行杭州高新支行|1234 5678 1234 123|杭州吉威投资管理有限公司 </font></td><td colspan="2"></td>
</tr>
<tr>
<td></td><td></td><td colspan="2"><input type="submit" class="btn btn-primary" id="btn1" value="保存" onclick="return sub();"></td>
</tr>
</table>
</form>

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
</body>
</html>