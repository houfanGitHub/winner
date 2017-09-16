<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
});
</script>


<p><p>
<form action="" method="post">
<table width="100%">
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类别:</td><td><select readonly="readonly" class="form-control">
<option value="${fs.type}">私募类</option>
</select></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称:</td><td><input type="text" value="${fs.name}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起投金额:</td><td><input type="text" value="${fs.floorAmount}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年化收益:</td><td><input type="text" value="${fs.yearRate}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间:</td><td><input type="text" value="${fs.startDate}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间:</td><td><input type="text" value="${fs.endDate}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返佣比例:</td><td><input type="text" value="${fs.ratio}" class="form-control"></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态:</td><td>
<select id="id" class="form-control">  
<option value="0">未发布</option>
<option value="1">募集中</option>
<option value="2">已结束</option>
</select>
</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投资期限:</td><td><input type="text" value="${fs.period}" class="form-control"></td></tr>
<tr height="60"><td colspan="4">
<p><h3>&nbsp;&nbsp;▶ 产品要素</h3><hr>
    <script id="editor1" type="text/plain" name="productFactor" value=${fs.productFactor}  style="width:100%px;height:500px;"></script>
</td></tr>

</table>
</form>

</body>
</html>