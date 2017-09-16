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
			<button  class="btn btn-primary" data-toggle="modal" 
   				data-target="#addModal">新增</button>
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
   
   <!-- 新增modal -->
 <div class="modal fade" id="addModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button>
            <h4 class="modal-title" id="myModalLabel">
            	添加角色信息
            </h4>
         </div>
         <div class="modal-body">
            <form method="post"  class="form-horizontal" role="form">
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">角色名</label>
			      <div class="col-sm-4">
			         <input type="text" class="form-control" id="cname" name="cname">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="lastname" class="col-sm-2 control-label">角色描述</label>
			      <div class="col-sm-10">
			         <input type="text" class="form-control" id="remark" name="remark">
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
			if($("#cname").val()==""||$("#remark").val()==""){
				alert("添加信息不能为空");
				return;
			}
			$.post("/winner/system/addUserRole",
					{cname:$("#cname").val(),remark:$("#remark").val()},
					function(falg){
					if(falg){
						alert("添加成功");
						$("#cname").val("");
						$("#remark").val("");
						window.parent.document.getElementById("userRole").click();
					}else{
						alert("添加失败");
					}
			});
		});
	});
</script>
</body>
</html>