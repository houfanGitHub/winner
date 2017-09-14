<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码设置</title>
   <link href="/winner/css/bootstrap.min.css" rel="stylesheet">
   <script src="/winner/js/jquery.min.js"></script>
   <script src="/winner/js/bootstrap.min.js"></script>
  
</head>
<body class="container">
	<div style="height: 10px"></div>
	<div class="row">
      <label class="col-sm-2 text-right">原密码</label>
      <div class="col-sm-4">
         <input type="password" class="form-control" id="password" 
            placeholder="请输入密码">
      </div>
      <div class="col-sm-6"> 
      		<span id="s1" style="display:none;color:red">输入不能为空!</span>
            <span id="m1" style="display:none;color:red">原密码错误!</span>
       </div>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
      <label class="col-sm-2 text-right">新密码</label>
      <div class="col-sm-4">
         <input type="password" class="form-control" id="password1" 
            placeholder="请输入密码">
            
      </div>
      <div class="col-sm-6"> 
      	<span id="s2" style="display:none;color:red">输入不能为空!</span>
      </div>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
      <label class="col-sm-2 text-right">重复新密码</label>
      <div class="col-sm-4">
         <input type="password" class="form-control" id="password2" 
            placeholder="请输入密码">
           
      </div>
       <div class="col-sm-6"> 
        <span id="s4" style="display:none;color:red">两次新密码输入不同!</span>
            <span id="s3" style="display:none;color:red">输入不能为空!</span>
       </div>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
   	<div class="col-sm-2"></div>
   	<div class="col-sm-4">
   		<button type="button" id="xg" class="btn btn-primary">确认修改</button>
   	</div>
   </div>
   <script type="text/javascript">
   		$("#xg").click(function(){
   			$("#s1").hide();
   			$("#s2").hide();
   			$("#s3").hide();
   			$("#s4").hide();
   			if($("#password").val()==""){
   				$("#s1").show();return;
   			}
   			if($("#password1").val()==""){
   				$("#s2").show();return;
   			}
   			if($("#password2").val()==""){
   				$("#s3").show();return;
   			}
   			if($("#password1").val()!=$("#password2").val()){
   				$("#s4").show();return;
   			}
   			$.post("/winner/system/toPasswordValidation",
   				{oldPassword:$("#password").val()},
   				function(falg){
   					if(!falg){
   						$("#m1").show();
   						return;
   					}else{
   						$.post("/winner/system/updatePassword",
   			   					{newPassword:$("#password1").val()},
   			   	   				function(falg){
   			   	   					if(falg){
   				   	   					alert("密码修改成功!");
   				   	   					$("#password").val("");
   				   	   					$("#password1").val("");
   				   	   					$("#password2").val("");
   				   	   					window.parent.document.location.href="/winner/itemweb/logout";
   			   	   					}else{
   			   	   						alert("密码修改失败!");
   			   	   					}
   			   	   				});
   					}
   				});
   			
   		});
   </script>   
</body>
</html>