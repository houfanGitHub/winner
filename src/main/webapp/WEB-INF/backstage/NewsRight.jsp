<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/winner/backstage/show/jquery-1.9.1.min.js"></script>
<link href="/winner/backstage/show/bootstrap.min.css" rel="stylesheet"> 
<title>Insert title here</title>
</head>
<body>
<form>
<table class="table table-hover" style='table-layout:fixed;'>
<tr style="height:8px">
<td>序号</td><td>标题</td><td>副标题</td><td>简介</td><td>作者</td><td>内容</td><td>是否审核</td><td>是否置顶</td><td>是否推荐</td>
<td>添加时间</td><td>添加人ID</td><td>标签</td><td>链接地址</td><td>点击数量</td><td>封面图片</td><td>来源</td><td>附件地址</td>
<td>SEO描述</td><td>SEO关键字</td><td>SEO标题</td><td>修改ID</td><td>修改时间</td><td>操作</td>
</tr>
<c:forEach items="${list}" var="n">
<tr style="height:8px">
<td>${n.id }</td><td>${n.title }</td> <td>${n.subTitle}</td><td>${n.info }</td><td>${n.author}</td><td>${n.text}</td>
<td>${n.audit}</td><td>${n.placTop}</td><td>${n.recommend }</td><td>${n.addTime }</td><td>${n.addId}</td><td>${n.label }</td>
<td>${n.link}</td><td>${n.clickNumber }</td><td>${n.cPhoto}</td><td>${n.source}</td><td>${n.filelink }</td>
<td>${n.seoDes}</td><td>${n.seoKey }</td><td>${n.seoTitle}</td><td>${n.updId}</td><td>${n.updTime}</td> 
</tr>
</c:forEach>
</table>
</form>
</body>
</html>