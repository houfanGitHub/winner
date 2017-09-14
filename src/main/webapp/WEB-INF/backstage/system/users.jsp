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
		<p class="col-md-12">
			<button  class="btn btn-primary btn-lg" data-toggle="modal" 
   				data-target="#myModal">新增</button>
   		</p>
	</div>
	<table class="table table-bordered table-hover">
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
	         <th>
	         	<button class="btn btn-primary">修改</button>&nbsp;
	        	<button class="btn btn-primary">删除</button>
	         </th>
	     </tr>
     </c:forEach>
   </tbody>
   </table>
   
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button>
            <h4 class="modal-title" id="myModalLabel">
            	添加账户信息
            </h4>
         </div>
         <div class="modal-body">
            <form method="post"  class="form-horizontal" role="form">
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">用户名</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="name" name="name"
			            placeholder="请输入用户名">
			      </div>
			      <label for="firstname" class="col-sm-2 control-label">真实姓名</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="userName" name="userName"
			            placeholder="请输入真实姓名">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="lastname" class="col-sm-2 control-label">手机号</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="phone" name="mobile_Phone" 
			            placeholder="请输入手机号">
			      </div>
			      <label for="lastname" class="col-sm-2 control-label">登录密码</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="password" name="password"
			            placeholder="请输入登录密码">
			      </div>
			   </div>
            </form>
         </div>
         
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" id="gb">关闭 </button>
            <button type="button" class="btn btn-primary" id="tj">提交更改</button>
         </div>
      </div>
      <script type="text/javascript">
      	$(function(){
      		$("#tj").click(function(){
      			if($("#name").val()==""){
      				alert("用户名不能为空");
      				return;
      			}
      			if($("#userName").val()==""){
      				alert("真实姓名不能为空");
      				return;
      			}
      			
      			if($("#phone").val()==""){
      				alert("手机号不能为空");
      				return;
      			}
      			if($("#password").val()==""){
      				alert("登录密码不能为空");
      				return;
      			}
      			$.post("/winner/system/userAdd",
      					{name:$("#name").val(),userName:$("#userName").val(),
      						phone:$("#phone").val(),password:$("#password").val()},
      					function(falg){
      						if(falg){
      							alert("添加成功");
      							$("#name").val("");
      							$("#userName").val("");
      							$("#phone").val("");
      							$("#password").val("");
      							$("#gb").click();
      							$.post("/winner/system/asynchronousUsers",function(){
      								window.parent.document.getElementById("usersid").click();
      							});
      						}else{
      							alert("添加失败");
      						}
      			});
      		});
      	});
      </script>
</body>
</html>