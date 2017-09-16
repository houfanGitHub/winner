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
			<button  class="btn btn-primary" data-toggle="modal" 
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
	         <th class="cname">
	         <c:forEach items="${user.userRoleRelations }" var="roles">
	         	${roles.userRole.cname }
	         </c:forEach>
	         </th>
	         <th>${user.mobile_Phone }</th>   
	         <th>${user.createDate }</th>
	         <th>
	         	<button class="btn btn-primary" data-toggle="modal" data-target="#xgModal" 
	         	onclick="toUpdateModal(this,${user.id},'${user.name }','${user.userName }',${user.status })">
  						修改</button>&nbsp;
	        	<button class="btn btn-primary" id="del" onclick="toDel(${user.id })">删除</button>
	         </th>
	     </tr>
     </c:forEach>
   </tbody>
   </table>
   
   <script type="text/javascript">
   		function toUpdateModal(thisObj,id,uname,userName,ustauts){
   			var cname = $(thisObj).parents("tr").find(".cname").text().trim();
   			$("#update_id").val(id);
   			$("#update_name").val(uname);
   			$("#update_userName").val(userName);
   			$("#update_cname").val();
   			if(cname=="系统管理员"){
   				$("#cname1").attr("selected",true);
   			}else if(cname=="普通管理员"){
   				$("#cname2").attr("selected",true);
   			}else if(cname=="VIP用户"){
   				$("#cname3").attr("selected",true);		
			}else if(cname=="普通用户"){
				$("#cname4").attr("selected",true);
			}
			if(ustauts==0){
				$("#sta1").attr("selected",true);
			}
			if(ustauts==1){
				$("#sta2").attr("selected",true);
			}
			if(ustauts==2){
				$("#sta3").attr("selected",true);
			}
// 			$("#update_status").find("option[value="+ustauts+"]").attr("selected",true);	
   		}
   </script>
   
  <div class="modal fade" id="xgModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button>
            <h4 class="modal-title" id="myModalLabel">
            	修改账户信息
            </h4>
         </div>
         <div class="modal-body">
			<form method="post"  class="form-horizontal" role="form">
				<input type="hidden" name="id" id="update_id">
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">用户名</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="update_name" name="name"
			            placeholder="请输入用户名">
			      </div>
			      <label for="firstname" class="col-sm-2 control-label">真实姓名</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="update_userName" name="userName"
			            placeholder="请输入真实姓名">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="lastname" class="col-sm-2 control-label">角色</label>
			      <div class="col-sm-4">
				      <select class="form-control" id="update_cname" name="status">
				      		<option value="1" id="cname1">系统管理员</option>
				      		<option value="2" id="cname2">普通管理员</option>
				      		<option value="3" id="cname3">VIP用户</option>
				      		<option value="4" id="cname4">普通用户</option>
				      	</select>
			      </div>
			      <label for="lastname" class="col-sm-2 control-label">账号状态</label>
			      <div class="col-sm-4">
			      	<select class="form-control" id="update_status" name="status">
			      		<option value="0" id="sta1">正常</option>
			      		<option value="1" id="sta2">锁定</option>
			      		<option value="2" id="sta3">删除</option>
			      	</select>
			      </div>
			   </div>
            </form>         
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal" id="update_gb">关闭            </button>
            <button type="button" class="btn btn-primary" onclick="toUserUpdate();">
               提交更改            </button>
         </div>
      </div></div></div>
   
   <script type="text/javascript">
   		function toDel(id){
   			$.post("/winner/system/deleteUser/"+id,function(falg){
   				if(falg){
   					alert("删除成功");
   					window.parent.document.getElementById("usersid").click();
   				}else{
   					alert("删除失败");
   				}
   			});
   		}
   		
   		function toUserUpdate(){
   			if($("#update_name").val()==""||$("#update_userName").val()==""||$("#update_phone").val()==""||$("#update_password").val()==""){
  				alert("修改的信息不能为空");
  				return;
  			}
  			$.post("/winner/system/toUserUpdate/",
  					{id:$("#update_id").val(),
  						ustauts:$("#update_status").val(),
  						cname:$("#update_cname").val()},
  					function(falg){
  						if(falg){
  							alert("修改成功");
  							$("#update_name").val("");
  							$("#update_userName").val("");
  							$("#update_id").val("");
  							$("#update_status").val("");
  							$("#update_cname").val("");
  							$("#update_gb").click();
  							window.parent.document.getElementById("usersid").click();
  						}else{
  							alert("修改失败");
  						}
  			});
   		}
   </script>
   
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
            <button type="button" class="btn btn-primary" id="tj">提交添加</button>
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
//       							$.post("/winner/system/asynchronousUsers",function(){
      								window.parent.document.getElementById("usersid").click();
//       							});
      						}else{
      							alert("添加失败");
      						}
      			});
      		});
      	});
      </script>
</body>
</html>