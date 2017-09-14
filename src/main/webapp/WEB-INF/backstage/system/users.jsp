<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户管理</title>
   <link href="/winner/css/bootstrap.min.css" rel="stylesheet">
   <script src="/winner/js/jquery.min.js"></script>
   <script src="/winner/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="row">
		<br>
		<p class="col-md-12"><button>新增</button></p>
	</div>
	<table class="table table-bordered">
   <thead>
      <tr>
         <th>序号</th>
         <th>用户名</th>
         <th>角色</th>
         <th>手机号</th>   
         <th>创建时间</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
     <c:forEach items="${userList }" var="user">
     	<tr>
	     	<td>${user.id }</td>
	     	<th>${user.userName }</th>
	         <th>${user.identity }</th>
	         <th>${user.mobile_Phone }</th>   
	         <th>${user.createDate }</th>
	         <th><button>修改</button>&nbsp;<button>删除</button></th>
	     </tr>
     </c:forEach>
   </tbody>
   </table>
</body>
</html>