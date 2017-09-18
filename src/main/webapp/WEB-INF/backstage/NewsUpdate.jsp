<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#example2').modal('show');
	var ue = UE.getEditor('editor2',{
	    initialFrameWidth:1000,  //初始化编辑器宽度,默认1000
	    initialFrameHeight:200  //初始化编辑器高度,默认320	
		});
	    enableBtn();
	    ue.getEditor('editor2');
});
</script>
</head>
<body>
<!--修改 -->
<div class="container">
<div id="example2" class="modal">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3><font color="whitesmoke">修改资讯</font></h3>
</div>
<div class="modal-body">
<center>
<form name="form1" action="saveNews" method="post" enctype="multipart/form-data" >
<table>
<tr>
<td><font color="whitesmoke">标 题:</font><td><input type="text"  name="title"  value="${n.title}"/><td><font color="whitesmoke">副标题:</font></td><td><input type="text"  name="subTitle"  value="${n.subTitle}" /></td>
</tr>
 <tr> 
 <td><font color="whitesmoke">作者:</font><td><input type="text"   name="author"  value="${n.author }" /><td><font color="whitesmoke">简 介:</font></td><td><input type="text"   name="info" value="${n.info }" /></td> 
 </tr>
<tr>
<td><font color="whitesmoke">来源:</font><td><input type="text" name="source" value="${n.source}" /></td><td><font color="whitesmoke">标 签:</font></td><td><input type="text"  name="label" value="${n.label}" /></td><td><font color="whitesmoke">封面图片 :</font></td><td><input type="file"  value="${n.cPhoto}" /></td>
</tr>
 <tr>
 <td><font color="whitesmoke">链接地址:</font><td><input type="text" name="link" value="${n.link }" /><td><font color="whitesmoke">附件地址:</font></td><td><input type="text" name="filelink" value="${n.filelink }" /></td><td><font color="whitesmoke">咨询类型:</font></td><td><select name="tid"><c:forEach items="${listt}" var="nt"><option value="${nt.id}">${nt.name}</option></c:forEach></select></td>
 </tr>
<tr>
<td><font color="whitesmoke">SEO标题:</font><td><input type="text" name="seoTitle" value="${n.seoTitle }" /><td><font color="whitesmoke">SEO描述:</font></td><td><input type="text" name="seoDes" value="${n.seoDes}" /></td><td><font color="whitesmoke">SEO关键字:</font></td><td><input type="text" name="seoKey" value="${n.seoKey }" /></td>
</tr>
<tr>
 <td><font color="whitesmoke">是否审核</font></td><td><select name="audit"><option value="1" >是</option><option value="0">否</option></select></td> 
 <td><font color="whitesmoke">是否置顶</font></td><td><select name="placTop"><option value="1" >是</option><option value="0">否</option></select></td>
 <td><font color="whitesmoke">是否推荐</font></td><td><select name="recommend"><option value="1">是</option><option value="0">否</option></select></td> 
 </tr> 
 <tr><td><font color="whitesmoke">内容:</font></td></tr>
 <tr><td colspan="6"><script  name="text" id="editor2" type="text/plain" style="width:1024px;height:500px;" value="${n.text}"></script></td></tr>
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