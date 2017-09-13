<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
$(function(){
	$("#btn1").click(function(){
		$("#form1").attr("action","/winner/yx/saveSubject");
		$("#form1").submit();
	});
});
</script>

<p><h3>&nbsp;&nbsp;▶ 产品信息详细表</h3>
<form action="" id="form1" method="post" onsubmit="return setContent();">
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
<td>&nbsp;&nbsp;&nbsp;年化收益(%):</td><td><input type="text" name="yearRate" class="form-control"></td><td>&nbsp;&nbsp;募集开始时间:</td><td><input type="date" name="raiseStart" class="form-control"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;状态:</td><td><select class="form-control" name="status">
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">回款中</option>
<option value="3">还款完成</option>
</select></td><td>&nbsp;&nbsp;募集结束时间:</td><td><input type="date" class="form-control" name="raiseEnd"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;投资期限(天):</td><td><input type="text" class="form-control" name="period"></td><td>标的开始时间:</td><td><input type="text" class="form-control" name="startDate"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;借款人姓名:</td><td><input type="text" name="borrowername" class="form-control"></td><td>标的结束时间:</td><td><input type="date" name="endDate"></td>
</tr>
<tr>
<td>总金额(元):</td><td><input type="text" name="" class="form-control"></td>
</tr>
<tr height="60">
<td colspan="4"><h3>&nbsp;&nbsp;▶ 特定属性</h3><hr></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;债权编号:</td><td><input type="text" class="form-control"></td><td>&nbsp;&nbsp;企业认证:</td><td><input type="text" class="form-control"></td>
</tr>
<tr height="60">
<td>&nbsp;&nbsp;&nbsp;债权人:</td><td><input type="text" class="form-control"></td><td>&nbsp;&nbsp;保障平台</td><td><input type="text" class="form-control"></td>
</tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 产品信息详细表</h3><hr>
    <script id="editor1" type="text/plain" style="width:100%px;height:500px;"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 项目详情</h3><hr>
    <script id="editor2" type="text/plain" style="width:100%px;height:500px;"></script>
</td></tr>

<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 安全保障</h3><hr>
    <script id="editor3" type="text/plain" style="width:100%px;height:500px;"></script>
</td></tr>
<tr height="60"><td colspan="4"  align="center"><input type="button" class="btn btn-primary" id="btn1" value="保存">
</td></tr>
<tr height="60"><td colspan="4"><p><h3>&nbsp;&nbsp;▶ 标的附件</h3><hr></td></tr>
<tr height="60"><td colspan="2">&nbsp;&nbsp;&nbsp;图片预览 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td colspan="2">
<input type="file"/></td>

</tr>
</table>
</form>








 <script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor1');
    var ue = UE.getEditor('editor2');
    var ue = UE.getEditor('editor3');
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
</script> 
</body>
</html>