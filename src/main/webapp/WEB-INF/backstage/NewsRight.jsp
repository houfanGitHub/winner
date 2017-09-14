<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/winner/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/winner/ueditor/ueditor.all.min.js"></script>
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/backstage/show/bootstrap.min.js"></script>
<link href="/winner/backstage/show/ButtonColors.css" rel="stylesheet"> 
<script type="text/javascript" src="/winner/ueditor/lang/zh-cn/zh-cn.js"></script>
<title>咨询分类</title>
<style type="text/css">
.red {
	color: #faddde;
	border: solid 1px #980c10;
	background: #d81b21;
	background: -webkit-gradient(linear, left top, left bottom, from(#ed1c24), to(#aa1317));
	background: -moz-linear-gradient(top,  #ed1c24,  #aa1317);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ed1c24', endColorstr='#aa1317');
}
.red:hover {
	background: #b61318;
	background: -webkit-gradient(linear, left top, left bottom, from(#c9151b), to(#a11115));
	background: -moz-linear-gradient(top,  #c9151b,  #a11115);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#c9151b', endColorstr='#a11115');
}
.red:active {
	color: #de898c;
	background: -webkit-gradient(linear, left top, left bottom, from(#aa1317), to(#ed1c24));
	background: -moz-linear-gradient(top,  #aa1317,  #ed1c24);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#aa1317', endColorstr='#ed1c24');
}
.blue {
	color: #d9eef7;
	border: solid 1px #0076a3;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
	background: -moz-linear-gradient(top,  #00adee,  #0078a5);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
}
.blue:hover {
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
	background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
}
.blue:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
	background: -moz-linear-gradient(top,  #0078a5,  #00adee);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
}
</style>
<script type="text/javascript">
$(function(){
	var ue = UE.getEditor('editor',{
    initialFrameWidth:1000,  //初始化编辑器宽度,默认1000
    initialFrameHeight:200  //初始化编辑器高度,默认320	
	});
    enableBtn();
    ue.getEditor('editor');
})
</script>
<script type="text/javascript">  
            
        </script>  
</head>
<body>
<form>
<div align="right"><a data-toggle="modal" href="#example">添加 </a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div>
<table class="table table-bordered table-hover" style='table-layout:fixed;' border="1">
<tr style="height:8px">
<th>序号</th><th>标题</th><th>副标题</th><th>简介</th><th>作者</th><th>内容</th><th>是否审核</th><th>是否置顶</th><th>是否推荐</th>
<th style="width:100px;">添加时间</th><th>添加人ID</th><th>标签</th><th>链接地址</th><th>点击数量</th><th>封面图片</th><th>来源</th><th>附件地址</th>
<th>SEO描述</th><th>SEO关键字</th><th>SEO标题</th><th>修改ID</th><th style="width:100px;">修改时间</th><th>操作</th>
</tr>
<c:forEach items="${list}" var="n">
<tr>
<td>${n.id }</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.title }</td> <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.subTitle}</td>
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.info }</td><td>${n.author}</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;"><div style="width: 20px;height: 15px">${n.text}</div></td>
<td>${n.audit}</td><td>${n.placTop}</td><td>${n.recommend }</td><td>${n.addTime }</td><td>${n.addId}</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.label }</td>
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.link}</td><td>${n.clickNumber }</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.cPhoto}</td><td>${n.source}</td>
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.filelink }</td><td>${n.seoDes}</td><td>${n.seoKey }</td><td>${n.seoTitle}</td><td>${n.updId}</td><td>${n.updTime}</td> 
<td><input type="button" value="修改"  class="blue"/><input type="button" value="删除"  class="red"/></td>
</tr>
</c:forEach>
</table>
</form>
<div class="container">
<div id="example" class="modal fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3><font color="whitesmoke">添加资讯</font></h3>
</div>
 <div class="modal-body">
<center>
<form name="form1" action="saveNews" method="post">
<table>
<tr>
<td><font color="whitesmoke">标 题:</font><td><input type="text"  name="title"  /><td><font color="whitesmoke">副标题:</font></td><td><input type="text"  name="subTitle"  /></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">作者:</font><td><input type="text"   name="author"   /><td><font color="whitesmoke">简 介:</font></td><td><input type="text"   name="info"  /></td> 
 </tr>
<tr>
<td><font color="whitesmoke">来源:</font><td><input type="text" name="source" /><td><font color="whitesmoke">标 签:</font></td><td><input type="text"  name="label"  /></td><td><font color="whitesmoke">封面图片:</font></td><td><input type="file" name="cPhoto"/></td>
</tr>
 <tr>
 <td><font color="whitesmoke">链接地址:</font><td><input type="text" name="link" /><td><font color="whitesmoke">附件地址:</font></td><td><input type="text" name="filelink" /></td><td><font color="whitesmoke">咨询类型:</font></td><td><select name="tid"><c:forEach items="${listt}" var="nt"><option value="${nt.id}">${nt.name}</option></c:forEach></select></td>
 </tr>
<tr>
<td><font color="whitesmoke">SEO标题:</font><td><input type="text" name="seoTitle" /><td><font color="whitesmoke">SEO描述:</font></td><td><input type="text" name="seoDes"/></td><td><font color="whitesmoke">SEO关键字:</font></td><td><input type="text" name="seoKey"  /></td>
</tr>
<tr>
 <td><font color="whitesmoke">是否审核</font></td><td><select name="audit"><option value="1" >是</option><option value="0">否</option></select></td> 
 <td><font color="whitesmoke">是否置顶</font></td><td><select name="placTop"><option value="1" >是</option><option value="0">否</option></select></td>
 <td><font color="whitesmoke">是否推荐</font></td><td><select name="recommend"><option value="1">是</option><option value="0">否</option></select></td> 
 </tr> 
 <tr><td><font color="whitesmoke">内容:</font></td></tr>
 <tr><td colspan="6"><script  name="text" id="editor" type="text/plain" style="width:1024px;height:500px;"></script></td></tr>
</table>
<div class="modal-footer">
<input type="submit" value="提交"  class="btn btn-success"> <a href="#" class="btn" data-dismiss="modal"><font color="red">关闭</font></a>
</div>
</form>
</center>
</div>
</div>
</div>
</body>
</html>