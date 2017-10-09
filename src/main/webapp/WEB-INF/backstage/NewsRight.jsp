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
<title>咨询管理</title>
<style type="text/css">
img{
 width:auto;
 height:auto;
 max-width:100%;
 max-height:100%;
}
.green {
	color: #e8f0de;
	border: solid 1px #538312;
	background: #64991e;
	background: -webkit-gradient(linear, left top, left bottom, from(#7db72f), to(#4e7d0e));
	background: -moz-linear-gradient(top,  #7db72f,  #4e7d0e);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#7db72f', endColorstr='#4e7d0e');
}
.green:hover {
	background: #538018;
	background: -webkit-gradient(linear, left top, left bottom, from(#6b9d28), to(#436b0c));
	background: -moz-linear-gradient(top,  #6b9d28,  #436b0c);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#6b9d28', endColorstr='#436b0c');
}
.green:active {
	color: #a9c08c;
	background: -webkit-gradient(linear, left top, left bottom, from(#4e7d0e), to(#7db72f));
	background: -moz-linear-gradient(top,  #4e7d0e,  #7db72f);
	filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#4e7d0e', endColorstr='#7db72f');
}
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
});
function funtwo(){
document.forms[0].action="/winner/listNews";
document.forms[0].submit();
}
function deletes(id){
	      $('#url').val("/winner/deleteNews/"+id);//给会话中的隐藏属性URL赋值  
	      $('#delcfmModel').modal('show');  
}
function update(id){
window.location.href="/winner/getNews/"+id;
} 
function urlSubmit(){  
	   var url=$("#url").val();//获取会话中的隐藏属性URL 
	   window.location.href=url;    
	}  
function upload(file){
	var imgt = document.getElementById("imgt");
	if(file.files && file.files[0]){
		var reader = new FileReader();
		reader.onload = function(evt){
			imgt.innerHTML='<img src="' + evt.target.result + '" />';  
		}
		reader.readAsDataURL(file.files[0]);
	}else{
		/* imgt.innerHTML = 
	    '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  */
	return;
	}
}
</script>
</head>
<body>
<form  method="post">
<table class="table table-bordered table-hover" style='table-layout:fixed;' border="1">
<center><span><b>咨询标题:</b><input type="text"  name="stitle"  value="${stitle}" /></span>&nbsp&nbsp&nbsp&nbsp<span> <b>咨询类型:</b><input type="text" name="stname" value="${stname}" /></span><span><input type="button" class="green" value="搜索" onclick="funtwo();"></span></center>
</form>
<div align="right"><a data-toggle="modal" href="#example" onclick="fun();">添加 </a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div>
<tr style="height:8px">
<th style="width: 50px;">序号</th><th style="width: 300px;">标题:</th><th>类型</th><th style="display: none;">副标题</th><th>简介</th> <th>作者</th><th>内容</th><th style="width: 80px;">是否审核</th><th>是否置顶</th><th>是否推荐</th>
<th style="width:100px;">添加时间</th><th>添加人ID</th><th style="display: none;">标签</th><th style="display: none;">链接地址</th><th>点击数量</th><th>封面图片</th><th style="display: none;">来源</th><th style="display: none;">附件地址</th>
<th style="display: none;">SEO描述</th><th style="display: none;">SEO关键字</th><th style="display: none;">SEO标题</th><th>修改人ID</th> <th style="width:100px;">修改时间</th><th>操作</th>
</tr>
<c:forEach items="${list}" var="n">
<tr>
<td>${n.id }</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.title }</td> <td>${n.newsType.name}</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;display: none;">${n.subTitle}</td> 
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${n.info }</td><td>${n.author}</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;"><div style="width: 20px;height: 8px">${n.text}</div></td>
<td>${n.audit == 1 ? '是':'否'}</td><td>${n.placTop == 1 ? '是':'否'}</td><td>${n.recommend == 1 ? '是':'否'}</td><td>${n.addTime }</td><td>${n.addId}</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;display: none;">${n.label }</td>
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;display: none;">${n.link}</td><td>${n.clickNumber }</td><td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;"><div style="width: 200px;height:80px;"><img src= "/winner/${n.cPhoto}" /></div></td><td style="display: none;">${n.source}</td>
<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;display: none;">${n.filelink }</td><td style="display: none;">${n.seoDes}</td><td style="display: none;">${n.seoKey }</td> <td style="display: none;">${n.seoTitle}</td><td>${n.updId}</td><td>${n.updTime}</td> 
<td><input type="button" class="blue" onclick="update(${n.id})" value="修改" />
<input type="button" class="red" data-toggle="modal" onclick="deletes(${n.id});" value="删除"></td>
</tr>
</c:forEach>
</table>
<!--添加 -->
<div class="container">
<div id="example" class="modal fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3><font color="whitesmoke">添加资讯</font></h3>
</div>
<div class="modal-body">
<center>
<form name="form1" action="saveNews" method="post" enctype="multipart/form-data" >
<table>
<tr>
<td><font color="whitesmoke">标 题:</font></td><td><input type="text"  name="title"  /></td><td><font color="whitesmoke">副标题:</font></td><td><input type="text"  name="subTitle"  /></td><td colspan="2" rowspan="2" style="width: 200px;height: 55px;" id="imgt"><img src="" /></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">作者:</font><td><input type="text"   name="author"   /><td><font color="whitesmoke">简 介:</font></td><td><input type="text"   name="info"  /></td>
 </tr>
<tr>
<td><font color="whitesmoke">来源:</font><td><input type="text" name="source" /><td><font color="whitesmoke">标 签:</font></td><td><input type="text"  name="label"  /></td><td><font color="whitesmoke">封面图片 :</font></td><td><input type="file" name="file" onchange="upload(this);" /></td>
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
<div class="modal fade" id="delcfmModel">  
  <div class="modal-dialog">  
    <div class="modal-content message_align">  
      <div class="modal-header">  
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>  
        <h4 class="modal-title">提示信息</h4>  
      </div>  
      <div class="modal-body">  
        <p>您确认要删除吗？</p>  
      </div>  
      <div class="modal-footer">  
         <input type="hidden" id="url"/>  
         <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
         <a  onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>  
      </div>
     </div><!-- /.modal-content -->  
  </div><!-- /.modal-dialog -->  
</div><!-- /.modal -->  
</body>
</html>