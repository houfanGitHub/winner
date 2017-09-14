<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色设置</title>
   <link href="/winner/css/bootstrap.min.css" rel="stylesheet">
   <script src="/winner/js/jquery.min.js"></script>
   <script src="/winner/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="row">
		<br>
		<p class="col-md-12">
			<button  class="btn btn-primary btn-lg" data-toggle="modal" 
   				data-target="#myModal">新增</button>
   		</p>
	</div>
	<table class="table table-bordered table-hover">
   <thead>
      <tr>
         <th>序号</th>
         <th>角色名</th>
         <th>角色描述</th>
         <th>创建时间</th>
         <th>菜单配置</th>
      </tr>
   </thead>
   <tbody>
     <c:forEach items="${roleList }" var="roles">
     	<tr>
	     	<td>${roles.id }</td>
	     	<th>${roles.cname }</th>
	         <th>${roles.remark }</th>
	         <th>${roles.createDate }</th>   
	         <th><button class="btn btn-primary">菜单配置</button></th>
	     </tr>
     </c:forEach>
   </tbody>
   </table>
   

</body>
</html>